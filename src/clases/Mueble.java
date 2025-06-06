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
	 if (nombre != null && !nombre.trim().isEmpty()) {
    if(nombre.matches()("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+"))
      this.nombre = nombre.trim().replaceAll("\\s+", " ");
    else
      throw new IllegalArgumentException("El nombre del mueble solo debe tener letras");
   }
   else
		throw new IllegalArgumentException("El nombre del mueble no puede estar vacío o ser null");
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
   if (cantidad >=0 && cantidad <=80) {
    this.cantidad= cantidad;
}
else
		throw new IllegalArgumentException("La cantidad no puede ser menor a 0. Por favor introduzca una cantidad mayor o igual que 0 y menor o igual a 80");
	}
	

	//M�todos

}
