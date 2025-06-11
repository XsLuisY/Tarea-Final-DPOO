package clases;

import interfaces.Identificable;

public class JefeNucleo{
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
    if(nombre.matches("[a-zA-ZÒ—1234567890 ]+"))
      this.nombre = nombre.trim().replaceAll("\\s+", " ");
    else
      throw new IllegalArgumentException("El nombre solo debe tener letras");
   }
   else
		throw new IllegalArgumentException("El nombre no puede estar vac√≠o o ser null");
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}

}
