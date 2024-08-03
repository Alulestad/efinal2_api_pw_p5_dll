package com.edu.uce.api.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.edu.uce.api.repository.modelo.Vehiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class VehiculoRepoImpl implements IVehiculoRepo {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Vehiculo vehiculo) {
		this.entityManager.persist(vehiculo);

	}

	@Override
	public Vehiculo seleccionarPorId(Integer id) {
		
		return this.entityManager.find(Vehiculo.class, id);
	}

	@Override
	public Vehiculo seleccionarPorPlaca(String placa) {
		TypedQuery<Vehiculo> myQuery=this.entityManager.createQuery("select v from Vehiculo v where v.placa=:dato",Vehiculo.class);
		myQuery.setParameter("dato", placa);
		
		return myQuery.getSingleResult();
	}

	@Override
	public List<Vehiculo> seleccionar() {
		TypedQuery<Vehiculo> myQuery=this.entityManager.createQuery("select v from Vehiculo v",Vehiculo.class);

		return myQuery.getResultList();
	}

	@Override
	public Integer eliminar(Integer id) {
		Vehiculo vehiculo=this.seleccionarPorId(id);
		this.entityManager.remove(vehiculo);
		return 1;
	}
	
	

}
