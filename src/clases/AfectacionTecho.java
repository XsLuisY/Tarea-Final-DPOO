package clases;
import java.util.UUID;


public class AfectacionTecho extends Afectacion{

	public AfectacionTecho(Boolean esDerrumbeTotal, String materialPredominante){
		super(esDerrumbeTotal,materialPredominante);		
	}
	public void setEsDerrumbeTotal(Boolean esDerrumbeTotal){
		if(esDerrumbeTotal==null)
			throw new NullPointerException("El tipo de derrumbe no puede ser null");
		else
			this.esDerrumbeTotal = esDerrumbeTotal;	
	}


	public Boolean getEsDerrumbeTotal(){
		return esDerrumbeTotal;
	}

	public void setMaterialPredominante(String materialPredominante){
		if (materialPredominante == null)
		throw new NullPointerException("El material predominante no debe ser null");
		if(!materialPredominante.trim().isEmpty()) {
			if(materialPredominante.matches("[a-zA-Z�����������1234567890 ]+"))
				this.materialPredominante = materialPredominante.trim().replaceAll("\\s+", " ");
			else
				throw new IllegalArgumentException("El material predominante no debe estar vacío y solo debe tener letras");
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
	@Override
	public void setId() {
		do
			id=UUID.randomUUID();
		while(MICONS.existUUID(id));		
	}

}
