package com.edu.uce.api.repository;

import java.util.List;

import com.edu.uce.api.repository.modelo.Vehiculo;

public interface IVehiculoRepo {
	//CRUD
	public void insertar(Vehiculo vehiculo);
	public Vehiculo seleccionarPorId(Integer id);
	public Vehiculo seleccionarPorPlaca(String placa);
	public List<Vehiculo> seleccionar();
	public Integer eliminar(Integer id);
	
}
