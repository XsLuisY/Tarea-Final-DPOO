package clases;

public class AfectacionPared extends Afectacion{
	//Atributos
	private Boolean esDeCarga;

	//Constructor
	public AfectacionPared(boolean esDerrumbeTotal, String materialPredominante, boolean esDeCarga){
		super(esDerrumbeTotal,materialPredominante);
		setEsDeCarga(esDeCarga);
	}

	//Encapsulamiento
	public Boolean getEsDeCarga() {
		return esDeCarga;
	}
	public void setEsDeCarga(Boolean esDeCarga) {
		this.esDeCarga = esDeCarga;
	}
	public void setEsDerrumbeTotal(Boolean esDerrumbeTotal){
		this.esDerrumbeTotal = esDerrumbeTotal;	
	}
	public Boolean getEsDerrumbeTotal(){
		return esDerrumbeTotal;
	}
	public void setMaterialPredominante(String materialPredominante){
		this.materialPredominante= materialPredominante;
	}
	public String getMaterialPredominante(){
		return materialPredominante;
	}


}
