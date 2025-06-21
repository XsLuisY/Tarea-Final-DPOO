package clases;
import java.util.UUID;

import interfaces.Identificable;



public abstract class Afectacion implements Identificable{
	//Atributos
	protected Boolean esDerrumbeTotal;
	protected String materialPredominante;
	protected UUID id;
	//Constructor
	
	public Afectacion(Boolean esDerrumbeTotal, String materialPredominante){
		setEsDerrumbeTotal(esDerrumbeTotal);
		setMaterialPredominante(materialPredominante);
		setId();
	}
	
	//M�todos
	protected abstract void setEsDerrumbeTotal(Boolean esDerrumbeTotal);
	protected abstract Boolean getEsDerrumbeTotal();
	protected abstract void setMaterialPredominante(String materialPredominante);
	protected abstract String getMaterialPredominante();
}