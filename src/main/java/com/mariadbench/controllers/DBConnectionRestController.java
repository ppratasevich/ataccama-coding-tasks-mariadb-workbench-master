package com.mariadbench.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mariadbench.domain.DBConnection;
import com.mariadbench.services.DBConnectionService;

/**
 * Created by Pavel P on 2/19/2021.
 */
@RestController
public class DBConnectionRestController {

    private DBConnectionService dbConnectionService;

    @Autowired
    public void setDBConnectionService(DBConnectionService dbConnectionService) {
        this.dbConnectionService = dbConnectionService;
    }
    
    @RequestMapping("/")
    public List<DBConnection> callList(){
        return listConnections();
    }
    
    @RequestMapping(value = "connection/new", method = RequestMethod.POST, headers = "Accept=application/json")
    public Long createDBConnection(@RequestBody DBConnection newConnection){
    	DBConnection savedDBConnection = dbConnectionService.saveOrUpdate(newConnection);
        return savedDBConnection.getId();
    }

    @RequestMapping("connection/list")
    public List<DBConnection> listConnections(){
        return dbConnectionService.listAll();
    }
    
    @RequestMapping("/connection/show/{id}")
	public DBConnection getDBConnection(@PathVariable Long id){
	    return dbConnectionService.getById(id);
	}
    
    @RequestMapping("/connection/delete/{id}")
    public List<DBConnection> delete(@PathVariable String id){
    	dbConnectionService.delete(Long.valueOf(id));
        return listConnections();
    }

}
