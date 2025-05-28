package clases;

public class MaterialACubicar {

	//Atributos
	private	Material material;
	private double cantidad;

	//Constructor
	public MaterialACubicar(Material material, double cantidad){
		setCantidad(cantidad);
		setMaterial(material);		
	}

	//Encapsulamient
	public void setCantidad(double cantidad){
		this.cantidad=cantidad;
	}
	public double getCantidad(){
		return cantidad;	
	}
	public void setMaterial(Material material){
		this.material=material;
	}
	public Material getMaterial(){
		return material;	
	}

	//Métodos
	public double calcularPrecioTotal(){
		return material.getPrecioUnitario()*cantidad;
	}
}



