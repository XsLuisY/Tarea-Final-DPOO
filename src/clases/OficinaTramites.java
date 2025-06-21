package clases;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.UUID;

public class OficinaTramites{

	//Atributos
	private UUID id;
	private String consejoPopular;
	private ArrayList<Plantilla> plantillas;
	private ArrayList<Material> materiales;
	private ArrayList<Cubicacion> cubicaciones;
	private ArrayList<FichaTecnicaDO> fichas;

	//Constructor
	public OficinaTramites(String consejoPopular){
		setId();
		setConsejoPopular(consejoPopular);
		fichas = new ArrayList<FichaTecnicaDO>();	
		cubicaciones = new ArrayList<Cubicacion>();
		materiales = new ArrayList<Material>();
		plantillas = new ArrayList<Plantilla>();
	}	

	//Encapsulamiento
	public void setId(){
		id=UUID.randomUUID();
	}
	public UUID getId(){
		return id;
	}
	public void setConsejoPopular(String consejoPopular){
		if(consejoPopular!=null && !consejoPopular.trim().isEmpty())
			if(consejoPopular.matches("[a-zA-ZÒ—1234567890 ]+"))
				this.consejoPopular=consejoPopular.trim().replaceAll("\\s+", " ");		
			else throw new IllegalArgumentException("El nombre del Consejo Popular no puede contiene n√∫meros o caracteres no v√°lidos.");
		else throw new IllegalArgumentException("El nombre del Consejo Popular no puede estar vac√≠o.");
	}
	public String getConsejoPopular(){
		return consejoPopular;		
	}	
	public ArrayList<Material> getMateriales(){
		return materiales;
	}

	public ArrayList<Plantilla> getPlantillas(){
		return plantillas;
	}
	//CRUD-FichaTecnicaDO
	//Create
	public FichaTecnicaDO createFichaTecnicaDO(Vivienda vivienda, String fechaLevantamiento){
		return new FichaTecnicaDO(vivienda,fechaLevantamiento); 		
	}

	public void addFichaTecnicaDO(FichaTecnicaDO ficha){
		if(!fichas.contains(ficha))
			fichas.add(ficha);	
		else
			throw new IllegalArgumentException("Esta Ficha Tecnica de DaÒos Ocasionados ya existe");
	}

	//Read
	public FichaTecnicaDO searchFichaTecnicaDO(UUID id){
		boolean encontrado=false;
		FichaTecnicaDO auxFicha= null;
		for(int i=0; i<fichas.size() && !encontrado; i++)
			if(fichas.get(i).getId()==id){
				auxFicha=fichas.get(i);
				encontrado=true;
			}					
		return auxFicha; 			
	}
	//Update
	public void updateFichaTecnicaDO(UUID id, Vivienda vivienda, String fechaLevantamiento){
		boolean encontrado=false;
		for(int i=0;i<fichas.size() && !encontrado; i++)
			if(fichas.get(i).getId()==id){
				fichas.get(i).setVivienda(vivienda);
				fichas.get(i).setFechaLevantamiento(fechaLevantamiento);		
				encontrado=true;
			}


	}	
	//Delete
	public void deleteFichaTecnicaDO(FichaTecnicaDO ficha){
		if(fichas.contains(ficha))
			fichas.remove(ficha);
		else
			throw new IllegalArgumentException("Esta Ficha Tecnica de DaÒos Ocasionados no existe");
	}

	//CRUD-Cubicacion
	//Create
	public Cubicacion createCubicacion(){
		return new Cubicacion();
	}
	public void addCubicacion(Cubicacion cubicacion){
		if(!cubicaciones.contains(cubicacion))
			cubicaciones.add(cubicacion);	
		else 
			throw new IllegalArgumentException("Esta cubicacion ya existe");
	}
	//Read
	public Boolean existCubicacion(UUID id){
		Boolean exist=false;
		for(int i=0; i<cubicaciones.size()&& !exist; i++)
			if(cubicaciones.get(i).getId()==id)
				exist=true;
		return exist;
	}
	public Cubicacion searchCubicacion(UUID id){
		boolean encontrado=false;
		Cubicacion auxCubicacion= null;
		for(int i=0; i<cubicaciones.size() && !encontrado; i++)
			if(cubicaciones.get(i).getId()==id){
				auxCubicacion=cubicaciones.get(i);
				encontrado=true;
			}					
		return auxCubicacion; 			
	}
	//Update
	public void updateCubicacion(UUID id, ArrayList<MaterialACubicar> nuevosMateriales) {
		Cubicacion c=searchCubicacion(id);
		if(nuevosMateriales!=null) {
			c.getMateriales().clear();
			c.setMateriales(nuevosMateriales);
		} else {
			throw new IllegalArgumentException("La nueva lista no puede ser null.");
		}
	}
	//Delete
	public void deleteCubicacion(Cubicacion cubicacion){
		if(cubicaciones.contains(cubicacion))
			cubicaciones.remove(cubicacion);
		else
			throw new IllegalArgumentException("Esta cubicacion no existe");

	}

