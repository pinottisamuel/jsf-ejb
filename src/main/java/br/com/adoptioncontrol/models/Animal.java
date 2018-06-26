package br.com.adoptioncontrol.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name="animal")
public class Animal {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;	
	
	private String name;
	
	@OneToOne(mappedBy="animal", orphanRemoval=true)
	private Adoption adoption;
	
	public Animal() {}
	
	public Animal(Integer id) {
		this.id = id;
	}
	
	public Animal(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
