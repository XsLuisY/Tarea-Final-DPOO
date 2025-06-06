package clases;
import java.util.UUID;


public class AfectacionTecho extends Afectacion{

	public AfectacionTecho(Boolean esDerrumbeTotal, String materialPredominante, UUID id){
		super(esDerrumbeTotal,materialPredominante,id);		
	}
	public void setEsDerrumbeTotal(Boolean esDerrumbeTotal){
	  if(esDerrumbeTotal==null)
	    throw new NullPointerException("La variable no puede ser null");
	    else
		this.esDerrumbeTotal = esDerrumbeTotal;	
	}
}

	public Boolean getEsDerrumbeTotal(){
		return esDerrumbeTotal;
	}

	public void setMaterialPredominante(String materialPredominante){
	  if (materialPredominante != null && !materialPredominante.trim().isEmpty()) {
    if(materialPredominante.matches()("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+"))
      this.materialPredominante = materialPredominante.trim().replaceAll("\\s+", " ");
    else
      throw new IllegalArgumentException("El material predominante solo debe tener letras");
   }
   else
		throw new IllegalArgumentException("El material predominante no puede estar vacío o ser null");
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
