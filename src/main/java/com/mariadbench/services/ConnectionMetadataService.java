package com.mariadbench.services;

import java.util.List;

import com.mariadbench.domain.DBConnection;
import com.mariadbench.dto.ColumnDescription;
import com.mariadbench.dto.ColumnStats;
import com.mariadbench.dto.TableDescription;

/**
 * Created by Pavel P on 2/19/2021.
 */
public interface ConnectionMetadataService {
	
	/**
	 * Get list of databases in the specified connection
	 * 
	 * @param dbConnection - <DBConnection> object
	 * @return List<String> - list of database names
	 */
	List<String> listDatabases(DBConnection dbConnection);

    /**
     * Get list of tables in the specified database
     * 
     * @param dbConnection - <DBConnection> object
     * @return List<String> - list of table names
     */
    List<String> listTables(DBConnection dbConnection);
    
    /**
     * Get details about each column in the specified table
     * 
     * @param dbConnection - <DBConnection> object
     * @param tableName - table name
     * @return List<ColumnDescription> - list of column description objects
     */
    List<ColumnDescription> listColumns(DBConnection dbConnection, String tableName);
    
    /**
     * Fetch first 50 rows from the specified table
     * 
     * @param dbConnection - <DBConnection> object
     * @param tableName - table name
     * @return List<List<String>> - list of table rows. The first row contains column names
     */
    List<List<String>> previewData(DBConnection dbConnection, String tableName);
    
    /**
     * Get statistical information about each column in the specified table
     * Note: Only works with MariaDB versions 10.0.1 or later
     * 
     * @param dbConnection - <DBConnection> object
     * @param tableName - table name
     * @return
     */
    List<ColumnStats> getColumnsStats(DBConnection dbConnection, String tableName);
    
    /**
     * Get statistical information about each table in the specified database
     * 
     * @param dbConnection - <DBConnection> object
     * @return List<TableDescription> - list of table description objects
     */
    List<TableDescription> getTablesStats(DBConnection dbConnection);

}
