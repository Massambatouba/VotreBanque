package org.sid;

import java.util.Date;

import org.sid.dao.ClientRepository;
import org.sid.dao.CompteRepository;
import org.sid.dao.OperationRepository;
import org.sid.entites.Client;
import org.sid.entites.Compte;
import org.sid.entites.CompteCourant;
import org.sid.entites.CompteEpargne;
import org.sid.entites.Operation;
import org.sid.entites.Retrait;
import org.sid.entites.Versement;
import org.sid.metier.IbanqueMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;



@SpringBootApplication
public class VotreBanqueApplication implements CommandLineRunner {
	
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private IbanqueMetier banqueMetier;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	public static void main(String[] args) {
         SpringApplication.run(VotreBanqueApplication.class, args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		Client c1 = clientRepository.save(new Client("Massamba", "massamba@gmail.com"));
		Client c2 = clientRepository.save(new Client("Bass", "bass@gmail.com"));
		Client c3 = clientRepository.save(new Client("Omar", "omara@gmail.com"));
		Client c4 = clientRepository.save(new Client("Khadija", "khadija@gmail.com"));
		
		Compte cp1 = compteRepository.save(new CompteCourant("C1", new Date(), 90000, c1, 6000));
		Compte cp2 = compteRepository.save(new CompteEpargne("C2", new Date(), 6000, c2, 5.5));
		
		operationRepository.save(new Versement(new Date(), 9000, cp1));
		operationRepository.save(new Versement(new Date(), 6000, cp1));
		operationRepository.save(new Versement(new Date(), 2300, cp1));
		operationRepository.save(new Retrait(new Date(), 9000, cp1));
		
		operationRepository.save(new Versement(new Date(), 2300, cp2));
		operationRepository.save(new Versement(new Date(), 400, cp2));
		operationRepository.save(new Versement(new Date(), 2300, cp2));
		operationRepository.save(new Retrait(new Date(), 3000, cp2));
		
		
		
		
		banqueMetier.verser("c1", 111111111);
	}
		
	}

	


