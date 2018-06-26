package br.com.adoptioncontrol.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.adoptioncontrol.models.Tutor;

@Stateless
public class TutorDao {
	
	@PersistenceContext
	private EntityManager manager;
	
	
	public void salve(Tutor tutor) {
		manager.persist(tutor);
	}

	public List<Tutor> list() {
		return manager.createQuery("select t from tutor t", Tutor.class).getResultList();
	}

	public Tutor findOne(Integer tutorId) {
		return manager.find(Tutor.class, tutorId);
	}

	public void delete(Tutor tutor) {
		manager.remove(manager.getReference(Tutor.class, tutor.getId()));		
	}

	public void update(Tutor tutor) {
		manager.merge(tutor);		
	}
}
