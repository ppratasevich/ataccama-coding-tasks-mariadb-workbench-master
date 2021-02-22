package com.mariadbench.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mariadbench.dto.ColumnDescription;
import com.mariadbench.dto.ColumnStats;
import com.mariadbench.dto.TableDescription;
import com.mariadbench.services.ConnectionMetadataService;
import com.mariadbench.services.DBConnectionService;

/**
 * Created by Pavel P on 2/19/2021.
 */
@RestController
public class ConnectionMetadataRestController {

	@Autowired
    private DBConnectionService dbConnectionService;
	
	@Autowired
	private ConnectionMetadataService connectionMetadataService;
    
    @RequestMapping("listSchemas")
    public List<String> listSchemas(@RequestParam(value = "id") Long id){
    	return connectionMetadataService.listDatabases(dbConnectionService.getById(id));
    }
        
    @RequestMapping("listTables")
    public List<String> listTables(@RequestParam(value = "id") Long id){
    	return connectionMetadataService.listTables(dbConnectionService.getById(id));
    }
    
    @RequestMapping(value = "listColumns")
    public List<ColumnDescription> listColumns(@RequestParam(value = "id") Long id, @RequestParam(value = "table") String tableName){
    	return connectionMetadataService.listColumns(dbConnectionService.getById(id), tableName);
    }
    
    @RequestMapping(value = "previewData")
    public List<List<String>> previewData(@RequestParam(value = "id") Long id, @RequestParam(value = "table") String tableName){
    	return connectionMetadataService.previewData(dbConnectionService.getById(id), tableName);
    }
    
    @RequestMapping(value = "columnsStats")
    public List<ColumnStats> getColumnsStats(@RequestParam(value = "id") Long id, @RequestParam(value = "table") String tableName){
    	return connectionMetadataService.getColumnsStats(dbConnectionService.getById(id), tableName);
    }
    
    @RequestMapping(value = "tablesStats")
    public List<TableDescription> gettablesStats(@RequestParam(value = "id") Long id){
    	return connectionMetadataService.getTablesStats(dbConnectionService.getById(id));
    }

}
