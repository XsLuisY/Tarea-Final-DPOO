package clases;

public class Mueble {

	//Atributos
	private String nombre;
	private int cantidad;

	//Constructor 
	public Mueble(String nombre, int cantidad){
		setNombre(nombre);
		setCantidad(cantidad);
	}

	//Encapsulamiento
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	//Métodos

}
