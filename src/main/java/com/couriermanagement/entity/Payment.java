package com.couriermanagement.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 private long cardNumber;
	 @JsonFormat(pattern = "mm/yyyy")
	 private LocalDate expiryDate;
	 private int cvv;
	 private double totalPrice;
	public Payment(int id, long cardNumber, LocalDate expiryDate, int cvv, double totalPrice) {
		super();
		this.id = id;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.cvv = cvv;
		this.totalPrice = totalPrice;
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "Payment [id=" + id + ", cardNumber=" + cardNumber + ", expiryDate=" + expiryDate + ", cvv=" + cvv
				+ ", totalPrice=" + totalPrice + "]";
	}
	public Object getWeight() {
		// TODO Auto-generated method stub
		return null;
	}
	 

}
