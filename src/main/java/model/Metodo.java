package model;

public enum Metodo {
	
	Biserie("Biserie"), ;
	
	private String label;
	
	private Metodo(String label){
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
}
