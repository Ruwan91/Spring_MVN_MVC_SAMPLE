package com.vclab.springweb.dao;

import com.vclab.springweb.model.Customer;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("customerDao")
public class CustomerDaoImpl extends AbstractDao<Integer, Customer> implements CustomerDao {

    public void saveCustomer(Customer customer) {
        persist(customer);
    }

    @SuppressWarnings("unchecked")
    public List<Customer> getAllCustomers() {
        Criteria criteria=getSession().createCriteria(Customer.class);
        return (List<Customer>) criteria.list();
    }

    public void deleteCustomer(int id) {
        Query query= getSession().createSQLQuery("DELETE FROM customer c WHERE c.cid = :id");
        query.setInteger("cid",id);
        query.executeUpdate();
    }

    public Customer findCustomerById(int id) {
        Criteria criteria=getSession().createCriteria(Customer.class);
        criteria.add(Restrictions.eq("cid",id));
        return (Customer) criteria.uniqueResult();
    }

    @Override
    public void updateCustomer(Customer customer) {
        getSession().update(customer);
    }
}
