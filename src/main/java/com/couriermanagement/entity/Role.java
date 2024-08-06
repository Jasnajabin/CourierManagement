package com.couriermanagement.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String name;
@ManyToMany(mappedBy = "roles")
private Set<User> users;



public Role(long id, String name, Set<User> users) {
	super();
	this.id = id;
	this.name = name;
	this.users = users;
}
public Role() {
	// TODO Auto-generated constructor stub
}
public Role(String roleName) {
	// TODO Auto-generated constructor stub
}
public Set<User> getUsers() {
	return users;
}
public void setUsers(Set<User> users) {
	this.users = users;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getRole() {
	// TODO Auto-generated method stub
	return null;
}

}
