package org.sid.metier;

import java.util.Date;

import org.sid.dao.CompteRepository;
import org.sid.dao.OperationRepository;
import org.sid.entites.Compte;
import org.sid.entites.CompteCourant;
import org.sid.entites.Operation;
import org.sid.entites.Retrait;
import org.sid.entites.Versement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BanqueMetierImpl implements IbanqueMetier {
	
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	@Override
	public Compte consulterCompte(String codeCpte) {
		Compte cp = compteRepository.getById(codeCpte);
		if(cp==null ) throw new RuntimeException("Compte introuvable");
		return cp;
	}

	@Override
	public void verser(String codeCpte, double montant) {
		Compte cp = consulterCompte(codeCpte);
		Versement v  = new Versement(new Date(), montant, cp);
		 operationRepository.save(v);
		 cp.setSolde(cp.getSolde() + montant);
		 compteRepository.save(cp);
		
	}

	@Override
	public void retirer(String codeCpte, double montant) {
		Compte cp = consulterCompte(codeCpte);
		Retrait r = new Retrait(new Date(), montant, cp);
		double facilitesCaise = 0;
		if(cp instanceof CompteCourant)
			facilitesCaise = ((CompteCourant) cp).getDecouvert();
		if((cp.getSolde()+facilitesCaise) < montant)
			throw new RuntimeException("solde insufisant");
		operationRepository.save(r);
		cp.setSolde(cp.getSolde() - montant);
		compteRepository.save(cp);
		
	}

	@Override
	public void virement(String codeCpte1, String codeCpte2, double montant) {
		retirer(codeCpte1, montant);
		verser(codeCpte2, montant);
		
	}

	@Override
	public Page<Operation> listOperation(String codeCpte, int page, int size) {
		
		return operationRepository.listOperation(codeCpte, PageRequest.of(page, size));
	}

}
