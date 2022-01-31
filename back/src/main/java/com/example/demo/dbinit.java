package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.entite.Employee;

@Service
public class dbinit implements CommandLineRunner {
	private EmployeeDao rep;
	private PasswordEncoder passwordEncoder;
	public dbinit(EmployeeDao rep) {
		this.rep = rep;
		
	}
	@Override
	public void run(String... args) throws Exception {
		rep.deleteAll();
		Employee admin = new Employee("admin","admin123","super_user");
		this.rep.save(admin);
		Employee user = new Employee("user","user123","user");
		this.rep.save(admin);
		this.rep.save(user);
	}
	

}
