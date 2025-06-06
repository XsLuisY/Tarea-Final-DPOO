package clases;

import java.util.UUID;

public class Material {
	//Atributos
	private String nombre;
	private String unidadMedida;
	private double precioUnitario;
	private UUID id;

	//Constructor
	public Material(String nombre, String unidadMedida, double precioUnitario){
		setNombre(nombre);
		setUnidadMedida(unidadMedida);
		setPrecioUnitario(precioUnitario);				
	}

	//Encapsulamiento
	public void setNombre(String nombre){
		if(nombre!=null && !nombre.trim().isEmpty())
			if(nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+"))
				this.nombre=nombre.trim().replaceAll("\\s+", " ");		
			else throw new IllegalArgumentException("El nombre del Consejo Popular no puede contiene números o caracteres no válidos.");
		else throw new IllegalArgumentException("El nombre del Consejo Popular no puede estar vacío.");		
	}
	public String getNombre(){
		return nombre;		
	}
	public void setUnidadMedida(String unidadMedida){
		if(unidadMedida!=null && unidadMedida.trim().isEmpty())
			this.unidadMedida=unidadMedida;
		else throw new IllegalArgumentException("La unidad de medida no puede ser nula");
	}
	public String getUnidadMedida(){
		return unidadMedida;		
	}
	public void setPrecioUnitario(double precioUnitario){	
		if(precioUnitario>0)
			this.precioUnitario=precioUnitario;
		else throw new IllegalArgumentException("El precio debe ser mayor que 0");
	}
	public double getPrecioUnitario(){
		return precioUnitario;
	}
	public UUID getId() {
		return id;
	}
	public void setId() {
		id=UUID.randomUUID();
	}

	//Métodos
}
