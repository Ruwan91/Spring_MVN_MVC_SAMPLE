package main.com.vclab.springweb.dao;

import main.com.vclab.springweb.model.Customer;

import java.util.List;

public interface CustomerDao {

    void saveCustomer(Customer customer);

    List getAllCustomers();

    void deleteCustomer(int id);

    Customer findCustomerById(int id);

    void updateCustomer(Customer customer);

}
