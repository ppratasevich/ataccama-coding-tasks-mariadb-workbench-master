package com.mariadbench.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;
import org.springframework.stereotype.Service;

import com.mariadbench.dao.DynamicDataSource;
import com.mariadbench.domain.DBConnection;
import com.mariadbench.dto.ColumnDescription;
import com.mariadbench.dto.ColumnStats;
import com.mariadbench.dto.TableDescription;

/**
 * Created by Pavel P on 2/19/2021.
 */
@Service
public class ConnectionMetadataServiceImpl implements ConnectionMetadataService {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	private DynamicDataSource dynamicDataSource;
	
	@Autowired
	private void setDynamicDataSource(DynamicDataSource dynamicDataSource) {
		this.dynamicDataSource = dynamicDataSource;
	}
	
	/**
	 * Get list of databases in the specified connection
	 * 
	 * @param dbConnection - <DBConnection> object
	 * @return List<String> - list of database names
	 */
	@Override
	public List<String> listDatabases(DBConnection dbConnection) {
		jdbcTemplate.setDataSource(dynamicDataSource.createDataSource(dbConnection));
    	return jdbcTemplate.query("show databases", (rs, rowNum) -> {
    		return rs.getString(1);
    	});
	}

	/**
     * Get list of tables in the specified database
     * 
     * @param dbConnection - <DBConnection> object
     * @return List<String> - list of table names
     */
	@Override
	public List<String> listTables(DBConnection dbConnection) {
		jdbcTemplate.setDataSource(dynamicDataSource.createDataSource(dbConnection));
    	return jdbcTemplate.query("show tables", (rs, rowNum) -> {
    		return rs.getString(1);
    	});
	}

	/**
     * Get details about each column in the specified table
     * 
     * @param dbConnection - <DBConnection> object
     * @param tableName - table name
     * @return List<ColumnDescription> - list of column description objects
     */
	@Override
	public List<ColumnDescription> listColumns(DBConnection dbConnection, String tableName) {
		jdbcTemplate.setDataSource(dynamicDataSource.createDataSource(dbConnection));
		String sql = "SHOW COLUMNS FROM " + tableName + " FROM " + dbConnection.getDatabaseName(); //DB and Table name require additional validation to avoid SQL injections through API
		
		List<ColumnDescription> result = jdbcTemplate.query(sql, (rs, rowNum) -> {
			ColumnDescription column = new ColumnDescription();
			column.setColumnName(rs.getString(1));
			column.setColumnType(rs.getString(2));
			column.setNullable(rs.getString(3).toLowerCase().equals("yes"));
			column.setKey(rs.getString(4));
			column.setDefaultValue(rs.getString(5));
			column.setExtra(rs.getString(6));
    		return column;
    	});
				
		return result;
	}

	/**
     * Fetch first 50 rows from the specified table
     * 
     * @param dbConnection - <DBConnection> object
     * @param tableName - table name
     * @return List<List<String>> - list of table rows. The first row contains column names
     */
	@Override
	public List<List<String>> previewData(DBConnection dbConnection, String tableName) {
		List<List<String>> result = new ArrayList<>();
		jdbcTemplate.setDataSource(dynamicDataSource.createDataSource(dbConnection));
		String sql = "SELECT * FROM " + tableName + " LIMIT 50"; //Table name requires additional validation to avoid SQL injections through API
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
		SqlRowSetMetaData rsmd =  rs.getMetaData();
		String[] columnNames = rsmd.getColumnNames();
		int columnCount = columnNames.length;
		result.add(Arrays.asList(columnNames));
		while (rs.next()) {
			List<String> rowResult = new ArrayList<>();
			for(int i = 1; i <= columnCount; i++) {
				rowResult.add(rs.getString(i));
			}
			result.add(rowResult);
		}
		return result;
	}
	
	/**
     * Get statistical information about each column in the specified table
     * Note: Only works with MariaDB versions 10.0.1 or later
     * 
     * @param dbConnection - <DBConnection> object
     * @param tableName - table name
     * @return
     */
	@Override
	public List<ColumnStats> getColumnsStats(DBConnection dbConnection, String tableName) {
		jdbcTemplate.setDataSource(dynamicDataSource.createDataSource(dbConnection));
		String sql = "SELECT column_name, min_value, max_value, nulls_ratio, avg_length, avg_frequency FROM mysql.column_stats WHERE db_name=? AND table_name=?";
		
		List<ColumnStats> result = jdbcTemplate.query(sql, new Object[]{dbConnection.getDatabaseName(), tableName}, (rs, rowNum) -> {
			ColumnStats columnStats = new ColumnStats();
			columnStats.setColumnName(rs.getString(1));
			columnStats.setMinValue(rs.getString(2));
			columnStats.setMaxValue(rs.getString(3));
			columnStats.setNullsRatio(rs.getFloat(4));
			columnStats.setAvgLength(rs.getFloat(5));
			columnStats.setAvgFrequency(rs.getFloat(6));

    		return columnStats;
    	});
		return result;
	}

	/**
     * Get statistical information about each table in the specified database
     * 
     * @param dbConnection - <DBConnection> object
     * @return List<TableDescription> - list of table description objects
     */
	@Override
	public List<TableDescription> getTablesStats(DBConnection dbConnection) {
		jdbcTemplate.setDataSource(dynamicDataSource.createDataSource(dbConnection));
		String sql = "SELECT table_schema, table_name, table_rows, avg_row_length, data_length, create_time FROM information_schema.tables WHERE table_schema=?";
		
		List<TableDescription> result = jdbcTemplate.query(sql, new Object[]{dbConnection.getDatabaseName()}, (rs, rowNum) -> {
			TableDescription tableStats = new TableDescription();
			tableStats.setSchemaName(rs.getString(1));
			tableStats.setTableName(rs.getString(2));
			tableStats.setRowCount(rs.getLong(3));
			tableStats.setAvgRowLength(rs.getLong(4));
			tableStats.setDataLength(rs.getLong(5));
			tableStats.setCreateDate(rs.getDate(6));
    		return tableStats;
    	});
		return result;
	}

}
