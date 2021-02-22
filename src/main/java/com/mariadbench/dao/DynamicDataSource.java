package com.mariadbench.dao;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Component;

import com.mariadbench.domain.DBConnection;

/**
 * Created by Pavel P on 2/19/2021.
 */
@Component
public class DynamicDataSource {
	
	private static final String MARIADB_URL_PREFIX = "jdbc:mariadb://";
	private static final String MARIADB_DRIVER = "org.mariadb.jdbc.Driver";
	
	
	/**
	 * Create custom DataSource using specified connection parameters
	 * 
	 * @param connection - <DBConnection> object with connection parameters
	 * @return DataSource
	 */
	public DataSource createDataSource(DBConnection connection) {
		DataSource dataSource = null;
		DataSourceBuilder<?> builder = DataSourceBuilder.create();
		builder.url(MARIADB_URL_PREFIX + connection.getHostname() + ":" + connection.getPort() + "/" + connection.getDatabaseName());
		builder.username(connection.getUsername());
		builder.password(connection.getPassword());
		builder.driverClassName(MARIADB_DRIVER);
		dataSource = builder.build();
		return dataSource;
	}
}
