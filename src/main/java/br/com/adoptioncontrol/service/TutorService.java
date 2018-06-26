package br.com.adoptioncontrol.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.adoptioncontrol.daos.TutorDao;
import br.com.adoptioncontrol.models.Tutor;

@Stateless
public class TutorService {
	
	@Inject
	private TutorDao dao;
	
	public void save(Tutor tutor) {
		dao.salve(tutor);
	}

	public List<Tutor> list() {
		return dao.list();
	}
	
	public Tutor findOne(Integer id) {
		return dao.findOne(id);
	}

	public void delete(Tutor tutor) {
		dao.delete(tutor);		
	}

	public void update(Tutor tutor) {
		dao.update(tutor);
	}
}
