package com.mariadbench.services;

import java.util.List;

import com.mariadbench.domain.DBConnection;

/**
 * Created by Pavel P on 2/19/2021.
 */
public interface DBConnectionService {

    /**
     * Get list of stored DB connections in the Database
     * 
     * @return List<DBConnection>
     */
    List<DBConnection> listAll();

    /**
     * Get connection by id
     * 
     * @param id - primary key of the <DBConnection> object in the Database
     * @return <DBConnection> object
     */
    DBConnection getById(Long id);

    /**
     * Save or update <DBConnection> object in the Database
     * if the object has _id populated, it's updated. Otherwise, new one created 
     * 
     * @param dbConnection - the object to be saved
     * @return <DBConnection> - saved object with assigned _id
     */
    DBConnection saveOrUpdate(DBConnection dbConnection);

    /**
     * Delete <DBConnection> object from the Database
     * 
     * @param id - primary key of the <DBConnection> object in the Database
     */
    void delete(Long id);
}
