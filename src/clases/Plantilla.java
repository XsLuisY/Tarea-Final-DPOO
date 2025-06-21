package clases;
import java.util.UUID;

public class Plantilla {

	//Atributos
	private Cubicacion cubicacion;
	private FichaTecnicaDO ficha;
	private UUID id;

	//Constructor
	public Plantilla(Cubicacion cubicacion, FichaTecnicaDO ficha){
		setCubicacion(cubicacion);
		setFichaTecnicaDO(ficha);
		setId();
	}

	//Encapsulamiento
	public void setCubicacion(Cubicacion cubicacion){
		if(cubicacion!=null)
			this.cubicacion= cubicacion;
		else throw new IllegalArgumentException("La cubicación no puede ser nula");
	}
	public Cubicacion getCubicacion(){
		return cubicacion;
	}
	public void setFichaTecnicaDO(FichaTecnicaDO ficha){
		if(ficha!=null)
			this.ficha= ficha;	
		else throw new IllegalArgumentException("La Ficha Técnica de Daños Ocasionados no puede ser nula");
	}
	public FichaTecnicaDO getFichaTecnicaDO(){
		return ficha;
	}
	public UUID getId() {
		return id;
	}

	public void setId() {
		do
			id=UUID.randomUUID();
		while(MICONS.existUUID(id));
	}

	//Metodos
	public double calcularPrecioTotal(){
		return	cubicacion.calcularPrecioTotal();
	}


}
