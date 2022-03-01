package com.webcustomertracker.controller;

import com.webcustomertracker.config.CheckSomething;
import com.webcustomertracker.model.Customer;
import com.webcustomertracker.service.CustomerService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/cus")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @RequestMapping(path = "/allCustomer",method = RequestMethod.GET)
    @CheckSomething(roles = {"role1","role2"})
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getCustomers());
    }

    @RequestMapping(name = "/getCustomerById", method = RequestMethod.GET)
    @CheckSomething(roles = {"role1"})
    public ResponseEntity<?> getCustomerById(@RequestParam Integer id){
        Customer customer = service.getCustomerById(id);
        return new ResponseEntity<Customer>(customer,HttpStatus.OK);
    }

    @RequestMapping(path = "/saveCustomer",method = RequestMethod.POST)
    @CheckSomething(roles = {"role1","role2"})
    public ResponseEntity<?> save(@RequestBody Customer customer){
        return new ResponseEntity<>(service.SaveCustomer(customer), HttpStatus.CREATED);
    }

    @RequestMapping(name = "/remove",method = RequestMethod.DELETE)
    @CheckSomething(roles = {"role2"})
    public ResponseEntity<?> removeCustomer(@RequestParam Integer id){
        service.removeCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
