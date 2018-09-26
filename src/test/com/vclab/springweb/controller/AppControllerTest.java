package com.vclab.springweb.controller;

import main.com.vclab.springweb.controller.AppController;
import main.com.vclab.springweb.model.Customer;
import main.com.vclab.springweb.service.CustomerService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.ui.ModelMap;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AppControllerTest {

    private final static Integer CUST_ID = 1;
    private final static String CUST_NAME = "Ruwan Peiris";
    private final static String ADDRESS = "Moratuwa";
    private final static String NIC = "123456789V";
    private final static Boolean status = true;


    @Mock
    CustomerService customerService;

    @InjectMocks
    AppController appController;

    @Spy
    List<Customer> customers=new ArrayList<Customer>();

    @Spy
    ModelMap modelMap;

    @BeforeClass
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        customers= customerService.getAllCustomers();
    }

    @Test
    public void saveNewCustomer(Customer customer){
        Assert.assertTrue(customer.getCid()==CUST_ID, "Customer ID is correct in controller...");
        Assert.assertTrue(customer.getName().equals(CUST_NAME), "Customer Name is correct in controller...");
        Assert.assertTrue(customer.getAddress().equals(ADDRESS), "Customer Address is correct in controller...");
        Assert.assertTrue(customer.getNic().equals(NIC), "Customer Nic is correct in controller...");
        Assert.assertTrue(customer.getActive()==true,"Customer is available in controller...");
    }



}
