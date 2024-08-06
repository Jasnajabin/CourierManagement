package com.couriermanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cost {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int costlessthan;
	private int costgreaterthan;
	public Cost(long id, int costlessthan, int costgreaterthan) {
		super();
		this.id = id;
		this.costlessthan = costlessthan;
		this.costgreaterthan = costgreaterthan;
	}
	public Cost() {
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getCostlessthan() {
		return costlessthan;
	}
	public void setCostlessthan(int costlessthan) {
		this.costlessthan = costlessthan;
	}
	public int getCostgreaterthan() {
		return costgreaterthan;
	}
	public void setCostgreaterthan(int costgreaterthan) {
		this.costgreaterthan = costgreaterthan;
	}
	@Override
	public String toString() {
		return "Cost [id=" + id + ", costlessthan=" + costlessthan + ", costgreaterthan=" + costgreaterthan + "]";
	}
	public Cost orElse(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
