package com.example.transfert.web;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.transfert.entities.Client;
import com.example.transfert.service.ClientService;

@Controller

public class ClientController {
	@Autowired
private ClientService clientservice;
	
	@RequestMapping("/client")
	public String index(Model model) {
		List<Client> c=clientservice.listAllCustomers();
		model.addAttribute("Clients", c);
		return "Client";}
		 
		    @GetMapping("")
		    public List<Client> list() {
		        return clientservice.listAllCustomers();
		    }

		    @GetMapping("/{id}")
		    public ResponseEntity<Client> get(@PathVariable long id) {
		        try {
		            Client client = clientservice.getCustomer(id);
		            return new ResponseEntity<Client>(client, HttpStatus.OK);
		        } catch (NoSuchElementException e) {
		            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		        }
		    }
		    @PostMapping("/")
		    public void add(@RequestBody Client client) {
		       clientservice.saveCustomer(client);
		    }
		    @PutMapping("/{id}")
		    public ResponseEntity<?> update(@RequestBody Client client, @PathVariable long id) {
		        try {
		            Client existClient = clientservice.getCustomer(id);
		            client.setId(id);            
		            clientservice.saveCustomer(client);
		            return new ResponseEntity<>(HttpStatus.OK);
		        } catch (NoSuchElementException e) {
		            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		        }
		    }
		    @DeleteMapping("/{id}")
		    public void delete(@PathVariable Integer id) {

		    	clientservice.deleteCustomer(id);
		    }
		
	}
