package com.example.demo.web;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entite.Employee;
import com.example.demo.service.EmployeeService;
@CrossOrigin("*")
@RestController


@RequestMapping(path = "/api")
public class EmployeeRestApi {
	@Autowired
	private EmployeeService dep;
	private PasswordEncoder passwordEncoder;
	
	public EmployeeRestApi(EmployeeService dep) {
		this.dep=dep;
		
		
	}
	
	 @GetMapping(path = "/employee")
	public List<Employee> Employees(){
		return dep.listEmployees();
	}
	 @GetMapping(path = "/employee/{id}")
	    public Employee employee(@PathVariable int id){
	        return dep.getEmployee(id);
	    }
	 @PostMapping(path = "/employee")
	 public  Employee ajouter(@RequestBody Employee d) {
		return dep.ajouter(d);
	 }
	 @DeleteMapping(path = "/employee/{id}")
	    public void supprimer(@PathVariable int id){
	        dep.supprimer(id);
	    }
	
	 @PostMapping(path="/login") 
	 public Employee login(@RequestBody Employee employee) throws Exception{
		String userName= employee.getUserName();
		String password =employee.getPassword();
		
		Employee emp =null;
		if(userName !=null && password !=null) {
		 emp = dep.login(userName, password);
		}if(emp == null) {
			throw new Exception("login incorrect :"+emp.getPassword() +" emp = "+ emp.getUserName() );
		}
		return emp;
	 }
	 
}
