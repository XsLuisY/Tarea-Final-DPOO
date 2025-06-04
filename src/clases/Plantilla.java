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
		this.id= UUID.randomUUID();
	}

	public Plantilla() {
		cubicacion=null;
		ficha=null;
	}

	//Encapsulamiento
	public void setCubicacion(Cubicacion cubicacion){
		this.cubicacion= cubicacion;
	}
	public Cubicacion getCubicacion(){
		return cubicacion;
	}
	public void setFichaTecnicaDO(FichaTecnicaDO ficha){
		this.ficha= ficha;		
	}
	public FichaTecnicaDO setFichaTecnicaDO(){
		return ficha;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
	//M�todos
	public double calcularPrecioTotal(){
		double precioTotal=0;

		return precioTotal;
	}


}
