package com.edu.uce.api.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.uce.api.service.IVehiculoService;
import com.edu.uce.api.service.to.VehiculoTO;
import com.edu.uce.api.service.to.VehiculoTOBasics;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;



@RestController
@RequestMapping(path = "/vehiculo")
@CrossOrigin("http://localhost:8080/")
public class VehiculoController {
	

	@Autowired
	private IVehiculoService iVehiculoService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VehiculoTO> guardar(@RequestBody VehiculoTO vehiculoTO) {
		
		this.iVehiculoService.guardar(vehiculoTO);
		VehiculoTO vehiculoTO2=this.iVehiculoService.buscarPorPlaca(vehiculoTO.getPlaca());
		
		HttpHeaders headers=new HttpHeaders();
		headers.add("mensaje_201", "Insercion de recursos");
		
		return new ResponseEntity<VehiculoTO>(vehiculoTO2,headers,201);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<VehiculoTOBasics>> buscar(){
		List<VehiculoTOBasics> vehiculoTOs=this.iVehiculoService.buscar();
		HttpHeaders headers=new HttpHeaders();
		headers.add("mensaje_236", "Consulta de recursos");
		System.out.println("vehicloBasics: "+vehiculoTOs);
		return new ResponseEntity<List<VehiculoTOBasics>>(vehiculoTOs,headers,236);
	}
	

	
	@GetMapping(path = "/{placa}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VehiculoTO> buscarPorPlaca(@PathVariable String placa) {
		VehiculoTO vehiculoTO=this.iVehiculoService.buscarPorPlaca(placa);
		HttpHeaders headers=new HttpHeaders();
		headers.add("mensaje_236", "Consulta del recurso");
		
		Link myLink2=linkTo(methodOn(VehiculoController.class).buscarPorPlaca(placa))
				.withRel("suVehiculo");
		
		vehiculoTO.add(myLink2);
		
		System.out.println("vehiculoTO: "+vehiculoTO);
		
		return new ResponseEntity<VehiculoTO>(vehiculoTO, headers,236);
		
	}
	

	
	
	@DeleteMapping(path = "/{placa}")
	public ResponseEntity<Integer> eliminar(@PathVariable String placa){
		//VehiculoTO vehiculoTO=this.iVehiculoService.buscarPorPlaca(placa);
		Integer resp=this.iVehiculoService.eliminarPorPlaca(placa);

		HttpHeaders headers=new HttpHeaders();
		headers.add("mensaje_240", "Eliminacion de recurso");
		
		
		return new ResponseEntity<Integer>(resp,headers,240);
	}
	
	

	
	
	
	
}
