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
	public UUID getId(){
		return id;
	}
	public void setId(UUID id){
		this.id= id;
	}

}
