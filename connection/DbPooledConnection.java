package com.nttdatatraining.connection;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class DbPooledConnection {

private static BasicDataSource ds = new BasicDataSource();
    
    static {
        ds.setUrl(Dbdetails.CONSTR);
        ds.setUsername(Dbdetails.USER_NAME);
        ds.setPassword(Dbdetails.PASSWORD);
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }
    
    public static Connection getdatabaseconnection() throws SQLException {
        return ds.getConnection();
    }

}
