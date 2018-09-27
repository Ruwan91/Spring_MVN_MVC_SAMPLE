package com.vclab.springweb.service;

import com.vclab.springweb.model.Customer;
import com.vclab.springweb.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public void saveCustomer(Customer customer) {
        customerDao.saveCustomer(customer);
    }

    @Override
    public List getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    @Override
    public void deleteCustomer(int id) {
        customerDao.deleteCustomer(id);
    }

    @Override
    public Customer findCustomerById(int id) {
        return customerDao.findCustomerById(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDao.updateCustomer(customer);
    }
}
