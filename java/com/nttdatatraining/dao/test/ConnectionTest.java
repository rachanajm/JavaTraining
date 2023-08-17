package com.nttdatatraining.dao.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


import java.sql.SQLException;
import org.junit.Test;

import com.nttdatatraining.connection.DbPooledConnection;

/**
 * 
 * @author Rohit
 *
 */

public class ConnectionTest {

  DbPooledConnection db = new DbPooledConnection();

  @Test
  public void conPass() throws SQLException {
    assertNotNull(DbPooledConnection.getdatabaseconnection());
  }

  @Test
  public void conFail() throws SQLException {
    assertNotNull(DbPooledConnection.getdatabaseconnection());
  }
}
