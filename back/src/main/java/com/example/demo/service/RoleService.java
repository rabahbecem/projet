package com.example.demo.service;

import java.util.List;


import com.example.demo.entite.Role;

public interface RoleService {
	public void ajouter(Role d);
	public List<Role> listRole();
	public Role getRole(int id);
	public void supprimer(int id);
}