	//CRUD-Material
	//Create
	public void addMaterial(Material material){
		if(!materiales.contains(material))			
			materiales.add(material);
		else 
			throw new IllegalArgumentException("Este material ya existe");		
	}
	public Material createMaterial(String nombre, String unidadMedida, double precioUnitario){
		return new Material(nombre, unidadMedida, precioUnitario);		
	}

	//Read
	public Material searchMaterial(UUID id){
		boolean encontrado=false;
		Material auxMaterial= null;
		for(int i=0; i<materiales.size() && !encontrado; i++)
			if(materiales.get(i).getId()==id){
				auxMaterial=materiales.get(i);
				encontrado=true;
			}					
		return auxMaterial; 			
	}
	//Update
	public void updateMaterial(UUID id, String nombre, String unidadMedida, double precioUnitario){
		boolean encontrado=false;
		for(int i=0;i<materiales.size() && !encontrado; i++)
			if(materiales.get(i).getId()==id){
				materiales.get(i).setNombre(nombre);
				materiales.get(i).setUnidadMedida(unidadMedida);
				materiales.get(i).setPrecioUnitario(precioUnitario);
				encontrado=true;
			}
	}	
	//Delete
	public void deleteMaterial(Material material){
		if(materiales.contains(material))			
			materiales.remove(material);
		else 
			throw new IllegalArgumentException("Este material no existe");
	}

	//CRUD-Plantilla
	//Create
	public void addPlantilla(Plantilla plantilla){
		if(!plantillas.contains(plantilla))
			plantillas.add(plantilla);			
		else 
			throw new IllegalArgumentException("Esta plantilla ya existe");
	}

	public Plantilla createPlantilla(Cubicacion cubicacion, FichaTecnicaDO ficha){
		return new Plantilla(cubicacion, ficha);
	}		
	//Read
	public Plantilla searchPlantilla(UUID id){
		boolean encontrado=false;
		Plantilla auxPlantilla= null;
		for(int i=0; i<plantillas.size() && !encontrado; i++)
			if(plantillas.get(i).getId()==id){
				auxPlantilla=plantillas.get(i);
				encontrado=true;
			}					
		return auxPlantilla; 			
	}
	//Update
	public void updatePlantilla(UUID id, Cubicacion cubicacion, FichaTecnicaDO ficha){
		Plantilla auxPlantilla = searchPlantilla(id);

		if(auxPlantilla!=null){
			auxPlantilla.setCubicacion(cubicacion);
			auxPlantilla.setFichaTecnicaDO(ficha);		
		}
		else
			throw new IllegalArgumentException("La plantilla no existe");
	}	
	//Delete
	public void deletePlantilla(Plantilla plantilla){
		if(plantillas.contains(plantilla))
			plantillas.remove(plantilla);			
		else 
			throw new IllegalArgumentException("Esta plantilla no existe");
	}

	//---------------------------TODO----------------------------------
	//----------------------------FIX----------------------------------
	public void deleteFichaTecnicaDO(int id){
		fichas.remove(id);
	}
	public void deleteCubicacion(int id){
		cubicaciones.remove(id);
	}
	public void deleteMaterial(int id){
		materiales.remove(id);
	}
	public void deletePlantilla(int id){
		plantillas.remove(id);
	}
	//-----------------------------------------------------------------


	//M√©todos

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
	public void inicializarMateriales(String txtMateriales){
		materiales.add(new Material("Cemento","Saco", 360));
		materiales.add(new Material("Cabilla","Metro", 460));
		materiales.add(new Material("Bloque","Unidad", 120));
		materiales.add(new Material("Arena","Saco", 500));
		materiales.add(new Material("Polvo de piedra","Saco", 420));
		materiales.add(new Material("Grava","Saco", 200));		
	}

}