package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.domain.Empresa;
import com.example.demo.repository.EmpresaRepository;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	private final Logger log = LoggerFactory.getLogger(EmpresaServiceImpl.class);
	
	private EmpresaRepository empresaRepository;
	
	
	public EmpresaServiceImpl(EmpresaRepository empresaRepository) {
		this.empresaRepository = empresaRepository;
	}
	
	@Override
	public List<Empresa> findAll() {
		log.info("Executing findAll Empresas");
		return this.empresaRepository.findAll();
	}

	@Override
	public Optional<Empresa> findById(Long id) {
		log.info("Executing findById");
		return this.empresaRepository.findById(id);
	}

	@Override
	public List<Empresa> findByNameEmpresa(String nameEmpresa) {
		log.info("Executing findByNameEmpresa");
		if(!StringUtils.hasLength(nameEmpresa))
			return new ArrayList<>();
		return this.empresaRepository.findByNameEmpresa(nameEmpresa);
	}
	
	@Override
	public Long count() {
		log.info("Get total number of empresas");
		return this.empresaRepository.count();
	}

	@Override
	public Empresa save(Empresa empresa) {
		log.info("Creating / Updating empresa");

		if(!this.validateEmpresa(empresa)) 
			return null;
		
		Empresa empresaDB = this.empresaRepository.save(empresa);
		
		return empresaDB;
	}
	
	private boolean validateEmpresa(Empresa empresa) {
		// null validation
		if (empresa == null) {
			log.warn("Trying to create null empresa");
			return false;
		}		
		return true;
	}

	@Override
	public void deleteById(Long id) {
		log.info("Deleting empresa by id");
		if (id == null || id < 0 || id == 0) {
			log.warn("Trying to delete user with wrong id");
			return;
		}

		try {
			this.empresaRepository.deleteById(id);
		} catch (Exception e) {
			log.error("Error trying to delete empresa by id {}", id, e);
		}

	}

	@Override
	public void deleteAll() {
		log.info("Deleting empresas");
		this.empresaRepository.deleteAll();
	}

	
	@Override
	public List<Empresa> createBilling() {
		List<Empresa>empresas = this.empresaRepository.findAll();
		return empresas;
	}

}
