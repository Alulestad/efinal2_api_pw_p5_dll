package com.edu.uce.api.service.to;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public class VehiculoTOBasics extends RepresentationModel<VehiculoTOBasics> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4994837417430336359L;
	
	private String placa;
	private String marca;
	private String modelo;
	
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
