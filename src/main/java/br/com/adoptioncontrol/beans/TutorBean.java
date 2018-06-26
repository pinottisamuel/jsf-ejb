package br.com.adoptioncontrol.beans;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.adoptioncontrol.models.Tutor;
import br.com.adoptioncontrol.service.TutorService;

@Model
public class TutorBean {
	
	@Inject
	private TutorService service;
	
	private Tutor tutor = new Tutor();
	
	public String salvar() {
		if(this.getTutor().getId() == null) {
			service.save(this.getTutor());
		} else {
			service.update(this.getTutor());
		}
		
		return "/tutor-list.xhtml?faces-redirect=true";
	}
	
	public List<Tutor> getTutores(){
		return service.list();
	}
	
	public String delete(Tutor tutor) {
		service.delete(tutor);
		return "/tutor-list.xhtml?faces-redirect=true";
	}
	
	public String update(Tutor tutor) {
		this.setTutor(tutor);
		return "/tutor-form.xhtml";
	}
	
	public String cancel() {
		return "/index.xhtml?faces-redirect=true";
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}
}
