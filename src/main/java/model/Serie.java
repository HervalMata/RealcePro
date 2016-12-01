package model;

public enum Serie {
	
	A("A"), B("B"), C("C");
	
	private String label;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	private Serie(String label){
		this.label = label;
	}
	

}
