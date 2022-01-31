package com.example.demo.web;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entite.Role;
import com.example.demo.service.RoleService;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api")
public class RoleRestApi {

	private RoleService dep;
	
	public RoleRestApi(RoleService dep) {
		this.dep=dep;
	}
	
	 @GetMapping(path = "/role")
	public List<Role> Roles(){
		return dep.listRole();
	}
	 @GetMapping(path = "/role/{id}")
	    public Role Role(@PathVariable int id){
	        return dep.getRole(id);
	    }
	 @PostMapping(path="/role")
	 public void ajouter(@RequestBody Role d) {
		 dep.ajouter(d);
	 }
	 @PostMapping(path = "/role/{id}")
	    public void supprimer(@PathVariable int id){
	        dep.supprimer(id);
	    }

}
