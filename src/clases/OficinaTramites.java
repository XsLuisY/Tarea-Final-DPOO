package clases;


import java.util.ArrayList;
import java.util.UUID;

public class OficinaTramites{

	//Atributos
	private String consejoPopular;
	private ArrayList<Plantilla> plantillas;
	private ArrayList<Material> materiales;
	private ArrayList<Cubicacion> cubicaciones;
	private ArrayList<FichaTecnicaDO> fichas;

	//Constructor
	public OficinaTramites(String consejoPopular){
		setConsejoPopular(consejoPopular);
		fichas = new ArrayList<FichaTecnicaDO>();	
		cubicaciones = new ArrayList<Cubicacion>();
		materiales = new ArrayList<Material>();
		plantillas = new ArrayList<Plantilla>();
	}	

	//Encapsulamiento
	public void setConsejoPopular(String consejoPopular){
		if(consejoPopular!=null && !consejoPopular.trim().isEmpty())
			if(consejoPopular.matches("[a-zA-Z·ÈÌÛ˙¡…Õ”⁄Ò— ]+"))
				this.consejoPopular=consejoPopular.trim().replaceAll("\\s+", " ");		
			else throw new IllegalArgumentException("El nombre del Consejo Popular no puede contener numeros o caracteres no validos.");
		else throw new NullPointerException("El nombre del Consejo Popular no puede estar vacio.");
	}
	public String getConsejoPopular(){
		return consejoPopular;		
	}	
	public ArrayList<FichaTecnicaDO> getFichas(){
		return fichas;
	}
	public ArrayList<Cubicacion> getCubicaciones(){
		return cubicaciones;
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

		if(!existFichaTecnicaDO(vivienda)){
			FichaTecnicaDO ficha = new FichaTecnicaDO(vivienda, afectaciones, muebles);
			fichas.add(ficha);
			add=true;
		}	
		else throw new IllegalArgumentException("Esta vivienda ya tiene una Ficha Tecnica de DaÒos Ocacionados asociada");
		return add;
	}
	/*Read*/ public FichaTecnicaDO readFichaTecnicaDO(UUID id){	
		boolean found=false;
		FichaTecnicaDO ficha= null;

		for(int i=0; i<fichas.size() && !found; i++)
			if(fichas.get(i).getId().equals(id)){
				ficha=fichas.get(i);
				found=true;
			}					
		return ficha; 			
	}
	/*Update*/ public Boolean updateFichaTecnicaDO(UUID id, Vivienda vivienda){
		Boolean updt=false;

		if(existFichaTecnicaDO(id))
			if(vivienda!=null) {
				FichaTecnicaDO f = readFichaTecnicaDO(id);
				f.setVivienda(vivienda);
				updt=true;
			}else throw new NullPointerException("La nueva vivienda no puede ser null.");
		else throw new IllegalArgumentException("Esta FichaTecnicaDO no existe");
		return updt;

	}	
	/*Delete*/ public Boolean deleteFichaTecnicaDO(UUID id){
		Boolean del=existFichaTecnicaDO(id);

		if(del)			
			fichas.remove(readFichaTecnicaDO(id));
		else throw new IllegalArgumentException("Esta FichaTecnicaDO no existe");

		return del;
	}
	public Boolean existFichaTecnicaDO(UUID id){
		Boolean exist=false;
		for(int i=0; i<fichas.size()&& !exist; i++){
			FichaTecnicaDO f = fichas.get(i);
			if(f.getId().equals(id))
				exist=true;
		}
		return exist;
	}
	public Boolean existFichaTecnicaDO(Vivienda vivienda){
		Boolean exist=false;
		if(vivienda!=null)
			for(int i=0; i<getFichas().size()&& !exist; i++){
				FichaTecnicaDO f = getFichas().get(i);
				if(f.getVivienda().equals(vivienda))
					exist=true;
			}
		else 
			throw new NullPointerException("La vivienda es null");
		if(exist)
			throw new IllegalArgumentException("La vivienda ya tiene una Ficha TÈcnica de DaÒos Ocasionados asignada");
		return exist;
	}

