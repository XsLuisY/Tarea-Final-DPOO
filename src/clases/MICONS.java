package clases;
import java.util.ArrayList;

public class MICONS {
	private ArrayList<OficinaTramites> oficinas;
	private ArrayList<Vivienda> viviendas;
	
	//Constructor 
	public MICONS(){
		oficinas = new ArrayList<OficinaTramites>();
		viviendas = new ArrayList<Vivienda>();
	}

	//Métodos 
	public void addOficinaTramites(OficinaTramites oficina){
		oficinas.add(oficina);
	}
	public void addVivienda(Vivienda vivienda){
		viviendas.add(vivienda);
	}
	
	//Reportes
	
	//Anthony
	
	//Luis
	
	//3.........................................
	public void mostrarCantElementoAfectado(){		
	}
	//4.........................................
	/*TODO:
		Arreglar utilizando el metodo de busqueda mencionado en clase*/
	public void mostrarMaterialMasCaro(){
		OficinaTramites aux=null;
		for(OficinaTramites o: oficinas)
		if(o.buscarMaterialMasCaro().calcularPrecioTotal()>aux.buscarMaterialMasCaro().calcularPrecioTotal())
			aux=o;					
	}
}







