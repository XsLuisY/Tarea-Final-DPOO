package clases;
import java.util.UUID;


public class AfectacionPared extends Afectacion{
	//Atributos
	private Boolean esDeCarga;

	//Constructor 
	public AfectacionPared(Boolean esDerrumbeTotal, String materialPredominante, Boolean esDeCarga){
		super(esDerrumbeTotal,materialPredominante);
		setEsDeCarga(esDeCarga);
	}

	//Encapsulamiento
	public Boolean getEsDeCarga() {
		return esDeCarga;
	}
	public void setEsDeCarga(Boolean esDeCarga) {
		if(esDeCarga!=null)		
			this.esDeCarga = esDeCarga;
		else throw new NullPointerException("El tipo de pared no puede ser null");
	}

	public void setEsDerrumbeTotal(Boolean esDerrumbeTotal){
		if(esDerrumbeTotal!=null)
			this.esDerrumbeTotal = esDerrumbeTotal;	
		else throw new NullPointerException("El tipo de derrumbe no puede ser null");
	}

	public Boolean getEsDerrumbeTotal(){
		return esDerrumbeTotal;
	}

	public void setMaterialPredominante(String materialPredominante){
		if (materialPredominante == null)
		throw new NullPointerException("El material predominante no debe ser null");
		else
		  if(!materialPredominante.trim().isEmpty()) {
      if(materialPredominante.matches("[a-zA-ZÒ—·ÈÌÛ˙¡…Õ”⁄1234567890 ]+"))
				this.materialPredominante = materialPredominante.trim().replaceAll("\\s+", " ");
			else
				throw new IllegalArgumentException("El material predominante no debe estar vac√≠o y solo debe tener letras");
		}
	}
	public String getMaterialPredominante(){
		return materialPredominante;
	}
	public UUID getId(){
		return id;
	}
	public void setId(){
		do
			id=UUID.randomUUID();		
		while(MICONS.existUUID(id));
	}

}
