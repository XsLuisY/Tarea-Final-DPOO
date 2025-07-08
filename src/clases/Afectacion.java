package clases;
import java.util.UUID;

import interfaces.Identificador;



public abstract class Afectacion implements Identificador{
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

	//Metodos
	public abstract void setEsDerrumbeTotal(Boolean esDerrumbeTotal);
	public abstract Boolean getEsDerrumbeTotal();
	public abstract void setMaterialPredominante(String materialPredominante);
	public abstract String getMaterialPredominante();
}