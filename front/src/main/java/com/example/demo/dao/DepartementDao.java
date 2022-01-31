package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entite.Departement;

public interface DepartementDao extends JpaRepository<Departement, Integer> {

}
