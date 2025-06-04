package clases;
import java.util.UUID;


public class AfectacionTecho extends Afectacion{

	public AfectacionTecho(Boolean esDerrumbeTotal, String materialPredominante, UUID id){
		super(esDerrumbeTotal,materialPredominante,id);		
	}
	public void setEsDerrumbeTotal(Boolean esDerrumbeTotal){
	  if(esDerrumbeTotal==null)
	    throw new NullPointerException("Algo raro pasó xd");
	    else
		this.esDerrumbeTotal = esDerrumbeTotal;	
	}
}

	public Boolean getEsDerrumbeTotal(){
		return esDerrumbeTotal;
	}

	public void setMaterialPredominante(String materialPredominante){
	  if (materialPredominante== null) {
    throw new NullPointerException("El material es null, algo raro pasó xD");
}
else{
   if (nombre.trim().isEmpty()) {
    throw new IllegalArgumentException("El nombre del material está vacío o solo tiene espacios. Por favor introduzca un nombre para el material");
}
else
		this.materialPredominante= materialPredominante;
	}
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
