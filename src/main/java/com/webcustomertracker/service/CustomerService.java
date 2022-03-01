package com.webcustomertracker.service;

import com.webcustomertracker.dao.CustomerDao;
import com.webcustomertracker.model.Customer;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class CustomerService implements IService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<Customer> getCustomers() {
        return customerDao.findAll();
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customerDao.findById(id).get();
    }

    @Override
    public Integer SaveCustomer(Customer customer) {
        return customerDao.save(customer).getId();
    }

    @Override
    public Customer removeCustomer(Integer id) {
        Customer customer = getCustomerById(id);
        customerDao.delete(customer);
        return customer;
    }

    @Override
    public Customer updateCustomer(Integer id, Customer customer) {

        Customer customerBase = customerDao.getById(id);
        customerBase.setId(customer.getId());
        customerBase.setFirstName(customer.getFirstName());
        customerBase.setLastName(customer.getLastName());
        customerBase.setEmail(customer.getEmail());

        customerDao.save(customerBase);
        return customerBase;

    }
}
