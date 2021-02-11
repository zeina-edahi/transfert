package com.example.transfert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.transfert.dao.ClientRepository;
import com.example.transfert.entities.Client;

@SpringBootApplication
public class TransfertApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(TransfertApplication.class, args);
		ClientRepository cr = ctx.getBean(ClientRepository.class);
		cr.save(new Client(1, "c1","30602002" ,"ek" ,"fatma" , "fatmaek@gmail.com", 0));
		cr.save(new Client(2, "c2","36959539" ,"abd" ,"zeina" , "zeina@gmail.com", 0));
		cr.save(new Client(3, "c3","38515258" ,"ali" ,"khadjetou" , "khadjetou@gmail.com", 0));
		cr.save(new Client(4, "c4","38515258" ,"med" ,"toutou" , "toutou@gmail.com", 0));
	}

}
