package com.webcustomertracker.service;

import com.webcustomertracker.model.Customer;

import java.util.List;

public interface IService {

    List<Customer> getCustomers();

    Customer getCustomerById(Integer id);

    Integer SaveCustomer(Customer customer);

    Customer removeCustomer(Integer id);

    Customer updateCustomer(Integer id, Customer customer);

}
