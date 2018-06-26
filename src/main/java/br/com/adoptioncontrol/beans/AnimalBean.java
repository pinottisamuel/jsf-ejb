package br.com.adoptioncontrol.beans;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.adoptioncontrol.models.Animal;
import br.com.adoptioncontrol.service.AnimalService;

@Model
public class AnimalBean {

	private Animal animal = new Animal();
	
	@Inject
	private AnimalService service;
	
	public String salvar() {
		if(this.getAnimal().getId() == null) {
			service.save(this.getAnimal());
		} else {
			service.update(this.getAnimal());
		}
		
		return "/animal-list.xhtml?faces-redirect=true";
	}
	
	public List<Animal> getAnimals(){
		return service.list();
	}
	
	public String delete(Animal animal) {
		service.delete(animal);
		return "/animal-list.xhtml?faces-redirect=true";
	}
	
	public String update(Animal animal) {
		this.setAnimal(animal);
		return "/animal-form.xhtml";
	}
	
	public String cancel() {
		return "/index.xhtml?faces-redirect=true";
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
}
