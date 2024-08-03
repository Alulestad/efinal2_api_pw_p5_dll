package com.edu.uce.api.service;

import java.util.List;

import com.edu.uce.api.repository.modelo.Vehiculo;
import com.edu.uce.api.service.to.VehiculoTO;
import com.edu.uce.api.service.to.VehiculoTOBasics;

public interface IVehiculoService {
	
	//CRUD
		public void guardar(VehiculoTO VehiculoTO);
		public VehiculoTO buscarPorId(Integer id);
		public VehiculoTO buscarPorPlaca(String placa);
		public List<VehiculoTOBasics> buscar();
		
		public Integer eliminarPorPlaca(String placa);

}
