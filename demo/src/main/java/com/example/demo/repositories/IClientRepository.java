package com.example.demo.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.example.demo.models.Client;

import jakarta.transaction.Transactional;


public interface IClientRepository extends JpaRepository<Client, Long> {
	
	@Query(value = "SELECT id, name, balance FROM client WHERE id = :id", nativeQuery = true)
	List<Map<String, String>> findBalanceById(Long id);
	
	@Query(value = "SELECT balance FROM cliente WHERE id =:id", nativeQuery = true)
	BigDecimal getBalace (Long id);

	@Modifying
	@Transactional
	@Query(value = "UPDATE client SET balance = :balance WHERE id = :id", nativeQuery = true)
	void updateBalanceById(Long id, Float balance);
}	
