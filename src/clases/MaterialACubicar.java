package clases;

import java.util.UUID;

public class MaterialACubicar {

	//Atributos
	private	Material material;
	private double cantidad;
	private UUID id;
	
	//Constructor
	public MaterialACubicar(Material material, double cantidad){
		setCantidad(cantidad);
		setMaterial(material);		
	}

	//Encapsulamiento	
	public void setMaterial(Material material){
		if(material!=null)
			this.material=material;
		else throw new IllegalArgumentException("El material no puede ser nulo");
	}
	public Material getMaterial(){
		return material;	
	}
	public void setCantidad(double cantidad){
		if(cantidad>0)
			this.cantidad=cantidad;
		else throw new IllegalArgumentException("La cantidad de material debe ser mayor a 0");
	}
	public double getCantidad(){
		return cantidad;	
	}
	public UUID getId() {
		return id;
	}
	public void setId() {
		id = UUID.randomUUID();
	}

	//Métodos
	public double calcularPrecioTotal(){
		return material.getPrecioUnitario()*cantidad;
	}
}