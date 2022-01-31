package com.example.demo.web;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entite.Departement;
import com.example.demo.service.DepartementService;


@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api")
public class DepartementRestApi {
	
	private DepartementService dep;
	
	public DepartementRestApi (DepartementService dep) {
		this.dep= dep;
	}
	
	 @GetMapping(path = "/departement")
	public List<Departement> departements(){
		return dep.listDepartement();
	}
	 @GetMapping(path = "/departement/{id}")
	    public Departement departement(@PathVariable int id){
	        return dep.getDepartement(id);
	    }
	 @PostMapping(path="/departement")
	 public void ajouter(@RequestBody Departement d) {
		 dep.ajouter(d);
	 }
	 @PostMapping(path = "/departement/{id}")
	    public void supprimer(@PathVariable int id){
	        dep.supprimer(id);
	    }

}
