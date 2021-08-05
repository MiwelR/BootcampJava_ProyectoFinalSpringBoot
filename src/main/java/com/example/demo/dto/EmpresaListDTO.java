package com.example.demo.dto;

import java.util.List;

import com.example.demo.domain.Empresa;

public class EmpresaListDTO {

	private List<Empresa> empresas;
	
	public EmpresaListDTO() {}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

}
