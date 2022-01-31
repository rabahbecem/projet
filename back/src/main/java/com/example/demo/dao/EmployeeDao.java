package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entite.Employee;
@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {
	
	
	public Employee findByuserNameAndPassword(String userName,String password) ;
	public Employee findByuserName(String userName);	
	
}
