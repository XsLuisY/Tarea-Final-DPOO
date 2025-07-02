package clases;
import java.util.UUID;

import clases.Afectacion;

public class AfectacionTecho extends Afectacion{

	//Constructor
	public AfectacionTecho(Boolean esDerrumbeTotal, String materialPredominante){
		super(esDerrumbeTotal,materialPredominante);		
	}

	//Encapsulamiento
	@Override
	public void setEsDerrumbeTotal(Boolean esDerrumbeTotal){
		if(esDerrumbeTotal==null)
			throw new NullPointerException("El tipo de derrumbe no puede ser null.");
		else
			this.esDerrumbeTotal = esDerrumbeTotal;	
	}
	@Override
	public Boolean getEsDerrumbeTotal(){
		return esDerrumbeTotal;
	}
	@Override
	public void setMaterialPredominante(String materialPredominante){
		if (materialPredominante == null)
			throw new NullPointerException("El material predominante no puede ser null.");
		else
			if(!materialPredominante.trim().isEmpty()) {
				if(materialPredominante.matches("[a-zA-ZÒ—·ÈÌÛ˙¡…Õ”⁄1234567890 ]+"))
					this.materialPredominante = materialPredominante.trim().replaceAll("\\s+", " ");
				else
					throw new IllegalArgumentException("El nombre del material predominante no puede tener caracteres especiales.");
			}
			else
				throw new IllegalArgumentException("Debe introducir el nombre del material predominante.");
	}
	@Override
	public String getMaterialPredominante(){
		return materialPredominante;
	}

	@Override
	public UUID getId(){
		return id;
	}
	@Override
	public void setId() {
		do
			id=UUID.randomUUID();
		while(MICONS.existUUID(id));		
	}

}
