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
	  if (nombre == null) {
    throw new NullPointerException("El nombre es null, algo raro pasó xD");
}
else{
   if (nombre.trim().isEmpty()) {
    throw new IllegalArgumentException("El nombre está vacío o solo tiene espacios. Por favor introduzca un nombre");
}
else
		this.nombre = nombre;
	}
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
	  if (cantidad == null) {
    throw new NullPointerException("La cantidad es null, algo raro pasó xD");
}
else{
   if (cantidad <0 || cantidad >80) {
    throw new IllegalArgumentException("La cantidad no puede ser menor a 0. Por favor introduzca una cantidad mayor o igual que 0 y menor o igual a 80");
}
else
		this.cantidad = cantidad;
	}
	}

	//M�todos

}
