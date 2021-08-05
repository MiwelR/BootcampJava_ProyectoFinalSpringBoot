package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.Empresa;


public interface EmpresaService {
	
	// spring repository methods
	
	List<Empresa> findAll();

	Optional<Empresa> findById(Long id);
	
	Long count();
	
	Empresa save(Empresa empresa);
	
	void deleteById(Long id);
	
	void deleteAll();
	
	// custom methods
	
	List<Empresa> findByNameEmpresa(String nameEmpresa);

	List<Empresa> createBilling();

	
}
