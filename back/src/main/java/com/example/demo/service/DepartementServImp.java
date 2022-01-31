package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DepartementDao;
import com.example.demo.entite.Departement;
import com.example.demo.entite.Employee;
@Service
public class DepartementServImp implements DepartementService{
	@Autowired
	private final DepartementDao dao;
	
	public DepartementServImp(DepartementDao dao) {
		this.dao=dao;
	}
	@Override
	public void ajouter(Departement d) {
		// TODO Auto-generated method stub
		dao.save(d);
	}

	@Override
	public List<Departement> listDepartement() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Departement getDepartement(int id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public void supprimer(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}
	
	

}
