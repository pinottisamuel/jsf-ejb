package br.com.adoptioncontrol.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.adoptioncontrol.daos.AnimalDao;
import br.com.adoptioncontrol.models.Animal;

@Stateless
public class AnimalService {

	@Inject
	private AnimalDao dao;

	public void save(Animal animal) {
		dao.save(animal);
	}

	public List<Animal> list() {
		return dao.list();
	}

	public Animal findOnde(Integer id) {
		return dao.finOne(id);
	}

	public void delete(Animal animal) {
		dao.delete(animal);
	}

	public void update(Animal animal) {
		dao.update(animal);
	}
}
