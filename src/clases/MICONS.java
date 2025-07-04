package clases;

import interfaces.Identificable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.UUID;


public class MICONS {
	private static MICONS micons = null;
	private static HashMap<UUID, Identificable> listaId = null;
	private static HashMap<Vivienda, Boolean> listaViviendaAsignada = null;
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
		listaViviendaAsignada = new HashMap<Vivienda, Boolean>();
	}
	//Encapsulamiento
	public HashMap<Vivienda, Boolean> getListaViviendaAsignada(){
		return listaViviendaAsignada;
	}
	public HashMap<UUID, Identificable> getListaId(){
		return listaId;
	}
	public ArrayList<OficinaTramites> getOficinaTramites(){
		return oficinas;
	}	
	public ArrayList<Vivienda> getViviendas(){
		return viviendas;
	}

	public static Boolean existUUID(UUID id){
		Boolean exist=false;		
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
	/*Create*/ public Boolean addVivienda(Vivienda vivienda){
		Boolean add= false;

		if(vivienda!=null){
			if(readVivienda(vivienda.getJefeNucleo().getCI())==null){
				viviendas.add(vivienda);
				getListaViviendaAsignada().put(vivienda, false);
				add= true;
			}
			else throw new IllegalArgumentException("Esta vivienda ya existe");
		}
		else throw new NullPointerException("La nueva vivienda no puede ser null");

		return add;
	}
	/*Read */ public Vivienda readVivienda(String id){
		Vivienda vivienda= null;
		int i=0;
		while(i<viviendas.size() && vivienda==null){
			if(viviendas.get(i).getJefeNucleo().getCI().equals(id)){
				vivienda= viviendas.get(i);
			}
			i++;
		}
		return vivienda;
	}
	/*Update*/ public Boolean updateVivienda(String newNombreJefeN, String ciJefeN, String newDireccion, String newDocumentoLegal, String newTipologiaHabitacional, String newTipologiaConstructiva, Boolean newFacilidadTemporal, double newLargo, double newAncho, double newAltura, int newCantNinios, int newCantAncianos, int newCantEmbarazadas, int newTotalHabitantes){
		Vivienda vivienda= readVivienda(ciJefeN);
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
	/*Delete*/ public void deleteVivienda(String id){
		Vivienda vivienda = readVivienda(id);		
		if(vivienda != null)
			if(!MICONS.getMICONS().getListaViviendaAsignada().get(vivienda)){
				MICONS.getMICONS().getListaViviendaAsignada().remove(vivienda);			
				viviendas.remove(vivienda);				
			}		
			else throw new IllegalArgumentException("Esta vivienda tiene dictamenes asociados, para borrarla no debe tener ninguno.");
		else throw new NullPointerException("Esta vivienda no existe");		
	}


	//Reportes

	//Anthony
	// 1
	public Map<String, Double> buscarAfectacionTipologiaConstructiva() {
	  if(viviendas==null || viviendas.isEmpty())
	    throw new IllegalArgumentException("Debe existir al menos una vivienda");
	    else{
		Map<String, Integer> conteoPorTipo = new LinkedHashMap<>();
		String[] tipos = {"Tipo I", "Tipo II", "Tipo III", "Tipo IV", "Tipo V"};
		for (String tipo : tipos) {
			conteoPorTipo.put(tipo, 0);
		}

		int totalViviendas = viviendas.size();

		for (Vivienda v : viviendas) {
			String tipo = v.getTipologiaConstructiva();		      
			conteoPorTipo.put(tipo, conteoPorTipo.get(tipo) + 1);		       
		}

		Map<String, Double> porcentajes = new LinkedHashMap<>();
		for (String tipo : conteoPorTipo.keySet()) {
			int cantidad = conteoPorTipo.get(tipo);
			double porcentaje = totalViviendas > 0 ? (cantidad * 100.0) / totalViviendas : 0.0;
			porcentajes.put(tipo, porcentaje);
		}
}
		return porcentajes;
	}


	// 2
	public ArrayList<Vivienda> buscarViviendasMasVulnerables(){
	  if(viviendas==null || viviendas.isEmpty())
	    throw new IllegalArgumentException("Debe existir al menos una vivienda");
	    else{
		ArrayList<Vivienda> vulnerables= new ArrayList<Vivienda>();
		int mayor= 0;
		int mayoraux;
			for(Vivienda v: viviendas){
				mayoraux= v.getCantNinos()+v.getCantAncianos()+v.getCantEmbarazadas();
				if (mayoraux > mayor) {
					mayor = mayoraux;
					vulnerables.clear();
					vulnerables.add(v); 
				} else if (mayoraux == mayor) {
					vulnerables.add(v);
				}
			}
		}
		return vulnerables;
	}
	//Luis

	//3.........................................
	public Map<String, Integer> mostrarCantElementoAfectado(){	
	  if(oficinas==null || oficinas.isEmpty())
	     throw new IllegalArgumentException("Debe existir al menos una oficina de tramites");
	     else 
	        if(oficinas.getFichas()==null || oficinas.getFichas().isEmpty())
	         throw new IllegalArgumentException("Debe existir al menos una ficha técnica");
	         else
	           if(oficinas.getFichas().getAfectaciones()==null || oficinas.getFichas().getAfectaciones().isEmpty())
	           throw new IllegalArgumentException("Debe existir al menos una afectacion");
	           else{
		Map<String, Integer> totalPorAfectacion = new HashMap<>();

		totalPorAfectacion.put("AfectacionPared", 0);
		totalPorAfectacion.put("AfectacionTecho", 0);

		for (OficinaTramites o : micons.getOficinaTramites()) 
			for (FichaTecnicaDO f : o.getFichas())	    
				for (Afectacion a : f.getAfectaciones()){
					String tipo = a.getClass().getSimpleName();
					int cantidad = totalPorAfectacion.getOrDefault(tipo, 0);
					totalPorAfectacion.put(tipo, cantidad + 1);  
				}				
	    }
		return totalPorAfectacion;
	}

	//4.........................................

	public ArrayList<Cubicacion> mostrarMaterialMasCaro(){
	  if(oficinas==null || oficinas.isEmpty())
	     throw new IllegalArgumentException("Debe existir al menos una oficina de tramites");
	     else{
		double costoM=0;			
		double auxCostoM;
		ArrayList<Cubicacion> cubicaciones = new ArrayList<Cubicacion>();
		ArrayList<Cubicacion> auxCubicaciones = new ArrayList<Cubicacion>();

		for (OficinaTramites o : oficinas) {
			auxCubicaciones = o.buscarCubicacionesMayorCosto();

			if (!auxCubicaciones.isEmpty()) {
				auxCostoM = auxCubicaciones.get(0).calcularPrecioTotal();

				if (auxCostoM > costoM) {
					costoM = auxCostoM;
					cubicaciones.clear();
					cubicaciones.addAll(auxCubicaciones); 
				} else if (auxCostoM == costoM) {
					cubicaciones.addAll(auxCubicaciones);
				}
			}
		}
	 }
		return cubicaciones;
	}


	//-------------------------------------Inicializar Datos-----------------------------------------------------
	//----------Oficinas de Tramites
	public void inicializarOficinaTramites(){
		oficinas.add(new OficinaTramites("Arroyo Naranjo"));	
		oficinas.add(new OficinaTramites("Boyeros"));	
		oficinas.add(new OficinaTramites("Vedado"));	
		oficinas.add(new OficinaTramites("Diez de Octubre"));	
		oficinas.add(new OficinaTramites("Cotorro"));	
		oficinas.add(new OficinaTramites("Cerro"));	
		oficinas.add(new OficinaTramites("La Lisa"));
	}
	public void inicializarPlantillaArroyoNaranjo(){
		oficinas.get(0).inicializarFichasTecnicas();
		oficinas.get(0).inicializarPlantillas();

	}
	public void inicializarViviendas(){
		viviendas.add(new Vivienda("Paco","05012045762","Calle J entre L y K","Propiedad","Casa","Tipo II",true,4,5,2,2,3,1,6));
		viviendas.add(new Vivienda("Luis","05011045061","Calle 20 entre 23 y 21","Propiedad","Casa","Tipo I",false,4,5,2,2,1,1,5));
		viviendas.add(new Vivienda("Ernesto","03061545181","Calle Fernanda entre C y B","Usufructo","Apartamento","Tipo III",true,4,4,3,1,0,1,3));
		viviendas.add(new Vivienda("Diana","02092317632","Calle A entre D y C","Arrendamiento","Otro","Tipo IV",false,4,5,3,3,0,0,8));
		viviendas.add(new Vivienda("Ana","01120564637","Calle Balear entre Piedra y Soto","Providencia","Bohio","Tipo V",false,4,7,2,2,0,1,7));		
		viviendas.add(new Vivienda("Pedro P�rez", "04012166621","Calle 12 123", "Propiedad", "Casa", "Tipo II", true, 7, 6, 3, 1, 1, 0,3));
		viviendas.add(new Vivienda( "Carlos D�az", "90031212345","Calle Mart� 89", "Usufructo", "Casa", "Tipo I",false, 7.5, 4.5, 3, 1, 0, 1,5));
		viviendas.add(new Vivienda( "Luisa G�mez", "88020312345", "Ave 51 456","Arrendamiento", "Apartamento", "Tipo III",false, 8.0,4, 3, 0, 2, 0, 4));
		for(Vivienda v: viviendas)
			MICONS.getMICONS().getListaViviendaAsignada().put(v, false);
	}

}



