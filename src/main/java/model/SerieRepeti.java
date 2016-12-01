package model;

public enum SerieRepeti {
	
	A("3 / 10"), B("3 / 12"), E("3 / 15") ,C("4 / 10"), D("4 / 12"), F("4 / 15");
	
	private String label;
	
	private SerieRepeti(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	

}
