package clases;
import java.util.UUID;


public class AfectacionPared extends Afectacion{
	//Atributos
	private Boolean esDeCarga;

	//Constructor 
	public AfectacionPared(Boolean esDerrumbeTotal, String materialPredominante, UUID id, Boolean esDeCarga){
		super(esDerrumbeTotal,materialPredominante, id);
		setEsDeCarga(esDeCarga);
	}

	//Encapsulamiento
	public Boolean getEsDeCarga() {
		return esDeCarga;
	}
	public void setEsDeCarga(Boolean esDeCarga) {
	  if(esDeCarga==null)
	    throw new NullPointerException("La variable no puede ser null");
	    else
		this.esDeCarga = esDeCarga;
	}

	public void setEsDerrumbeTotal(Boolean esDerrumbeTotal){
	  if(esDerrumbeTotal==null)
	    throw new NullPointerException("La variable no puede ser null");
	    else
		this.esDerrumbeTotal = esDerrumbeTotal;	
	}

	public Boolean getEsDerrumbeTotal(){
		return esDerrumbeTotal;
	}
	public void setMaterialPredominante(String materialPredominante){
	  if (materialPredominante != null && !materialPredominante.trim().isEmpty()) {
    if(materialPredominante.matches("[a-zA-ZÒ—1234567890 ]+"))
      this.materialPredominante = materialPredominante.trim().replaceAll("\\s+", " ");
    else
      throw new IllegalArgumentException("El material predominante solo debe tener letras");
   }
   else
		throw new IllegalArgumentException("El material predominante no puede estar vac√≠o o ser null");
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
