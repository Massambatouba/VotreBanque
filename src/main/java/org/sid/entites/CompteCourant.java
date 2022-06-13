package org.sid.entites;

import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@DiscriminatorValue("CC")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CompteCourant extends Compte {

	private double decouvert;

	public CompteCourant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteCourant(String code, Date dateCreation, double solde, Client client, double decouvert) {
		super(code, dateCreation, solde, client);
		this.decouvert = decouvert;
	}
	
	
}
