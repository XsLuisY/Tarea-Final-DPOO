package clases;
import interfaces.Identificable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class MICONS {
	private static MICONS micons = null;
	private static HashMap<UUID, Identificable> listaId = null;

	private ArrayList<OficinaTramites> oficinas;
	private ArrayList<Vivienda> viviendas;
	//Singleton
	public static MICONS getMICONS() {
		if (micons == null)
			micons = new MICONS();		
		return micons;
	}
	//Constructor 
	private MICONS(){
		oficinas = new ArrayList<OficinaTramites>();
		viviendas = new ArrayList<Vivienda>();		
		listaId = new HashMap<UUID, Identificable>();
	}
	//Encapsulamiento
	public ArrayList<OficinaTramites> getOficinaTramites(){
		return oficinas;
	}
	public static Boolean existUUID(UUID id){
		Boolean exist=false;
		for(int i=0; i<listaId.size()&& !exist; i++)
			if(listaId.containsKey(id))
				exist=true;
		return exist;
	}
	//CRUD-OficinaTramites
	/*Create*/ public Boolean addOficinaTramites(String consejoPopular){
		OficinaTramites oficina= new OficinaTramites(consejoPopular);
		Boolean agregado=false;

		if(oficina!=null && !existOficinaTramites(consejoPopular)){
			oficinas.add(oficina);
			agregado=true;
		}
		return agregado;
	}
	/*Read*/ public OficinaTramites readOficinaTramites(String consejoPopular){
		OficinaTramites oficina = null;
		int i=0;
		Boolean found= false;
		while(i<oficinas.size() && !found){
			if(oficinas.get(i).getConsejoPopular().equalsIgnoreCase(consejoPopular)){
				found= true;
				oficina= oficinas.get(i);
			}
			i++;
		}
		return oficina;
	}
	/*Update*/ public Boolean updateOficinaTramites(String consejoPopular, String nuevoConsejo){
		Boolean updt=false;

		if(existOficinaTramites(nuevoConsejo)){		
			OficinaTramites o = readOficinaTramites(consejoPopular);
			if(o!=null){
				o.setConsejoPopular(nuevoConsejo);
				updt=true;
			}
			else throw new IllegalArgumentException("La OficinaTramites original no existe");
		}
		else throw new IllegalArgumentException("Ya existe una OficinaTramites con ese nombre");

		return updt;
	}
	/*Delete*/ public Boolean deleteOficinaTramites(String consejoPopular){
		Boolean del=existOficinaTramites(consejoPopular);

		if(del)			
			oficinas.remove(readOficinaTramites(consejoPopular));
		else throw new IllegalArgumentException("Esta OficinaTramites no existe");

		return del;
	}
	public Boolean existOficinaTramites(String consejoPopular){
		//Verificar si la OficinaTramites existe a traves de su consejoPopular
		Boolean exist=false;

		for (int i=0; i<oficinas.size() && !exist; i++)
			if (oficinas.get(i).getConsejoPopular().equalsIgnoreCase(consejoPopular))
				exist=true;

		return exist;
	}

	// Metodos CRUD de Vivienda
	/*Create*/ public Boolean addVivienda(String nombreJefeN, String idJefeN, String direccion, String documentoLegal, String tipologiaHabitacional, String tipologiaConstructiva, Boolean facilidadTemporal, double largo, double ancho, double altura, int cantNinios, int cantAncianos, int cantEmbarazadas, int totalHabitantes){
		Boolean agg= false;
		Vivienda vivienda= new Vivienda(nombreJefeN, idJefeN, direccion, documentoLegal, tipologiaHabitacional, tipologiaConstructiva, facilidadTemporal, largo, ancho, altura, cantNinios, cantAncianos, cantEmbarazadas, totalHabitantes);
		if(vivienda!=null){
			viviendas.add(vivienda);
			agg= true;
		}
		return agg;
	}
	/*Read */ public Vivienda readByIDVivienda(UUID id){
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
	/*Update*/ public Boolean updateVivienda(String newNombreJefeN, UUID idJefeN, String newDireccion, String newDocumentoLegal, String newTipologiaHabitacional, String newTipologiaConstructiva, Boolean newFacilidadTemporal, double newLargo, double newAncho, double newAltura, int newCantNinios, int newCantAncianos, int newCantEmbarazadas, int newTotalHabitantes){
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
	/*Delete*/ public Boolean deleteVivienda(UUID id){
		Vivienda vivienda = readByIDVivienda(id);
		Boolean exit = false;
		if(vivienda != null){
			viviendas.remove(vivienda);
			exit= true;
		}
		return exit;
	}


	//Reportes

	//Anthony

	//Luis

	//3.........................................
	public void mostrarCantElementoAfectado(){		
	}
	//4.........................................

	public void mostrarMaterialMasCaro(){
		double costoM=0;			
		double auxCostoM;
		ArrayList<Cubicacion> cubicaciones = new ArrayList<Cubicacion>();
		ArrayList<Cubicacion> auxCubicaciones = new ArrayList<Cubicacion>();

		for(OficinaTramites o: oficinas){
			auxCubicaciones=o.buscarCubicacionesMayorCosto();
			auxCostoM=auxCubicaciones.get(0).calcularPrecioTotal();

			if(auxCostoM>costoM){							
				costoM=auxCostoM;
				cubicaciones.clear();
			}
			if(costoM==auxCostoM)
				cubicaciones.addAll(auxCubicaciones);
		}
	}


	//-------------------------------------Inicializar Datos-----------------------------------------------------
	//----------Oficinas de Tramites
	public void inicializarOficinaTramites(){
		oficinas.add(new OficinaTramites("Arroyo Naranjo"));	
		oficinas.add(new OficinaTramites("Boyeros"));	
		oficinas.add(new OficinaTramites("Vedado"));	
		oficinas.add(new OficinaTramites("10 de Octubre"));	
		oficinas.add(new OficinaTramites("Cotorro"));	
		oficinas.add(new OficinaTramites("Cerro"));	
		oficinas.add(new OficinaTramites("La Lisa"));		
	}


}



