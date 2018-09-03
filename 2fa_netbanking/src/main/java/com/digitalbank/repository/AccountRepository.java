package com.digitalbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.digitalbank.model.Account;
import com.digitalbank.model.AccountPrimaryDetails;

@Repository
public interface AccountRepository extends CrudRepository<Account, AccountPrimaryDetails> {
	
	@Query("select acc from Account acc where acc.custNumber = :custNumber")
	public List<Account> findByCustNumber(@Param("custNumber") String custNumber);

}
