package com.example.demo.entite;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDao;
@Service
public class UserPrincipalDetailsService implements UserDetailsService{
	private EmployeeDao rep;
	
	public UserPrincipalDetailsService(EmployeeDao rep) {
		this.rep = rep;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee emp = this.rep.findByuserName(username);
		UserPrincipal userPrincipal = new UserPrincipal(emp);
		return userPrincipal ;
	}

}
