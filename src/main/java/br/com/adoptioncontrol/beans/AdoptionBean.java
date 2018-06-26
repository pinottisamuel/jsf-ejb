package br.com.adoptioncontrol.beans;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.adoptioncontrol.models.Animal;
import br.com.adoptioncontrol.models.EnumAdoption;
import br.com.adoptioncontrol.models.Tutor;
import br.com.adoptioncontrol.service.AdoptionService;
import br.com.adoptioncontrol.service.AnimalService;
import br.com.adoptioncontrol.service.TutorService;

@Model
public class AdoptionBean {	
	
	@Inject
	private TutorService tutorService;
	
	@Inject
	private AnimalService animalService;
	
	@Inject
	private AdoptionService adoptionService;

	private Integer tutorId;
	private Integer animalId;
	private EnumAdoption type;
	
	public List<Tutor> getTutores(){
		return tutorService.list();
	}
	
	public List<Animal> getAnimals(){
		return animalService.list();
	}
	
	public void save() {		
		adoptionService.save(tutorId, animalId, type);
	}
	
	public String cancel() {
		return "/index.xhtml?faces-redirect=true";
	}

	public Integer getAnimalId() {
		return animalId;
	}

	public void setAnimalId(Integer animalId) {
		this.animalId = animalId;
	}

	public EnumAdoption getType() {
		return type;
	}

	public void setType(EnumAdoption type) {
		this.type = type;
	}	
	
	public Integer getTutorId() {
		return tutorId;
	}

	public void setTutorId(Integer tutorId) {
		this.tutorId = tutorId;
	}
}
