package com.example.transfert.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.transfert.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

	
}