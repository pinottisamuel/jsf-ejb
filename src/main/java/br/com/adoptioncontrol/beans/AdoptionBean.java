package br.com.adoptioncontrol.beans;

import java.util.Calendar;
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
	
	private String type;
	
	private Calendar dataAdocao = Calendar.getInstance();
	
	public List<Tutor> getTutores(){
		return tutorService.list();
	}
	
	public List<Animal> getAnimals(){
		return animalService.list();
	}
	
	public String save() {		
		adoptionService.save(tutorId, animalId, type);
		return "/adoption-list.xhtml?faces-redirect=true";
	}
	
	public List<Object[]> getAdoptions(){
		return adoptionService.list();
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

	public EnumAdoption[] getTypes() {
		return EnumAdoption.values();
	}

	public void setType(String type) {
		this.type = type;
	}	
	
	public String getType() {
		return type;
	}
	
	public Integer getTutorId() {
		return tutorId;
	}

	public void setTutorId(Integer tutorId) {
		this.tutorId = tutorId;
	}

	public Calendar getDataAdocao() {
		return dataAdocao;
	}

	public void setDataAdocao(Calendar dataAdocao) {
		this.dataAdocao = dataAdocao;
	}
}
