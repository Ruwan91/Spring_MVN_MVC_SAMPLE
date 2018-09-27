package com.vclab.springweb.dao;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
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
        Assert.assertNotNull(customerDao.findCustomerById(3));
    }

    @Test
    public void saveCustomer(){
        customerDao.saveCustomer(getSampleCutomer());
    }

    public main.com.vclab.springweb.model.Customer getSampleCutomer() {
        customer.setCid(5);
        customer.setName("Kevin Perera");
        customer.setAddress("Mt Lavina");
        customer.setNic("823476769V");
        customer.setActive(true);
        return customer;
    }
}