	//CRUD-Cubicacion
	/*Create*/ public Boolean addCubicacion(ArrayList<MaterialACubicar> materiales){
		Boolean add=false;
		if(!existCubicacion(materiales)){
			Cubicacion cubicacion = new Cubicacion(materiales);
			cubicaciones.add(cubicacion);	
			add=true;
		}
		else throw new IllegalArgumentException("Esta cubicacion ya existe");

	return add;
}
/*Read*/ public Cubicacion readCubicacion(UUID id){
	boolean found=false;
	Cubicacion cubicacion= null;
	for(int i=0; i<cubicaciones.size() && !found; i++)
		if(cubicaciones.get(i).getId().equals(id)){
			cubicacion=cubicaciones.get(i);
			found=true;
		}					
	return cubicacion; 			
}
/*Update*/ public Boolean updateCubicacion(UUID id, ArrayList<MaterialACubicar> materiales) {		
	Boolean updt=false;

	if(existCubicacion(id))
		if(materiales!=null) {
			Cubicacion c = readCubicacion(id);
			c.setMateriales(materiales);
			updt=true;
		}else throw new NullPointerException("La nueva lista no puede ser null.");
	else throw new IllegalArgumentException("Esta Cubicacion no existe");
	return updt;
}
/*Delete*/ public Boolean deleteCubicacion(UUID id){
	Boolean del=existCubicacion(id);

	if(del)			
		cubicaciones.remove(readCubicacion(id));
	else throw new IllegalArgumentException("Esta Cubicacion no existe");

	return del;
}
public Boolean existCubicacion(UUID id){
	Boolean exist=false;
	for(int i=0; i<cubicaciones.size()&& !exist; i++)
		if(cubicaciones.get(i).getId().equals(id))
			exist=true;
	return exist;
}
public Boolean existCubicacion(ArrayList<MaterialACubicar> materiales){
	Boolean exist=false;
	for(int i=0; i<cubicaciones.size()&& !exist; i++)
		if(cubicaciones.get(i).getMateriales()==materiales)
			exist=true;
	return exist;
}

//CRUD-Material
/*Create*/ public Boolean addMaterial(String nombre, String unidadMedida, Double precioUnitario){
	Boolean add=false;

	if(!existMaterial(nombre, unidadMedida, precioUnitario)){
		Material material = new Material(nombre, unidadMedida, precioUnitario);
		materiales.add(material);	
		add=true;
	}
	else throw new IllegalArgumentException("Este Material ya existe");
	return add;
}
/*Read*/ public Material readMaterial(UUID id){
	boolean found=false;
	Material material= null;
	for(int i=0; i<materiales.size() && !found; i++)
		if(materiales.get(i).getId().equals(id)){
			material=materiales.get(i);
			found=true;
		}					
	return material; 				
}
/*Update*/ public Boolean updateMaterial(UUID id, String nombre, String unidadMedida, Double precioUnitario){
	Boolean updt=false;

	if(existMaterial(id)){
		Material m = readMaterial(id);
		m.setNombre(nombre);
		m.setPrecioUnitario(precioUnitario);
		m.setUnidadMedida(unidadMedida);	
		updt=true;
	}else throw new IllegalArgumentException("Este Material no existe");
	return updt;
}	
/*Delete*/ public Boolean deleteMaterial(UUID id){
	Boolean del=existMaterial(id);

	if(del)			
		materiales.remove(readMaterial(id));
	else throw new IllegalArgumentException("Este Material no existe");

	return del;
}
public Boolean existMaterial(UUID id){
	Boolean exist=false;
	for(int i=0; i<materiales.size()&& !exist; i++){		
		if(materiales.get(i).getId().equals(id))
			exist=true;
	}
	return exist;
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

//CRUD-Plantilla
/*Create*/ public Boolean addPlantilla(Cubicacion cubicacion, FichaTecnicaDO ficha){
	Boolean add=false;

	if(!existPlantilla(cubicacion, ficha)){
		Plantilla plantilla = new Plantilla(cubicacion, ficha);
		plantillas.add(plantilla);	
		add=true;
	}
	else throw new IllegalArgumentException("Esta Plantilla ya existe");
	return add;
}
/*Read*/ public Plantilla readPlantilla(UUID id){
	boolean found=false;
	Plantilla plantilla= null;
	for(int i=0; i<plantillas.size() && !found; i++)
		if(plantillas.get(i).getId().equals(id)){
			plantilla=plantillas.get(i);
			found=true;
		}					
	return plantilla; 			
}
/*Update*/ public Boolean updatePlantilla(UUID id, Cubicacion cubicacion, FichaTecnicaDO ficha){
	Boolean updt=false;

	if(existPlantilla(id)){
		Plantilla p = readPlantilla(id);
		p.setCubicacion(cubicacion);
		p.setFichaTecnicaDO(ficha);		
		updt=true;
	}else throw new IllegalArgumentException("Este Material no existe");
	return updt;
}		
/*Delete*/ public Boolean deletePlantilla(UUID id){
	Boolean del=existMaterial(id);

	if(del)			
		plantillas.remove(readPlantilla(id));
	else throw new IllegalArgumentException("Esta Plantilla no existe");

	return del;
}
public Boolean existPlantilla(UUID id){
	Boolean exist=false;
	for(int i=0; i<plantillas.size()&& !exist; i++){		
		if(plantillas.get(i).getId().equals(id))
			exist=true;
	}
	return exist;
}
public Boolean existPlantilla(Cubicacion cubicacion, FichaTecnicaDO ficha){
	Boolean exist=false;
	for(int i=0; i<plantillas.size()&& !exist; i++){	
		Plantilla p= plantillas.get(i);
		if(p.getCubicacion().equals(cubicacion) && p.getFichaTecnicaDO().equals(ficha))
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
				if (m.getNombre().equalsIgnoreCase(nombreMaterial)) {
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
	if (a instanceof AfectacionTecho)   // AproximaciÛn de techo 
		cantidad = Math.ceil(area / 2); 
	else
		cantidad = Math.ceil((area * 2.5) / 10); // AproximaciÛn de pared

	return cantidad;
}

public ArrayList<Cubicacion> buscarCubicacionesMayorCosto(){
	double aux=0;

	ArrayList<Cubicacion> mayores = new ArrayList<Cubicacion>();		

	for(Cubicacion c : cubicaciones){
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
	Vivienda vivienda1 = new Vivienda("Pedro PÈrez", "04012166621","Calle 12 123", "Propiedad", "Casa", "Tipo II", true, 7, 6, 3, 1, 1, 0,3);
	afectaciones1.add(new AfectacionTecho(true, "Cemento"));
	muebles1.add(new Mueble("Fregadero", 2));
	addFichaTecnicaDO(vivienda1, afectaciones1, muebles1);



	ArrayList<Afectacion> afectaciones2 = new ArrayList<>();
	ArrayList<Mueble> muebles2 = new ArrayList<>();
	Vivienda vivienda2 = new Vivienda( "Luisa GÛmez","88020312345","Ave 51","Arrendamiento", "Apartamento", "Tipo III",false,8.0,4, 3, 0, 2, 0, 4);
	afectaciones2.add(new AfectacionPared(false, "Bloque", true));
	muebles2.add(new Mueble("Puerta", 1));
	addFichaTecnicaDO(vivienda2, afectaciones2, muebles2);

	ArrayList<Afectacion> afectaciones3 = new ArrayList<>();
	ArrayList<Mueble> muebles3 = new ArrayList<>();
	Vivienda vivienda3 = new Vivienda( "Carlos DÌaz", "90031212345","Calle MartÌ", "Usufructo", "Casa", "Tipo I",false, 7.5, 4.5, 3, 1, 0, 1,5);
	afectaciones3.add(new AfectacionPared(true, "Bloque", true));
	muebles3.add(new Mueble("Ventana", 3));
	addFichaTecnicaDO(vivienda3, afectaciones3, muebles3);
}

public void inicializarPlantillas(){
	for(int i=0; i<getFichas().size();i++){
		FichaTecnicaDO f=getFichas().get(i);
		ArrayList<MaterialACubicar> m=generarCubicacion(f);
		addCubicacion(m);
		Cubicacion c= new Cubicacion(m);
		addPlantilla(c, f);
	}				

}

}