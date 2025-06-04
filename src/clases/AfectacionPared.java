package clases;
import java.util.UUID;


public class AfectacionPared extends Afectacion{
	//Atributos
	private Boolean esDeCarga;

	//Constructor
 crudMICONSOficinaT
	public AfectacionPared(Boolean esDerrumbeTotal, String materialPredominante, UUID id, Boolean esDeCarga){
		super(esDerrumbeTotal,materialPredominante
		setEsDeCarga(esDeCarga);
	}

	//Encapsulamiento
	public Boolean getEsDeCarga() {
		return esDeCarga;
	}
	public void setEsDeCarga(Boolean esDeCarga) {
	  if(esDeCarga==null)
	    throw new NullPointerException("Algo raro pasó xd");
	    else
		this.esDeCarga = esDeCarga;
	}
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
