package clases;

public class Material {
	//Atributos

	private String nombre;
	private String unidadMedida;
	private double precioUnitario;

	//Constructor
	public Material(String nombre, String unidadMedida, double precioUnitario){
		setNombre(nombre);
		setUnidadMedida(unidadMedida);
		setPrecioUnitario(precioUnitario);				
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
	
	//M�todos
}
