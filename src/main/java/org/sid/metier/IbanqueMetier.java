package org.sid.metier;

import org.sid.entites.Compte;
import org.sid.entites.Operation;
import org.springframework.data.domain.Page;

public interface IbanqueMetier {
	public Compte consulterCompte(String codeCpte);
	public void verser(String codeCpte, double montant);
	public void retirer(String codeCpte, double montant);
	public void virement(String codeCpte1, String codeCpte2, double montant);
	public Page<Operation> listOperation(String codeCpte, int page, int size);

}
