package br.com.adoptioncontrol.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.adoptioncontrol.daos.AdoptionDao;
import br.com.adoptioncontrol.models.Adoption;
import br.com.adoptioncontrol.models.Animal;
import br.com.adoptioncontrol.models.Tutor;

@Stateless
public class AdoptionService {
	
	@Inject
	private AdoptionDao dao;
	
	@Inject
	private AnimalService animalService;
	
	@Inject
	private TutorService tutorService;
	
	public void save(Integer tutorId, Integer animalId, String type) {
		
		Tutor tutor = new Tutor(tutorService.findOne(tutorId).getId());
		Animal animal = new Animal(animalService.findOnde(animalId).getId());
		
		dao.save(new Adoption(tutor.getId(), animal.getId(), type));
	}
	
	public List<Object[]> list(){
		return dao.list();
	}
}
