package com.mariadbench.dto;

import java.sql.Date;

public class TableDescription {
	
	private String schemaName;
	private String tableName;
	private Long rowCount;
	private Long avgRowLength;
	private Long dataLength;
	private Date createDate;
	
	public String getSchemaName() {
		return schemaName;
	}
	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public Long getRowCount() {
		return rowCount;
	}
	public void setRowCount(Long rowCount) {
		this.rowCount = rowCount;
	}
	public Long getAvgRowLength() {
		return avgRowLength;
	}
	public void setAvgRowLength(Long avgRowLength) {
		this.avgRowLength = avgRowLength;
	}
	public Long getDataLength() {
		return dataLength;
	}
	public void setDataLength(Long dataLength) {
		this.dataLength = dataLength;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
}
