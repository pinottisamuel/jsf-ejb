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

	public List<Object[]> list() {
		String jpql = "select t.name, a.name, ad.dataAdocao, ad.type "
				    + "from adoption ad, animal a, tutor t "
				    + "where a.id = ad.animal "
				    + "and t.id = ad.tutor";
		return manager.createQuery(jpql, Object[].class).getResultList();
	}
}