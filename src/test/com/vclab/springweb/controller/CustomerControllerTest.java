package com.vclab.springweb.controller;

import com.vclab.springweb.configuration.TestBeanConfig;
import com.vclab.springweb.model.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestBeanConfig.class})
public class CustomerControllerTest {

    @Autowired
    private AppController appController;


    @Test
    public void validateCustomerTestPositive() {
        Map map = new HashMap();
        map.put("cid", 1);
        map.put("name", "Ruwan Peiris");
        map.put("address", "Moratuwa");
        map.put("nic", "123456789V");
        map.put("active", true);
        ArrayList<ModelMap> allCustomer = appController.getAllCustomer();
        Assert.assertNotNull(allCustomer);
        if (allCustomer.isEmpty() != true) {
            for (ModelMap modelmap : allCustomer) {
//            Integer cid = (Integer) modelmap.get("cid");
//            String name = (String) modelmap.get("name");
//            String address = (String) modelmap.get("address");
//            String nic = (String) modelmap.get("nic");
//            Boolean active = (Boolean) modelmap.get("status");
                Assert.assertEquals(map.get("cid"), modelmap.get("cid"));
                Assert.assertEquals(map.get("name"), modelmap.get("name"));
                Assert.assertEquals(map.get("address"), modelmap.get("address"));
                Assert.assertEquals(map.get("nic"), modelmap.get("nic"));
                Assert.assertEquals(map.get("active"), modelmap.get("status"));
            }
        }
    }

    @Test
    public void saveCustomerTest(Customer cust) {
        ArrayList<Customer> allCustomers = getAllCustomers();
        Customer customer=new Customer();
        customer.setCid(5);
        customer.setName("Waruna");
        customer.setAddress("Panadura");
        customer.setNic("789456123V");
        customer.setActive(true);

        Assert.assertTrue("custome_reg"== appController.saveNewCustomer(customer,null,null));

    }

    private ArrayList<Customer> getAllCustomers() {
        ArrayList<ModelMap> allCustomer = appController.getAllCustomer();
        ArrayList<Customer> customers = new ArrayList<>();
        Customer customer=new Customer();
        if (allCustomer.isEmpty() != true) {
            for (ModelMap modelmap : allCustomer) {
                customer.setCid((Integer) modelmap.get("cid"));
                customer.setName((String) modelmap.get("name"));
                customer.setAddress((String) modelmap.get("address"));
                customer.setNic((String) modelmap.get("nic"));
                customer.setActive((Boolean) modelmap.get("status"));
                customers.add(customer);
            }
        }
        return customers;
    }
}
