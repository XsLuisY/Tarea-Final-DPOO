package clases;

import interfaces.Identificable;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class JefeNucleo{
private String nombre;
private String ci;

//Constructor
public JefeNucleo(String nombre, String ci) {
	setNombre(nombre);
	setCI(ci);
}
public JefeNucleo() {
nombre=null;
ci=null;
}
//Encapsulamiento
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
  if (nombre != null && !nombre.trim().isEmpty()) {
    if(nombre.matches("[a-zA-Z·ÈÌÛ˙¡…Õ”⁄Ò— ]+"))
      this.nombre = nombre.trim().replaceAll("\\s+", " ");
    else
      throw new IllegalArgumentException("El nombre solo debe tener letras");
   }
   else
		throw new IllegalArgumentException("El nombre no puede estar vac√≠o o ser null");
}
public String getCI() {
	return ci;
}
public void setCI(String id) {

		//int num;

		if(!id.replaceAll(" ", "").equalsIgnoreCase("") && id.matches("[0-9]+") && id.length() == 11){
			SimpleDateFormat fecha = new SimpleDateFormat("yyMMdd"); 
			fecha.setLenient(false);

			try{
				fecha.parse(id.substring(0, 6));
				this.ci = id;
			}catch(ParseException e){
				throw new IllegalArgumentException("Los 6 primeros d√≠gitos del carnet de identidad deben representar la fecha real");
			}
		}else
			throw new IllegalArgumentException("El carnet de identidad debe estar compuesto por 11 d√≠gitos");
	}
}
