package com.vclab.springweb.dao;

import org.dbunit.dataset.FilteredDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerDaoImplTest extends EntityDaoImplTest {

    @Autowired
    main.com.vclab.springweb.dao.CustomerDao customerDao;

    @Autowired
    main.com.vclab.springweb.model.Customer customer;

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataSet=new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Customer.xml"));
        return dataSet;
    }

    @Test
    public void findById(){
        Assert.assertNotNull(customerDao.findCustomerById(1));
    }

    @Test
    public void saveCustomer(){
        customerDao.saveCustomer(getSampleCutomer());
    }

    public main.com.vclab.springweb.model.Customer getSampleCutomer() {
        customer.setCid(2);
        customer.setName("Kasun");
        customer.setAddress("Moratuwa");
        customer.setNic("215487856V");
        customer.setActive(true);
        return customer;
    }
}
