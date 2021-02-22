package com.mariadbench.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mariadbench.domain.DBConnection;
import com.mariadbench.repositories.DBConnectionRepository;

/**
 * Created by Pavel P on 2/19/2021.
 */
@Service
public class DBConnectionServiceImpl implements DBConnectionService {

    private DBConnectionRepository dbConnectionRepository;

    @Autowired
    public DBConnectionServiceImpl(DBConnectionRepository dbConnectionRepository) {
        this.dbConnectionRepository = dbConnectionRepository;
    }

    /**
     * Get list of stored DB connections in the Database
     * 
     * @return List<DBConnection>
     */
    @Override
    public List<DBConnection> listAll() {
        List<DBConnection> dbConnections = new ArrayList<>();
        dbConnectionRepository.findAll().forEach(dbConnections::add);
        return dbConnections;
    }
    
    /**
     * Get connection by id
     * 
     * @param id - primary key of the <DBConnection> object in the Database
     * @return <DBConnection> object
     */
    @Override
    public DBConnection getById(Long id) {
        return dbConnectionRepository.findById(id).orElse(null);
    }
    
    /**
     * Save or update <DBConnection> object in the Database
     * if the object has _id populated, it's updated. Otherwise, new one created 
     * 
     * @param dbConnection - the object to be saved
     * @return <DBConnection> - saved object with assigned _id
     */
    @Override
    public DBConnection saveOrUpdate(DBConnection dbConnection) {
    	dbConnectionRepository.save(dbConnection);
        return dbConnection;
    }
    
    /**
     * Delete <DBConnection> object from the Database
     * 
     * @param id - primary key of the <DBConnection> object in the Database
     */
    @Override
    public void delete(Long id) {
    	dbConnectionRepository.deleteById(id);
    }

}
