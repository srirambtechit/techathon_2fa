package com.digitalbank.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.digitalbank.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String>{

}
