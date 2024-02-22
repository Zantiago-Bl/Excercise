package com.example.demo.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.models.Client;
import com.example.demo.services.ClientService;

@Controller
public class ClientController {
	
	@Autowired
	ClientService clientService;
	
	@GetMapping("/allClients")
	@ResponseBody
	public List<Client> getClient (){
		
		return clientService.getClients();
	}
	
	@PostMapping("/balance")
	@ResponseBody
	public List<Map<String, String>> getBalanceById(@RequestBody Long id) {
		
		return clientService.getBalanceById(id);
	}
	
	
	@PutMapping("/updateBalanceIncrement")
	@ResponseBody
	public void IncrementBalanceById(@RequestBody Map<String, Object> request) {
		Long id = Long.parseLong(request.get("id").toString());
		Float balance = Float.parseFloat(request.get("balance").toString());
		clientService.incrementBalanceById(id, balance);
	}
	
}
