package com.example.transfert.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.transfert.dao.ClientRepository;
import com.example.transfert.entities.Client;

@Service
@Transactional
public class ClientService {
	 @Autowired
	    private ClientRepository clientrepository;
	    public List<Client> listAllCustomers() {
	        return clientrepository.findAll();
	    }

	    public void saveCustomer(Client client) {
	    	clientrepository.save(client);
	    }

	    public Client getCustomer(long id) {
	        return clientrepository.findById(id).get();
	    }

	    public void deleteCustomer(long id) {
	    	clientrepository.deleteById(id);
	    }
	}
	