package br.com.adoptioncontrol.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.adoptioncontrol.models.Adoption;

@Stateless
public class AdoptionDao {
	
	@PersistenceContext
	private EntityManager manager;

	public void save(Adoption adoption) {
		manager.persist(adoption);
	}

	public List<Adoption> list() {
		return manager.createQuery("select a from adoption a", Adoption.class).getResultList();
	}

}
