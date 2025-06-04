package clases;

import interfaces.Identificable;
import java.util.UUID;

public class JefeNucleo implements Identificable{
private String nombre;
private UUID id;

//Constructor
public JefeNucleo(String nombre, UUID id) {
	setNombre(nombre);
	setId(id);
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
public UUID getId() {
	return id;
}
public void setId(UUID id) {
	this.id = id;
}

}
