package com.example.demo.service;

import java.util.List;

import com.example.demo.entite.Employee;

public interface EmployeeService {

	public Employee ajouter(Employee e);
	public List<Employee> listEmployees();
	public Employee getEmployee(int id);
	public void supprimer(int id);
	public void Update (Employee e);
	public Employee login(String userName,String password);
	
}
