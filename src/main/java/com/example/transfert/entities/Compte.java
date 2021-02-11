package com.example.transfert.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Compte {
	@Id
	@Column(length=100)
private String num;
private int montant;

public Compte() {
	super();
	// TODO Auto-generated constructor stub
}
public Compte(String num, int montant) {
	super();
	this.num = num;
	this.montant = montant;
	
}
public String getNum() {
	return num;
}
public void setNum(String num) {
	this.num = num;
}
public long getMontant() {
	return montant;
}
public void setMontant(int montant) {
	this.montant = montant;
}

}
