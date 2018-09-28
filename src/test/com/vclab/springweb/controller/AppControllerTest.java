package com.vclab.springweb.controller;

import com.vclab.springweb.model.Customer;
import com.vclab.springweb.service.CustomerService;
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

import static org.mockito.Mockito.*;

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
        customers= getAllCustomers();
    }

    @Test
    public void listEmployees(){
        when(customerService.getAllCustomers()).thenReturn(customers);
        Assert.assertEquals(appController.getAllCustomer(),"customerlist");
        Assert.assertEquals(modelMap.get("customerlist"),customers);
        verify(customerService,atLeastOnce()).getAllCustomers();
    }

    @Test
    public void saveNewCustomer(Customer customer){
        Assert.assertTrue(customer.getCid()==CUST_ID, "Customer ID is correct in controller...");
        Assert.assertTrue(customer.getName().equals(CUST_NAME), "Customer Name is correct in controller...");
        Assert.assertTrue(customer.getAddress().equals(ADDRESS), "Customer Address is correct in controller...");
        Assert.assertTrue(customer.getNic().equals(NIC), "Customer Nic is correct in controller...");
        Assert.assertTrue(customer.getActive()==true,"Customer is available in controller...");
    }


    public List<com.vclab.springweb.model.Customer> getAllCustomers() {
        Customer customer=new Customer();
        customer.setCid(1);
        customer.setName("Ruwan Peiris");
        customer.setAddress("Moratuwa");
        customer.setNic("123456789V");
        customer.setActive(true);

        Customer customer2=new Customer();
        customer2.setCid(2);
        customer2.setName("Yasiru Perera");
        customer2.setAddress("Colombo");
        customer2.setNic("789456123VV");
        customer2.setActive(true);
        customers.add(customer);
        customers.add(customer2);
        return customers;
    }


}
