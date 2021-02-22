package com.example.transfert;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.assertj.AssertableReactiveWebApplicationContext;
import org.springframework.util.Assert;

import com.example.transfert.dao.ClientRepository;
import com.example.transfert.dao.CompteRepository;
import com.example.transfert.entities.Client;
import com.example.transfert.entities.Compte;
import com.example.transfert.metier.TransfertMetierImp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert.*;
 

@SpringBootTest
class TransfertApplicationTests {
	@Autowired
	ClientRepository clientrepository;
	@Autowired
	CompteRepository compterepository;
	@Autowired
	TransfertMetierImp transfertMetierImp;
	@Test
	void contextLoads() {
	}
	@Test
	void testMontant() {
		Client client = clientrepository.getOne(2L);
		long id = client.getId();
		Compte compte = compterepository.getOnecompte(id);
		long montant = compte.getMontant();
		
		
		assertTrue("faux",montant==0L);
	}
	@Test
	void testVirer() {
		Client client = clientrepository.getOne(2L);
		long id = client.getId();
		Compte compte = compterepository.getOnecompte(id);
		long montant = compte.getMontant();
		String num =compte.getNum();
		Client client1 = clientrepository.getOne(5L);
		long id1 = client1.getId();
		Compte compte1 = compterepository.getOnecompte(id1);
		long montant1 = compte1.getMontant();
		String num1 =compte1.getNum();
		
		transfertMetierImp.virer(num, num1, montant);
		Client client2 = clientrepository.getOne(2L);
		long id2 = client2.getId();
		Compte compte2 = compterepository.getOnecompte(id2);
		long montant2 = compte2.getMontant();
		assertEquals(0, montant2);
		
	}
	
	@Test
	void testVerser() {
		Client client = clientrepository.getOne(2L);
		long id = client.getId();
		Compte compte = compterepository.getOnecompte(id);
		long montant = compte.getMontant();
		String num =compte.getNum();
		long solde=1000L;
		
		transfertMetierImp.versser(num,solde);
		Client client1 = clientrepository.getOne(2L);
		long id1 = client1.getId();
		Compte compte1 = compterepository.getOnecompte(id1);
		long montant1 = compte1.getMontant();
		assertFalse("vrai",montant1==100);
		
		
	}
	
	@Test
	void testRetirer() {
		Client client = clientrepository.getOne(5L);
		long id = client.getId();
		Compte compte = compterepository.getOnecompte(id);
		long montant = compte.getMontant();
		String num =compte.getNum();
		long solde=15000L;
		
		transfertMetierImp.retirer(num, solde);
		Client client1 = clientrepository.getOne(5L);
		long id1 = client1.getId();
		Compte compte1 = compterepository.getOnecompte(id1);
		long montant1 = compte1.getMontant();
		assertNotEquals( 10000, montant1);
		
		
	}
	
}
