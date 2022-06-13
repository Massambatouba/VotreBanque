package org.sid;

import java.util.Date;


import org.sid.entites.Client;
import org.sid.entites.Compte;
import org.sid.entites.CompteCourant;
import org.sid.entites.CompteEpargne;
import org.sid.entites.Retrait;
import org.sid.entites.Versement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;



@SpringBootApplication
public class VotreBanqueApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
                SpringApplication.run(VotreBanqueApplication.class, args);
		
		
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

	/*
	 * @Override public void run(String... args) throws Exception { Client c1 =
	 * clientRepository.save(new Client(null, "Hassan", "hassan@gmail.com", null));
	 * Client c2 = clientRepository.save(new Client(null, "Ouly", "ouly@gmail.com",
	 * null));
	 * 
	 * 
	 * 
	 * 
	 * }
	 */

}
