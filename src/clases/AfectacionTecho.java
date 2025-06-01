package clases;
import java.util.UUID;


public class AfectacionTecho extends Afectacion{

	public AfectacionTecho(Boolean esDerrumbeTotal, String materialPredominante, UUID id){
		super(esDerrumbeTotal,materialPredominante,id);		
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
	public UUID getId(){
		return id;
	}
	public void setId(UUID id){
		this.id= id;
	}

}
