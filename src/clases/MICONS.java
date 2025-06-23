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
		Boolean add=false;
		OficinaTramites o= readOficinaTramites(consejoPopular);
		if(o==null){
			OficinaTramites oficina= new OficinaTramites(consejoPopular);
			if(oficina!=null){
				add= true;
				oficinas.add(oficina);
			}
			}
		else 
			throw new IllegalArgumentException("Esta Oficina de Tramites ya existe");
		return add;
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
		Boolean updt= false;
		OficinaTramites o= readOficinaTramites(nuevoConsejo);
		OficinaTramites oficina= readOficinaTramites(consejoPopular);
		if(oficina!=null){
			if(o==null){
				oficina.setConsejoPopular(nuevoConsejo);
				updt= true;
			}
			else throw new IllegalArgumentException("El nombre que intentas poner ya existe en otra Oficina de Tramites");
		}
		else throw new IllegalArgumentException("Esta Oficina de Tramites no existe");
		return updt;
	}
	/*Delete*/ public Boolean deleteOficinaTramites(String consejoPopular){
		Boolean del= false;
		OficinaTramites oficina= readOficinaTramites(consejoPopular);
		if(oficina!=null){
			oficinas.remove(oficina);
			del= true;
		}
		else throw new IllegalArgumentException("Esta OficinaTramites no existe");
		return del;
	}


	// Metodos CRUD de Vivienda
	/*Create*/ public Boolean addVivienda(Vivienda viv){
		Boolean add= false;
		Vivienda v= readByIDVivienda(viv.getJefeNucleo().getCI());
		if(v==null){
			Vivienda vivienda= viv;
			if(vivienda!=null){
				viviendas.add(vivienda);
				add= true;
			}
		}
		else throw new IllegalArgumentException("Esta vivienda ya existe");
		return add;
	}
	/*Read */ public Vivienda readByIDVivienda(String id){
		Vivienda vivienda= null;
		int i=0;
		Boolean found= false;
		while(i<viviendas.size() && !found){
			if(viviendas.get(i).getJefeNucleo().getCI().equals(id)){
				found= true;
				vivienda= viviendas.get(i);
			}
			i++;
		}
		return vivienda;
	}
	/*Update*/ public Boolean updateVivienda(String newNombreJefeN, String ciJefeN, String newDireccion, String newDocumentoLegal, String newTipologiaHabitacional, String newTipologiaConstructiva, Boolean newFacilidadTemporal, double newLargo, double newAncho, double newAltura, int newCantNinios, int newCantAncianos, int newCantEmbarazadas, int newTotalHabitantes){
		Vivienda vivienda= readByIDVivienda(ciJefeN);
		Boolean updt= false;
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
			updt=true;
		}
		else throw new IllegalArgumentException("Esta vivienda no existe");
		return updt;
	}
	/*Delete*/ public Boolean deleteVivienda(String id){
		Vivienda vivienda = readByIDVivienda(id);
		Boolean exit = false;
		if(vivienda != null){
			viviendas.remove(vivienda);
			exit= true;
		}
		else throw new IllegalArgumentException("Esta vivienda no existe");
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

	public void inicializarViviendas(){
		viviendas.add(new Vivienda("Paco","05012045762","Calle J entre L y K","Propiedad","Casa","Tipo II",true,4,5,4,2,3,1,6));
		viviendas.add(new Vivienda("Luis","05011045061","Calle 20 entre 23 y 21","Propiedad","Casa","Tipo I",false,3,3,4,2,1,1,5));
		viviendas.add(new Vivienda("Ernesto","03061545181","Calle Fernanda entre C y B","Usufructo","Apartamento","Tipo III",true,3,4,4,1,0,1,3));
		viviendas.add(new Vivienda("Diana","02092317632","Calle A entre D y C","Arrendamiento","Otro","Tipo IV",false,5,5,4,3,0,0,8));
		viviendas.add(new Vivienda("Ana","01120564637","Calle Balear entre Piedra y Soto","Providencia","Bohío","Tipo V",false,6,7,5,2,0,1,7));
	}

}



