package br.com.adoptioncontrol.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="adoption")
public class Adoption {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="tutor_id")
	private Tutor tutor = new Tutor();

	@OneToOne
	@JoinColumn(name="animal_id")
	private Animal animal = new Animal();
	
	@Column(name="type")
	private EnumAdoption type;	

	public Adoption() {}
	
	public Adoption(Integer tutorId, Integer animalId, EnumAdoption type) {
		this.type = type;
		this.tutor.setId(tutorId);
		this.animal.setId(animalId);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Tutor getTutor() {
		return tutor;
	}

	public Animal getAnimal() {
		return animal;
	}
	
	public EnumAdoption getType() {
		return type;
	}
}
