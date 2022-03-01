package com.webcustomertracker.dao;

import com.webcustomertracker.model.Customer;
import com.webcustomertracker.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends BaseRepository<Customer, Integer> {
}
