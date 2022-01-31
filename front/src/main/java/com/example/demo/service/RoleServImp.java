package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.RoleDao;
import com.example.demo.entite.Role;

@Service
public class RoleServImp implements RoleService {
	private final RoleDao dao;
	public RoleServImp(RoleDao dao) {
		this.dao=dao;
	}
	@Override
	public void ajouter(Role d) {
		// TODO Auto-generated method stub
		dao.save(d);
	}

	@Override
	public List<Role> listRole() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Role getRole(int id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public void supprimer(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

}
