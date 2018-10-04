package com.vclab.springweb.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

@Repository
public class CustomerDAOImplTest {
    private final Integer CID = 1;
    private final String NAME = "Ruwan Peiris";
    private final String ADDRESS = "Moratuwa";
    private final String NIC = "123456789V";
    private final Boolean STATUS = true;

    @Test
    public void checkH2DBAndsetupTest(){
        String sql1 = "DROP TABLE IF EXISTS customer";
        String sql2 = "CREATE TABLE customer (cid INT PRIMARY KEY, name VARCHAR(200),address VARCHAR(200),nic VARCHAR(11),active TINYINT(4))";
        try {
            Class.forName("org.h2.Driver");
//            System.out.println("After Driver load");
            Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "ruwan", "vclab");
//            System.out.println("After the connection");
            conn.createStatement().executeUpdate(sql1);
            conn.createStatement().executeUpdate(sql2);

//            Assert.assertTrue( > 0);
            conn.close();
        } catch (SQLException | ClassNotFoundException se) {
            Logger.getLogger(String.valueOf(se));
        }
    }

    @Test
    public void saveCustomer() {
        String sql = "INSERT INTO customer VALUES(" + CID + ",'" + NAME + "','" + ADDRESS + "','" + NIC + "'," + STATUS + ")";
        try {
            Class.forName("org.h2.Driver");
//            System.out.println("After Driver load");
            Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "ruwan", "vclab");
//            System.out.println("After the connection");
            Assert.assertTrue(conn.createStatement().executeUpdate(sql) > 0);
            conn.close();
        } catch (SQLException | ClassNotFoundException se) {
            Logger.getLogger(String.valueOf(se));
        }

    }

    @Test
    public void getAllCustomersTest() {


    }

    @Test
    public void deleteCustomer() {

    }

    @Test
    public void findCustomerById() {

    }

    @Test
    public void updateCustomer() {

    }
}
