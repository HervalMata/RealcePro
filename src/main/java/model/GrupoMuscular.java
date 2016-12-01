package model;

public enum GrupoMuscular {
	
	P("Peitoral"), C("Costa"), O("Ombro"), B("Biceps"), T("Triceps"), A("Ante-braço"), CA("Coxa"), PE("Perna"), 
			G("Gluteo"), AB("Abdomen");

	private String label;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	private GrupoMuscular(String label) {
		this.label = label;
	}
}

