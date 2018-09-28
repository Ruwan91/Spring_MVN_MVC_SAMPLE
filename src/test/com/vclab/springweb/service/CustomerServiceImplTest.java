package com.vclab.springweb.service;

import com.vclab.springweb.model.Customer;
import org.mockito.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CustomerServiceImplTest {

    //private static final Integer CUST_ID = 1;
    //private final static String CUST_NAME = "Ruwan Peiris";
    //private final static String ADDRESS = "Moratuwa";
    //private final static String NIC = "123456789V";
    //private final static Boolean status = true;

    @Mock
    com.vclab.springweb.dao.CustomerDao customerDao;

    @InjectMocks
    com.vclab.springweb.service.CustomerServiceImpl customerService;

    @Spy
    List<com.vclab.springweb.model.Customer> customers = new ArrayList<Customer>();

    @BeforeClass
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        customers=getCustomerList();
    }



    @Test
    public void saveCustomer(Customer customer){
        Mockito.doNothing().when(customerDao).saveCustomer(any(Customer.class));
        customerService.saveCustomer(any(Customer.class));
        verify(customerDao,atLeastOnce()).saveCustomer(any(Customer.class));
//        Assert.assertTrue(customer.getCid()==CUST_ID, "Customer ID is correct in service...");
//        Assert.assertTrue(customer.getName().equals(CUST_NAME), "Customer Name is correct in service...");
//        Assert.assertTrue(customer.getAddress().equals(ADDRESS), "Customer Address is correct in service...");
//        Assert.assertTrue(customer.getNic().equals(NIC), "Customer Nic is correct in service...");
//        Assert.assertTrue(customer.getActive()==true,"Customer is available in service...");
    }

    @Test
    public void findAllCustomers(){
        when(customerDao.getAllCustomers()).thenReturn(customers);
        Assert.assertEquals(customerService.getAllCustomers(),customers);
    }

    private List<Customer> getCustomerList() {
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
