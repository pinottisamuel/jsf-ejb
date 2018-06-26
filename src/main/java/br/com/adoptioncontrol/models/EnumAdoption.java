package br.com.adoptioncontrol.models;

public enum EnumAdoption {	
	
	INTERESSE("Interesse"), 
	ADOCAO("Adoção");
	
	
	private String label;
	
	private EnumAdoption(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
}
