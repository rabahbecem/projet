package com.example.demo.service;

import java.util.List;

import com.example.demo.entite.Departement;
import com.example.demo.entite.Employee;

public interface DepartementService {
	
	public void ajouter(Departement d);
	public List<Departement> listDepartement();
	public Departement getDepartement(int id);
	public void supprimer(int id);
	
}
