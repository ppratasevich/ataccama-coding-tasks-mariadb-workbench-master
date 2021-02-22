package com.mariadbench.repositories;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mariadbench.domain.DBConnection;
import com.mariadbench.repositories.DBConnectionRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DBConnectionRepositoryTest {

    private static final String CONNECTION_NAME = "TestConnection";
    private static final String HOST_NAME = "localhost";
    private static final Integer PORT = 3306;
    private static final String DATABASE_NAME = "TestDB";
    private static final String USER_NAME = "user";
    private static final String PASSWORD = "password";

    @Autowired
    private DBConnectionRepository dbConnectionRepository;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testPersistence() {
        //given
    	DBConnection dbConnection = new DBConnection();
    	dbConnection.setName(CONNECTION_NAME);
    	dbConnection.setHostname(HOST_NAME);
    	dbConnection.setPort(PORT);
    	dbConnection.setDatabaseName(DATABASE_NAME);
    	dbConnection.setUsername(USER_NAME);
    	dbConnection.setPassword(PASSWORD);

        //when
        dbConnectionRepository.save(dbConnection);

        //then
        Assert.assertNotNull(dbConnection.getId());
        DBConnection newdbConnection = dbConnectionRepository.findById(dbConnection.getId()).orElse(null);
        Assert.assertEquals((Long) 1L, newdbConnection.getId());
        Assert.assertEquals(CONNECTION_NAME, newdbConnection.getName());
        Assert.assertEquals(HOST_NAME, newdbConnection.getHostname());
        Assert.assertEquals(PORT, newdbConnection.getPort());
        Assert.assertEquals(DATABASE_NAME, newdbConnection.getDatabaseName());
        Assert.assertEquals(USER_NAME, newdbConnection.getUsername());
        Assert.assertEquals(PASSWORD, newdbConnection.getPassword());
    }
}