package clases;

import interfaces.Identificable;

public class JefeNucleo implements Identificable{
private String nombre;
private String id;

//Constructor
public JefeNucleo(String nombre, String id) {
	setNombre(nombre);
	setId(id);
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
      throw new IllegalArgumentException("El nombre solo debe tener letras");
   }
   else
		throw new IllegalArgumentException("El nombre no puede estar vacío o ser null");
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}

}
