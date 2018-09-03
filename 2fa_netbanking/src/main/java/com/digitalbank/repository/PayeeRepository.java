package com.digitalbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.digitalbank.model.CustomerPayee;
import com.digitalbank.model.PayeePrimaryDetails;

@Repository
public interface PayeeRepository extends CrudRepository<CustomerPayee, PayeePrimaryDetails> {

	@Query("select payee from CustomerPayee payee where payee.custNumber = :custNumber")
	public List<CustomerPayee> findByCustNumber(@Param("custNumber") String custNumber);
}
