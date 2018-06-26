package br.com.adoptioncontrol.models;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	
	private String type;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataAdocao = Calendar.getInstance();

	public Adoption() {}
	
	public Adoption(Integer tutorId, Integer animalId, String type) {
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
	
	public String getType() {
		return type;
	}

	public Calendar getDataAdocao() {
		return dataAdocao;
	}

	public void setDataAdocao(Calendar dataAdocao) {
		this.dataAdocao = dataAdocao;
	}
}
