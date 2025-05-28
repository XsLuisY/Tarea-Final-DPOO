package clases;

public class AfectacionTecho extends Afectacion{

	public AfectacionTecho(Boolean esDerrumbeTotal, String materialPredominante){
		super(esDerrumbeTotal,materialPredominante);		
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
