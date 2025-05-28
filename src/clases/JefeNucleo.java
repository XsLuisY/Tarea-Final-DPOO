package clases;

import interfaces.Identificable;

public class JefeNucleo implements Identificable{
private String nombre;
private String id;

//Encapsulamiento
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}

}
