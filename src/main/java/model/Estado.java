package model;

public enum Estado {
	
	PB("Paraiba"), SP("Sao Paulo"), RJ("Rio de Janeiro"), BA("Bahia");
	
	private String label;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	private Estado(String label) {
		this.label = label;
	}
	
	

}
