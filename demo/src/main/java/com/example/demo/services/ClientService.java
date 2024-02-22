package com.example.demo.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Client;
import com.example.demo.repositories.IClientRepository;

@Service
public class ClientService {

	@Autowired
	IClientRepository	clientRepository;
	
	public List<Client> getClients() {
		
		return clientRepository.findAll();
	}

	public List<Map<String, String>> getBalanceById(Long id){
		
		return clientRepository.findBalanceById(id);
	}
	
	public void incrementBalanceById(Long id, Float balance) {
		List<Map<String, String>> response = clientRepository.findBalanceById(id);
		Map<String, String> findInfo = response.get(0);
		Float findedBalance = Float.parseFloat(findInfo.get("balance").toString()); 
		if (balance > findedBalance) {
			clientRepository.updateBalanceById(id, balance);
		}else {
			System.out.println("Error, transacción no válida");
		}
	}
	
}
