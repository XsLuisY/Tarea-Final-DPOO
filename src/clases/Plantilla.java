package clases;

public class Plantilla {

	//Atributos
	private Cubicacion cubicacion;
	private FichaTecnicaDO ficha;
	private int id;
	//Constructor
	public Plantilla(Cubicacion cubicacion, FichaTecnicaDO ficha){
		setCubicacion(cubicacion);
		setFichaTecnicaDO(ficha);
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//Métodos
	public double calcularPrecioTotal(){
		double precioTotal=0;

		return precioTotal;
	}


}
