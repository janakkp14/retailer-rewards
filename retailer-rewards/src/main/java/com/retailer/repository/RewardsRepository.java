package com.retailer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.retailer.entities.Transaction;

@Repository
public interface RewardsRepository extends JpaRepository<Transaction, Integer>{
    
	List<Transaction> findByCustomerId(String id);
	
	public List<String> findAllCustomers();

}
