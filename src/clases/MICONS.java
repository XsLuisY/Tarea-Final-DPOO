package clases;
import java.util.ArrayList;
import java.util.UUID;

public class MICONS {
	private ArrayList<OficinaTramites> oficinas;
	private ArrayList<Vivienda> viviendas;

	//Constructor 
	public MICONS(){
		oficinas = new ArrayList<OficinaTramites>();
		viviendas = new ArrayList<Vivienda>();
	}
	//Metodos CRUD de OficinaTramites
	//Create
	public Boolean addOficinaTramites(String consejoPopular){
		Boolean agregado= false;
		OficinaTramites oficinaT= new OficinaTramites(consejoPopular);
		if(oficinaT!= null){
		oficinas.add(oficinaT);
		agregado= true;
		}
		return agregado;
	}
	//Read
	public OficinaTramites readByIDOficinaTramites(String id){
		OficinaTramites oficina = null;
		int i=0;
		Boolean found= false;
		while(i<oficinas.size() && !found){
			if(oficinas.get(i).getId().equals(id)){
				found= true;
				oficina= oficinas.get(i);
			}
			i++;
		}
		return oficina;
	}
	//Update
	public Boolean updateOficinaTramites(String id, String consejoPoular, String nuevoConsejo){
		OficinaTramites oficina= readByIDOficinaTramites(id);
		Boolean exit= false;
		if(oficina != null){
			oficina.setConsejoPopular(nuevoConsejo);
			exit=true;
		}
		return exit;
	}
	//Delete
	public Boolean deleteOficinaTramites(String id){
		OficinaTramites oficina = readByIDOficinaTramites(id);
		Boolean exit = false;
		if(oficina != null){
			oficinas.remove(oficina);
			exit= true;
		}
		return exit;
	}

	// Metodos CRUD de Vivienda
	//Create
	public Boolean addVivienda(String nombreJefeN, String idJefeN, String direccion, String documentoLegal, String tipologiaHabitacional, String tipologiaConstructiva, Boolean facilidadTemporal, double largo, double ancho, double altura, int cantNinios, int cantAncianos, int cantEmbarazadas, int totalHabitantes){
		Boolean agg= false;
		Vivienda vivienda= new Vivienda(nombreJefeN, idJefeN, direccion, documentoLegal, tipologiaHabitacional, tipologiaConstructiva, facilidadTemporal, largo, ancho, altura, cantNinios, cantAncianos, cantEmbarazadas, totalHabitantes);
		if(vivienda!=null){
		viviendas.add(vivienda);
		agg= true;
		}
		return agg;
	}
	//Read
	public Vivienda readByIDVivienda(UUID id){
		Vivienda vivienda= null;
		int i=0;
		Boolean found= false;
		while(i<viviendas.size() && !found){
			if(viviendas.get(i).getJefeNucleo().getId().equals(id)){
				found= true;
				vivienda= viviendas.get(i);
			}
			i++;
		}
		return vivienda;
	}
	//Update
	public Boolean updateVivienda(String newNombreJefeN, UUID idJefeN, String newDireccion, String newDocumentoLegal, String newTipologiaHabitacional, String newTipologiaConstructiva, Boolean newFacilidadTemporal, double newLargo, double newAncho, double newAltura, int newCantNinios, int newCantAncianos, int newCantEmbarazadas, int newTotalHabitantes){
		Vivienda vivienda= readByIDVivienda(idJefeN);
		Boolean exit= false;
		if(vivienda != null){
			vivienda.getJefeNucleo().setNombre(newNombreJefeN);
			vivienda.setDireccion(newDireccion);
			vivienda.setDocumentoLegal(newDocumentoLegal);
			vivienda.setTipologiaHabitacional(newTipologiaHabitacional);
			vivienda.setTipologiaConstructiva(newTipologiaConstructiva);
			vivienda.setFacilidadTemporal(newFacilidadTemporal);
			vivienda.setLargo(newLargo);
			vivienda.setAncho(newAncho);
			vivienda.setAltura(newAltura);
			vivienda.setCantNinios(newCantNinios);
			vivienda.setCantAncianos(newCantAncianos);
			vivienda.setCantEmbarazadas(newCantEmbarazadas);
			vivienda.setTotalHabitantes(newTotalHabitantes);
			exit=true;
		}
		return exit;
	}
	//Delete
	public Boolean deleteVivienda(UUID id){
		Vivienda vivienda = readByIDVivienda(id);
		Boolean exit = false;
		if(vivienda != null){
			viviendas.remove(vivienda);
			exit= true;
		}
		return exit;
	}

	/*
	//Reportes

	//Anthony

	//Luis

	//3.........................................
	public void mostrarCantElementoAfectado(){		
	}
	//4.........................................
		Arreglar utilizando el metodo de busqueda mencionado en clase
	
	public void mostrarMaterialMasCaro(){
		OficinaTramites aux=null;
		for(OficinaTramites o: oficinas)
			if(o.buscarMaterialMasCaro().calcularPrecioTotal()>aux.buscarMaterialMasCaro().calcularPrecioTotal())
				aux=o;					
	}
*/
}







