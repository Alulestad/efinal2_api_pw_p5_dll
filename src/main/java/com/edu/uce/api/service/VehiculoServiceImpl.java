package com.edu.uce.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.uce.api.repository.IVehiculoRepo;
import com.edu.uce.api.repository.modelo.Vehiculo;
import com.edu.uce.api.service.to.VehiculoTO;
import com.edu.uce.api.service.to.VehiculoTOBasics;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

	@Autowired
	private IVehiculoRepo iVehiculoRepo;
	
	@Override
	public void guardar(VehiculoTO VehiculoTO) {
		Vehiculo vehiculo=this.vehiculoTOToVehiculo(VehiculoTO);
		this.iVehiculoRepo.insertar(vehiculo);
		
	}

	@Override
	public VehiculoTO buscarPorId(Integer id) {
		Vehiculo vehiculo=this.iVehiculoRepo.seleccionarPorId(id);
		return this.vehiculoToVehiculoTO(vehiculo);
	}

	@Override
	public VehiculoTO buscarPorPlaca(String placa) {
		Vehiculo vehiculo=this.iVehiculoRepo.seleccionarPorPlaca(placa);
		return this.vehiculoToVehiculoTO(vehiculo);
	}

	@Override
	public List<VehiculoTOBasics> buscar() {
		List<Vehiculo> vehiculos=this.iVehiculoRepo.seleccionar();
		List<VehiculoTOBasics> vehiculoTOBasics=new ArrayList<>();
		for(Vehiculo v:vehiculos) {
			vehiculoTOBasics.add(this.vehiculoToVehiculoTOBasics(v));
		}
		
		return vehiculoTOBasics;
	}
	
	
	
	public VehiculoTO vehiculoToVehiculoTO(Vehiculo vehiculo) {
		VehiculoTO vehiculoTO=new VehiculoTO();
		
		vehiculoTO.setColor(vehiculo.getColor());
		vehiculoTO.setId(vehiculo.getId());
		vehiculoTO.setMarca(vehiculo.getMarca());
		vehiculoTO.setModelo(vehiculo.getModelo());
		vehiculoTO.setPlaca(vehiculo.getPlaca());
		vehiculoTO.setPrecio(vehiculo.getPrecio());
		
		return vehiculoTO;
	}
	
	public Vehiculo vehiculoTOToVehiculo(VehiculoTO vehiculoTO) {
		Vehiculo vehiculo=new Vehiculo();
		
		vehiculo.setColor(vehiculoTO.getColor());
		vehiculo.setId(vehiculoTO.getId());
		vehiculo.setMarca(vehiculoTO.getMarca());
		vehiculo.setModelo(vehiculoTO.getModelo());
		vehiculo.setPlaca(vehiculoTO.getPlaca());
		vehiculo.setPrecio(vehiculoTO.getPrecio());
		
		return vehiculo;
	}
	
	public VehiculoTOBasics vehiculoToVehiculoTOBasics(Vehiculo vehiculo) {
		VehiculoTOBasics vehiculoTOBasics=new VehiculoTOBasics();
		

		vehiculoTOBasics.setMarca(vehiculo.getMarca());
		vehiculoTOBasics.setModelo(vehiculo.getModelo());
		vehiculoTOBasics.setPlaca(vehiculo.getPlaca());

		
		return vehiculoTOBasics;
	}

	@Override
	public Integer eliminarPorPlaca(String placa) {
		Vehiculo vehiculo= this.iVehiculoRepo.seleccionarPorPlaca(placa);
		
		return this.iVehiculoRepo.eliminar(vehiculo.getId());
	}
	
	

}
