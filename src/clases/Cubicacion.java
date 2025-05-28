package clases;

import java.util.ArrayList;

public class Cubicacion {

	//Atributos	
	private ArrayList<MaterialACubicar> materiales;

	//Constructor
	public Cubicacion(){
		materiales = new ArrayList<MaterialACubicar>();
	}

	//Métodos
	public boolean AddMaterialACubicar(MaterialACubicar material){
		boolean agregado=false;
		if(material!=null){
			materiales.add(material);
			agregado=true;
			}
		//		else
		//lanzar excepcion
return agregado;
	}

	public double calcularPrecioTotal(){
		double precioTotal=0;
		for(MaterialACubicar m: materiales){
			precioTotal+=m.calcularPrecioTotal();
		}
		return precioTotal;
	}


}
