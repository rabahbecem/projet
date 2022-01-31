package com.example.demo.entite;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_user;
	private String userName;
	private String Email;
	private String password;
	@ManyToOne
	@JoinColumn(name = "departement_id")
	private Departement departement;
	private String role;
	public Employee(String userName, String password,String role) {
		this.userName = userName;
		this.password=password;
		this.role= role;
	}
	@Override
	public boolean equals(Object obj) {
		
		
		if(obj==null || !(obj instanceof Employee) )
			return false;
		return this.id_user==((Employee)obj).getId_user();
	}

}
