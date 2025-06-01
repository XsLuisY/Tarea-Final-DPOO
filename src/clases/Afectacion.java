package clases;
import java.util.UUID;


public abstract class Afectacion {
	//Atributos
	protected Boolean esDerrumbeTotal;
	protected String materialPredominante;
	protected UUID id;
	//Constructor
	public Afectacion(Boolean esDerrumbeTotal, String materialPredominante,UUID id){
		setEsDerrumbeTotal(esDerrumbeTotal);
		setMaterialPredominante(materialPredominante);
		this.id= UUID.randomUUID();
	}
	//Métodos
	protected abstract void setEsDerrumbeTotal(Boolean esDerrumbeTotal);
	protected abstract Boolean getEsDerrumbeTotal();
	protected abstract void setMaterialPredominante(String materialPredominante);
	protected abstract String getMaterialPredominante();
	protected abstract UUID getId();
	protected abstract void setId(UUID id);
}