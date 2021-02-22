package com.mariadbench.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mariadbench.domain.DBConnection;

/**
 * Created by jt on 1/10/17.
 */
public interface DBConnectionRepository extends CrudRepository<DBConnection, Long> {
}
