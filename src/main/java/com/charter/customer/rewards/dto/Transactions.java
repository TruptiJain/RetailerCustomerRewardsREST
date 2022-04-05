package com.charter.customer.rewards.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Transaction")
public class Transactions {
	@Id
	private int id;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer;

	@Column
	int transaction_amount;
	
	@Column
	Date creation_date;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public int getTransaction_amount() {
		return transaction_amount;
	}
	
	public void setTransaction_amount(int transaction_amount) {
		this.transaction_amount = transaction_amount;
	}
	
	public Date getCreation_date() {
		return creation_date;
	}
	
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}	

}
