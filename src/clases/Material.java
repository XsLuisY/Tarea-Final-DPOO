package clases;
import java.util.UUID;
public class Material {
	//Atributos

	private String nombre;
	private String unidadMedida;
	private double precioUnitario;
	private UUID id;
	
	//Constructor
	public Material(String nombre, String unidadMedida, double precioUnitario, UUID id){
		setNombre(nombre);
		setUnidadMedida(unidadMedida);
		setPrecioUnitario(precioUnitario);
		this.id= UUID.randomUUID();
	}

	//Encapsulamiento
	public void setNombre(String nombre){
		this.nombre= nombre;	
	}
	public String getNombre(){
		return nombre;		
	}
	public void setUnidadMedida(String unidadMedida){
		this.unidadMedida= unidadMedida;
	}
	public String getUnidadMedida(){
		return unidadMedida;		
	}
	public void setPrecioUnitario(double precioUnitario){	
		this.precioUnitario=precioUnitario;
	}
	public double getPrecioUnitario(){
		return precioUnitario;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
	//M�todos
}
