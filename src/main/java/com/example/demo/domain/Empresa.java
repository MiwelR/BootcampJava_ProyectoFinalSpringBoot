package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "empresas")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty("Clave primaria id ficticio tipo Long autoincremental")
	private Long id;

	@ApiModelProperty("Nombre de la empresa")
	private String nameEmpresa;
	
	@ApiModelProperty("Años de la empresa en el mercado")
	private Integer years;
	
	@ApiModelProperty("Número de empleados en la empresa")
	private Integer numEmpleados;
	
	@ApiModelProperty("Número de productos creados por la empresa")
	private Integer numProductos;
	
	@ApiModelProperty("Facturación de la empresa")
	private Integer billing = null;

	public Empresa() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameEmpresa() {
		return nameEmpresa;
	}

	public void setNameEmpresa(String nameEmpresa) {
		this.nameEmpresa = nameEmpresa;
	}

	public Integer getYears() {
		return years;
	}

	public void setYears(Integer years) {
		this.years = years;
	}

	public Integer getNumEmpleados() {
		return numEmpleados;
	}

	public void setNumEmpleados(Integer numEmpleados) {
		this.numEmpleados = numEmpleados;
	}

	public Integer getNumProductos() {
		return numProductos;
	}

	public void setNumProductos(Integer numProductos) {
		this.numProductos = numProductos;
	}

	public Integer getBilling() {
		return this.billing;
	}

	public void setBilling(Integer billing) {
		this.billing = billing;
	}

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", nameEmpresa=" + nameEmpresa + ", years=" + years + ", numEmpleados="
				+ numEmpleados + ", numProductos=" + numProductos + ", billing=" + billing + "]";
	}

	
}
