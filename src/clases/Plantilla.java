package clases;

public class Plantilla {

	//Atributos
	private Cubicacion cubicacion;
	private FichaTecnicaDO ficha;

	//Constructor
	public Plantilla(Cubicacion cubicacion, FichaTecnicaDO ficha, double precioTotal){
		setCubicacion(cubicacion);
		setFichaTecnicaDO(ficha);
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

	//Métodos
	public double calcularPrecioTotal(){
		double precioTotal=0;

		return precioTotal;
	}

}
