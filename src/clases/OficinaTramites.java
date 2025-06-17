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
			if(consejoPopular.matches("[a-zA-Z��1234567890 ]+"))
				this.consejoPopular=consejoPopular.trim().replaceAll("\\s+", " ");		
			else throw new IllegalArgumentException("El nombre del Consejo Popular no puede contiene números o caracteres no válidos.");
		else throw new IllegalArgumentException("El nombre del Consejo Popular no puede estar vacío.");
	}
	public String getConsejoPopular(){
		return consejoPopular;		
	}	

	//CRUD-FichaTecnicaDO
	//Create
	public FichaTecnicaDO createFichaTecnicaDO(Vivienda vivienda, String fechaLevantamiento){
		FichaTecnicaDO newFicha= new FichaTecnicaDO(vivienda,fechaLevantamiento); 
		return newFicha;

	}
	public void addFichaTecnicaDO(FichaTecnicaDO ficha){
		fichas.add(ficha);	
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

	//CRUD-Cubicacion
	//Create
	public Cubicacion createCubicacion(){
		Cubicacion cubicacion = new Cubicacion();
		return cubicacion;	
	}
	public void addCubicacion(Cubicacion cubicacion){
		cubicaciones.add(cubicacion);	
	}
	//Read
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
	//Delete

	//CRUD-Material
	//Create
	public void addMaterial(Material material){
		materiales.add(material);			
	}
	public Material createMaterial(String nombre, String unidadMedida, double precioUnitario){
		Material material = new Material(nombre, unidadMedida, precioUnitario);
		return material;
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

	//CRUD-Plantilla
	//Create
	public void addPlantilla(Plantilla plantilla){
		plantillas.add(plantilla);			
	}
	public Plantilla createPlantilla(Cubicacion cubicacion, FichaTecnicaDO ficha){
		Plantilla plantilla = new Plantilla(cubicacion, ficha);
		return plantilla;	
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
		boolean encontrado=false;
		for(int i=0;i<plantillas.size() && !encontrado; i++)
			if(plantillas.get(i).getId()==id){
				plantillas.get(i).setCubicacion(cubicacion);
				plantillas.get(i).setFichaTecnicaDO(ficha);		
				encontrado=true;
			}

	}	
	//Delete

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


	//Métodos

	public ArrayList<Cubicacion> buscarCubicacioneslMayorCosto(){
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

public void cargarMateriales(String txtMateriales){
	try {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(txtMateriales), "UTF-8"));
		String linea;

		while ((linea = reader.readLine()) != null) {
			String[] datos = linea.split(",");

			if (datos.length == 3) {
				
				String nombre = datos[0].trim();	
				String unidadMedida = datos[1].trim();
				int precio = Integer.parseInt(datos[2].trim());
				String ci = datos[3].trim();
				String cargo = datos[4].trim(); //.substring(1));
				Material material = new Material(nombre, unidadMedida, precio);
				materiales.add(material);
			}
		}

		reader.close();
	} catch (IOException e) {
		System.out.println("Error al leer el archivo: " + e.getMessage());
	}
}

}






