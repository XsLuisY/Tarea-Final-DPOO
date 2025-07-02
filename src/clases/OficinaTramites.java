package clases;


import interfaces.Identificable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class OficinaTramites{

	//Atributos
	private String consejoPopular;
	private ArrayList<Plantilla> plantillas;
	private ArrayList<Material> materiales;
	private HashMap<FichaTecnicaDO, Cubicacion> dictamenes;	

	//Constructor
	public OficinaTramites(String consejoPopular){
		setConsejoPopular(consejoPopular);	
		dictamenes = new HashMap<FichaTecnicaDO, Cubicacion>();
		materiales = new ArrayList<Material>();
		plantillas = new ArrayList<Plantilla>();
	}	

	//Encapsulamiento
	public void setConsejoPopular(String consejoPopular){
		if(consejoPopular!=null && !consejoPopular.trim().isEmpty())
			if(consejoPopular.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+"))
				this.consejoPopular=consejoPopular.trim().replaceAll("\\s+", " ");		
			else throw new IllegalArgumentException("El nombre del Consejo Popular no puede contener numeros o caracteres no validos.");
		else throw new NullPointerException("El nombre del Consejo Popular no puede estar vacio.");
	}
	public String getConsejoPopular(){
		return consejoPopular;		
	}	
	public HashMap<FichaTecnicaDO, Cubicacion>  getDictamenes(){
		return dictamenes;
	}
	public ArrayList<FichaTecnicaDO> getFichas(){
		return new ArrayList<FichaTecnicaDO>(dictamenes.keySet());
	}
	public ArrayList<Cubicacion> getCubicaciones(){
		return new ArrayList<Cubicacion>(dictamenes.values());
	}
	public ArrayList<Material> getMateriales(){
		return materiales;
	}
	public ArrayList<Plantilla> getPlantillas(){
		return plantillas;
	}

	//CRUD-FichaTecnicaDO
	/*Create*/ public Boolean addFichaTecnicaDO(Vivienda vivienda, ArrayList<Afectacion> afectaciones, ArrayList<Mueble> muebles){
		Boolean add=false;

		if(!MICONS.getMICONS().getListaViviendaAsignada().get(vivienda)){
			dictamenes.put(new FichaTecnicaDO(vivienda, afectaciones, muebles), null); 			
			MICONS.getMICONS().getListaViviendaAsignada().put(vivienda, true);
			add=true;
		} else throw new IllegalArgumentException("Esta vivienda ya tiene una Ficha Tecnica de Daños Ocacionados asociada");

		return add;
	}
	/*Read*/ public FichaTecnicaDO readFichaTecnicaDO(UUID id){	
		Identificable ficha=MICONS.getMICONS().getListaId().get(id);

		if(!(ficha instanceof FichaTecnicaDO))
			throw new ClassCastException("Este ID ("+id.toString()+") no está asignado a una Ficha Tecnica de Daños Ocacionados.");

		return (FichaTecnicaDO) ficha; 			
	}
	/*Update*/ public Boolean updateFichaTecnicaDO(UUID id, Vivienda vivienda){
		//TODO Validar si la vivienda ya está asignada
		Boolean updt=false;
		FichaTecnicaDO ficha = readFichaTecnicaDO(id);

		if(!MICONS.getMICONS().getListaViviendaAsignada().get(vivienda) || ficha.getVivienda().equals(vivienda)){
			MICONS.getMICONS().getListaViviendaAsignada().put(ficha.getVivienda(), false);
			ficha.setVivienda(vivienda);

			updt=true;
		}
		else throw new IllegalArgumentException("Esta vivienda ya tiene una Ficha Tecnica de Daños Ocacionados asignada");		
		return updt;
	}	
	/*Delete*/ public void deleteFichaTecnicaDO(UUID id){
		FichaTecnicaDO ficha=readFichaTecnicaDO(id);
		if(!existPlantilla(ficha)){
			MICONS.getMICONS().getListaViviendaAsignada().put(ficha.getVivienda(), false);	
			MICONS.getMICONS().getListaId().remove(id);
			dictamenes.remove(ficha);
		}
		else
			throw new IllegalArgumentException("Esta FTDO esta asociada a una plantilla, debes desvincular ambos dictamenes antes de continuar.");
	}

	//CRUD-Cubicacion
	//TODO Cambiar UML
	/*Create*/ public Boolean addCubicacion(FichaTecnicaDO ficha){
		Boolean add=false;		
		if(ficha!=null){
			dictamenes.put(ficha, new Cubicacion(generarCubicacion(ficha)));	
			MICONS.getMICONS().getListaId().put(dictamenes.get(ficha).getId(), dictamenes.get(ficha));
			add=true;
		}
		else throw new NullPointerException("La Ficha Tecnica de Daños Ocacionados esta vacia.");

		return add;
	}
	/*Read*/ public Cubicacion readCubicacion(UUID id){
		Identificable cubicacion=MICONS.getMICONS().getListaId().get(id);

		if(!(cubicacion instanceof Cubicacion))
			throw new ClassCastException("Este ID ("+id.toString()+") no está asignado a ninguna Cubicacion.");

		return (Cubicacion) cubicacion; 			
	}
	/*Update*/ public Boolean updateCubicacion(FichaTecnicaDO ficha) {				
		Boolean updt=false;
		Cubicacion cubicacion = dictamenes.get(ficha);
		if(cubicacion!=null) {
			cubicacion.setMateriales(generarCubicacion(ficha));
			updt=true;
		}
		else throw new NullPointerException("La cubicacion no puede ser null");

		return updt;
	}
	/*Delete*/ public void deleteCubicacion(FichaTecnicaDO ficha){
		Cubicacion cubicacion=readCubicacion(dictamenes.get(ficha).getId());
		if(!existPlantilla(ficha)){
			dictamenes.put(ficha, null);		
			MICONS.getMICONS().getListaId().remove(cubicacion.getId());
		}
		else 
			throw new IllegalArgumentException("Esta cubicacion esta asociada a una plantilla, debes desvincular ambos dictamenes antes de continuar.");
	}

	//CRUD-Material
	/*Create*/ public Boolean addMaterial(String nombre, String unidadMedida, Double precioUnitario){
		Boolean add=false;
		Material material = new Material(nombre, unidadMedida, precioUnitario);

		if(!existMaterial(nombre, unidadMedida, precioUnitario)){
			materiales.add(material);	
			add=true;
		}
		else throw new IllegalArgumentException("Este Material ya existe");
		return add;
	}
	/*Read*/ public Material readMaterial(UUID id){
		Identificable material=MICONS.getMICONS().getListaId().get(id);
		if(!(material instanceof Material))
			throw new ClassCastException("Este ID ("+id.toString()+") no está asignado a ningun material.");
		return (Material) material; 	

	}
	/*Update*/ public Boolean updateMaterial(UUID id, String nombre, String unidadMedida, Double precioUnitario){
		Boolean updt=false;
		Material m = readMaterial(id);
		if(m!=null)
			if(!existMaterial(nombre, unidadMedida, precioUnitario)){
				m.setNombre(nombre);
				m.setPrecioUnitario(precioUnitario);
				m.setUnidadMedida(unidadMedida);	
				updt=true;
			}else throw new IllegalArgumentException("Este material ya existe");
		else throw new IllegalArgumentException("Este material no existe");
		return updt;
	}	
	/*Delete*/ public void deleteMaterial(UUID id){
		Material m = readMaterial(id);
		if(m!=null)	
			if(!containsMaterial(m)){
				MICONS.getMICONS().getListaId().remove(id);
				materiales.remove(readMaterial(id));
			}
			else throw new IllegalArgumentException("Este material esta asociado a una cubicacion, debes desvincularlo de la misma antes de eliminarlo.");
		else throw new IllegalArgumentException("Este Material no existe");
	}
	public Boolean existMaterial(String nombre, String unidadMedida, Double precioUnitario){
		Boolean exist=false;
		for(int i=0; i<materiales.size()&& !exist; i++){	
			Material m= materiales.get(i);

			if(m.getNombre().equals(nombre)
					&& m.getUnidadMedida().equals(unidadMedida)
					&& m.getPrecioUnitario().equals(precioUnitario))
				exist=true;
		}
		return exist;
	}
	public Boolean containsMaterial(Material m){
		Boolean contains=false;

		if(m!=null){
			for(int i=0; i<getCubicaciones().size() && !contains; i++)
				for(int j=0; j<getCubicaciones().get(i).getMateriales().size() && !contains; j++)
					if(getCubicaciones().get(i).getMateriales().get(j).getMaterial().equals(m))
						contains=true;
		}else throw new NullPointerException("El material no puede ser null.");
		return contains;
	}

	//CRUD-Plantilla
	/*Create*/ public Boolean addPlantilla(Cubicacion cubicacion, FichaTecnicaDO ficha){
		Boolean add=false;

		if(!existPlantilla(ficha)){
			Plantilla plantilla = new Plantilla(cubicacion, ficha);
			plantillas.add(plantilla);	
			add=true;
		}
		else throw new IllegalArgumentException("Esta Plantilla ya existe");
		return add;
	}
	/*Read*/ public Plantilla readPlantilla(UUID id){
		Identificable plantilla=MICONS.getMICONS().getListaId().get(id);
		if(!(plantilla instanceof Plantilla))
			throw new ClassCastException("Este ID ("+id.toString()+") no está asignado a una Plantilla.");
		return (Plantilla) plantilla; 	

	}
	/*Update*/ public Boolean updatePlantilla(UUID id, FichaTecnicaDO ficha){
		Boolean updt=false;
		Plantilla plantilla = readPlantilla(id); 
		if(plantilla!=null){
			plantilla.setFichaTecnicaDO(ficha);		
			plantilla.setCubicacion(dictamenes.get(ficha));
			updt=true;
		}else throw new IllegalArgumentException("Esta plantilla no existe");
		return updt;
	}		
	/*Delete*/ public void deletePlantilla(UUID id){
		Plantilla plantilla = readPlantilla(id); 
		dictamenes.remove(plantilla.getFichaTecnicaDO());
		plantillas.remove(plantilla);
		MICONS.getMICONS().getListaId().remove(id);
	}

	public Boolean existPlantilla(FichaTecnicaDO ficha){
		Boolean exist=false;
		for(int i=0; i<plantillas.size()&& !exist; i++){	
			Plantilla p= plantillas.get(i);
			if(p.getFichaTecnicaDO().equals(ficha))
				exist=true;
		}
		return exist;
	}


	//Metodos

	public ArrayList<MaterialACubicar> generarCubicacion(FichaTecnicaDO ficha){
		ArrayList<MaterialACubicar> materialesACubicar = new ArrayList<>();

		if (ficha != null && ficha.getAfectaciones() != null) {
			for (Afectacion afectacion : ficha.getAfectaciones()) {
				String nombreMaterial = afectacion.getMaterialPredominante();
				Material material = null;
				//Revisar				
				boolean exist=false;		            
				for (int i=0;i<getMateriales().size() && !exist ;i++) {
					Material m= getMateriales().get(i);
					if (m.getNombre().trim().equalsIgnoreCase(nombreMaterial.trim())){
						material = m;
						exist=true;
					}
				}

				if (material != null) {
					double cantidad = estimarCantidad(afectacion, ficha.getVivienda());		              

					MaterialACubicar materialACubicar = new MaterialACubicar(material,cantidad);
					materialesACubicar.add(materialACubicar);
				}
			}
		}

		return materialesACubicar;	}

	private Double estimarCantidad(Afectacion a, Vivienda vivienda){
		double area = vivienda.getLargo() * vivienda.getAncho();
		double cantidad = 1.0;

		//TODO: Arreglar asignacion 
		if (a instanceof AfectacionTecho)   // Aproximación de techo 
			cantidad = Math.ceil(area / 2); 
		else
			cantidad = Math.ceil((area * 2.5) / 10); // Aproximación de pared

		return cantidad;
	}

	public ArrayList<Cubicacion> buscarCubicacionesMayorCosto(){
		double aux=0;

		ArrayList<Cubicacion> mayores = new ArrayList<Cubicacion>();		

		for(Cubicacion c : getCubicaciones()){
			if(aux<c.calcularPrecioTotal()){
				aux=c.calcularPrecioTotal();
				mayores.clear();
			}

			if(aux==c.calcularPrecioTotal())
				mayores.add(c);
		}
		return mayores;
	}


	//------------------------------Inicializar Datos-------------------------------------
	//Inicializar materiales
	public void inicializarMateriales(){
		materiales.add(new Material("Cemento","Saco", 360));
		materiales.add(new Material("Cabilla","Metro", 460));
		materiales.add(new Material("Bloque","Unidad", 120));
		materiales.add(new Material("Arena","Saco", 500));
		materiales.add(new Material("Polvo de piedra","Saco", 420));
		materiales.add(new Material("Grava","Saco", 200));		
	}
	public void inicializarFichasTecnicas(){		

		ArrayList<Afectacion> afectaciones1 = new ArrayList<>();
		ArrayList<Mueble> muebles1 = new ArrayList<>();
		Vivienda vivienda1 = MICONS.getMICONS().readVivienda("04012166621");
		//TODO Revisar esto
		MICONS.getMICONS().getListaViviendaAsignada().put(vivienda1, false);
		afectaciones1.add(new AfectacionTecho(true, "Cemento"));
		muebles1.add(new Mueble("Fregadero", 2));
		addFichaTecnicaDO(vivienda1, afectaciones1, muebles1);



		ArrayList<Afectacion> afectaciones2 = new ArrayList<>();
		ArrayList<Mueble> muebles2 = new ArrayList<>();
		Vivienda vivienda2 = MICONS.getMICONS().readVivienda("88020312345");
		afectaciones2.add(new AfectacionPared(false, "Bloque", true));
		MICONS.getMICONS().getListaViviendaAsignada().put(vivienda2, false);
		muebles2.add(new Mueble("Puerta", 1));
		addFichaTecnicaDO(vivienda2, afectaciones2, muebles2);

		ArrayList<Afectacion> afectaciones3 = new ArrayList<>();
		ArrayList<Mueble> muebles3 = new ArrayList<>();
		Vivienda vivienda3 = MICONS.getMICONS().readVivienda("90031212345");
		afectaciones3.add(new AfectacionPared(true, "Bloque", true));
		MICONS.getMICONS().getListaViviendaAsignada().put(vivienda3, false);
		muebles3.add(new Mueble("Ventana", 3));
		addFichaTecnicaDO(vivienda3, afectaciones3, muebles3);

		for(FichaTecnicaDO f: getFichas())
			MICONS.getMICONS().getListaId().put(f.getId(), f);
	}

	public void inicializarPlantillas(){
		for(int i=0; i<getFichas().size();i++){
			FichaTecnicaDO f=getFichas().get(i);
			addCubicacion(f);
			Cubicacion c= dictamenes.get(f);
			addPlantilla(c, f);
		}				

	}

}