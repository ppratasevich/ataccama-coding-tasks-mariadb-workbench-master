package com.mariadbench.dto;

public class ColumnStats {
	
	private String columnName;
	private String minValue;
	private String maxValue;
	private Float nullsRatio;
	private Float avgLength;
	private Float avgFrequency;
	
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getMinValue() {
		return minValue;
	}
	public void setMinValue(String minValue) {
		this.minValue = minValue;
	}
	public String getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(String maxValue) {
		this.maxValue = maxValue;
	}
	public Float getNullsRatio() {
		return nullsRatio;
	}
	public void setNullsRatio(Float nullsRatio) {
		this.nullsRatio = nullsRatio;
	}
	public Float getAvgLength() {
		return avgLength;
	}
	public void setAvgLength(Float avgLength) {
		this.avgLength = avgLength;
	}
	public Float getAvgFrequency() {
		return avgFrequency;
	}
	public void setAvgFrequency(Float avgFrequency) {
		this.avgFrequency = avgFrequency;
	}	
}
