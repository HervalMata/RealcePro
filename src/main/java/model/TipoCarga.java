package model;

public enum TipoCarga {
	
	Placa("Placa"), Peso("Peso");
	
	private String label;
	
	private TipoCarga(String label){
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
			
}
