package clases;

public abstract class Afectacion {
	//Atributos
	protected Boolean esDerrumbeTotal;
	protected String materialPredominante;
	//Constructor
	public Afectacion(Boolean esDerrumbeTotal, String materialPredominante){
		setEsDerrumbeTotal(esDerrumbeTotal);
		setMaterialPredominante(materialPredominante);
	}
	//Métodos
	protected abstract void setEsDerrumbeTotal(Boolean esDerrumbeTotal);
	protected abstract Boolean getEsDerrumbeTotal();
	protected abstract void setMaterialPredominante(String materialPredominante);
	protected abstract String getMaterialPredominante();	
}