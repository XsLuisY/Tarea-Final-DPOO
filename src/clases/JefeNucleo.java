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
	this.nombre = nombre;
}
public UUID getId() {
	return id;
}
public void setId(UUID id) {
	this.id = id;
}

}
