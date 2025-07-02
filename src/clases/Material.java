package clases;
import interfaces.Identificable;

import java.util.UUID;

public class Material implements Identificable {
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
		setId();
	}

	//Encapsulamiento
	public void setNombre(String nombre){
		if(nombre!=null && !nombre.trim().isEmpty())
			if(nombre.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ1234567890 ]+"))
				this.nombre=nombre.trim().replaceAll("\\s+", " ");		
			else throw new IllegalArgumentException("El nombre del Consejo Popular no puede contiene numeros o caracteres no validos.");
		else throw new IllegalArgumentException("El nombre del Consejo Popular no puede estar vacio.");		
	}
	public String getNombre(){
		return nombre;		
	}
	public void setUnidadMedida(String unidadMedida){
		if(unidadMedida!=null && !unidadMedida.trim().isEmpty())
			this.unidadMedida=unidadMedida;
		else throw new IllegalArgumentException("La unidad de medida no puede ser nula");
	}
	public String getUnidadMedida(){
		return unidadMedida;		
	}
	public void setPrecioUnitario(Double precioUnitario){	
			
		if(precioUnitario>0)		
			this.precioUnitario=precioUnitario;
		else throw new IllegalArgumentException("El precio debe ser mayor que 0");
	}
	
	public Double getPrecioUnitario(){
		return precioUnitario;
	}

	public UUID getId() {
		return id;
	}
	public void setId() {
		do
			id=UUID.randomUUID();
		while(MICONS.getMICONS().getListaId().containsKey(id));
		MICONS.getMICONS().getListaId().put(id, this);
	}

	//Metodos
 }
