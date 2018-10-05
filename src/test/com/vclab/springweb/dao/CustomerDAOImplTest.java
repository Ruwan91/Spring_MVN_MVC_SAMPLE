package com.vclab.springweb.dao;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerDAOImplTest {
    private final Integer CID = 1;
    private final String NAME = "Ruwan Peiris";
    private final String ADDRESS = "Moratuwa";
    private final String NIC = "123456789V";
    private final Boolean STATUS = true;

    private final Integer CID1 = 2;
    private final String NAME1 = "Kasun Perera";
    private final String ADDRESS1 = "Panadura";
    private final String NIC1 = "789456123V";

    @Test
    public void aCheckH2DBAndsetupTest() {
        String sql1 = "DROP TABLE IF EXISTS customer";
        String sql2 = "CREATE TABLE customer (cid INT PRIMARY KEY, name VARCHAR(200),address VARCHAR(200),nic VARCHAR(11),active TINYINT(4))";
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "ruwan", "vclab");
            int i = conn.createStatement().executeUpdate(sql1);
            int i1 = conn.createStatement().executeUpdate(sql2);

            Assert.assertTrue(i == 0 && i1 == 0);
            conn.close();
        } catch (SQLException | ClassNotFoundException se) {
            Logger.getLogger(String.valueOf(se));
        }
    }

    @Test
    public void bestSaveCustomerTestCase() {
        String sql = "INSERT INTO customer VALUES(" + CID + ",'" + NAME + "','" + ADDRESS + "','" + NIC + "'," + STATUS + ")";
        String sql1 = "INSERT INTO customer VALUES(" + CID1 + ",'" + NAME1 + "','" + ADDRESS1 + "','" + NIC1 + "'," + STATUS + ")";
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "ruwan", "vclab");
            int i = conn.createStatement().executeUpdate(sql);
            int i1 = conn.createStatement().executeUpdate(sql1);
            Assert.assertTrue(i > 0);
            Assert.assertTrue(i1 > 0);
            conn.close();
        } catch (SQLException | ClassNotFoundException se) {
            Logger.getLogger(String.valueOf(se));
        }

    }

    @Test
    public void callGetAllCustomersTestCase() {
        String sql = "SELECT * FROM customer";
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","ruwan", "vclab");
            int i = conn.createStatement().executeUpdate(sql);
            Assert.assertTrue(i > 0 );
            conn.close();
        }catch (SQLException| ClassNotFoundException e){
            Logger.getLogger(String.valueOf(e));
        }
    }

    @Test
    public void deleteCustomerTestCase() {
        String sql="DELETE FROM customer where cid="+ CID1;
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "ruwan", "vclab");
            int i = conn.createStatement().executeUpdate(sql);
            Assert.assertTrue(i > 0);
            conn.close();
        }catch (ClassNotFoundException | SQLException e){
            Logger.getLogger(String.valueOf(e));
        }
    }

    @Test
    public void findCustomerByIdTestCase() {
        String sql="SELCT * FROM customer where cid="+ CID;
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "ruwan", "vclab");
            int i = conn.createStatement().executeUpdate(sql);
            Assert.assertTrue(i > 0 );
            conn.close();
        }catch (ClassNotFoundException | SQLException e){
            Logger.getLogger(String.valueOf(e));
        }
    }

    @Test
    public void updateCustomerTestCase() {
        String nic = "777777777V";
        String sql="UPDATE customer SET nic='"+nic+"' WHERE cid="+CID;
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "ruwan", "vclab");
            int i = conn.createStatement().executeUpdate(sql);
            Assert.assertTrue(i > 0);
            Assert.assertFalse(i < 1 );
            Assert.assertEquals(1,i);
            conn.close();
        }catch (ClassNotFoundException | SQLException e){
            Logger.getLogger(String.valueOf(e));
        }
    }
}
