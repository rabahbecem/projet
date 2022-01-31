package com.example.demo.service;


import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.entite.Employee;
@Service
public class EmployeeServImp implements EmployeeService{
	private final EmployeeDao dao;
	private PasswordEncoder passwordEncoder;
	public EmployeeServImp(EmployeeDao dao) {
		this.dao=dao;
		
	}
	@Override
	public Employee ajouter(Employee e) {
		// TODO Auto-generated method stub
		
		return dao.save(e);
	}

	@Override
	public List<Employee> listEmployees() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public void supprimer(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public void Update(Employee e) {
		// TODO Auto-generated method stub
		dao.save(e);
	}
	@Override
	public Employee login(String userName, String password) {
		// TODO Auto-generated method stub
		return dao.findByuserNameAndPassword(userName, password);
	}
	
}
