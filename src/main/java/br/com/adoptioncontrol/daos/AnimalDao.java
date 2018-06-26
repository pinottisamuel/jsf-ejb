package br.com.adoptioncontrol.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.adoptioncontrol.models.Animal;

@Stateless
public class AnimalDao {

	@PersistenceContext
	private EntityManager manager;

	public void save(Animal animal) {
		manager.persist(animal);
	}

	public List<Animal> list() {
		return manager.createQuery("select a from animal a", Animal.class).getResultList();
	}

	public Animal finOne(Integer animalId) {
		return manager.find(Animal.class, animalId);
	}

	public void delete(Animal animal) {
		manager.remove(manager.getReference(Animal.class, animal.getId()));	
	}

	public void update(Animal animal) {
		manager.merge(animal);
		
	}
}
