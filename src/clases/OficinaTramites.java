package clases;

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
	public OficinaTramites(UUID id, String consejoPopular){
		this.id= UUID.randomUUID();
		setConsejoPopular(consejoPopular);
		fichas = new ArrayList<FichaTecnicaDO>();	
		cubicaciones = new ArrayList<Cubicacion>();
		materiales = new ArrayList<Material>();
		plantillas = new ArrayList<Plantilla>();
	}	


	//Create	
		public FichaTecnicaDO createFichaTecnicaDO(Vivienda vivienda, String fechaLevantamiento){
			FichaTecnicaDO newFicha= new FichaTecnicaDO(vivienda,fechaLevantamiento); 
			return newFicha;
		}
		public Cubicacion createCubicacion(){
			Cubicacion cubicacion = new Cubicacion();
			return cubicacion;	
		}
		public Material createMaterial(String nombre, String unidadMedida, double precioUnitario){
			Material material = new Material(nombre, unidadMedida, precioUnitario);
			return material;	
		}
		public Plantilla createPlantilla(Cubicacion cubicacion, FichaTecnicaDO ficha){
			Plantilla plantilla = new Plantilla(cubicacion, ficha);
			return plantilla;	
		}
		
		//Read
		public FichaTecnicaDO searchFichaTecnicaDO(int id){
			boolean encontrado=false;
			FichaTecnicaDO auxFicha= null;
			for(int i=0; i<fichas.size() && !encontrado; i++)
				if(fichas.get(i).getId()==id){
					auxFicha=fichas.get(i);
					encontrado=true;
				}					
			return auxFicha; 			
		}
		
		public Cubicacion searchCubicacion(int id){
			boolean encontrado=false;
			Cubicacion auxCubicacion= null;
			for(int i=0; i<cubicaciones.size() && !encontrado; i++)
				if(cubicaciones.get(i).getId()==id){
					auxCubicacion=cubicaciones.get(i);
					encontrado=true;
				}					
			return auxCubicacion; 			
		}
		public Material searchMaterial(int id){
			boolean encontrado=false;
			Material auxMaterial= null;
			for(int i=0; i<materiales.size() && !encontrado; i++)
				if(materiales.get(i).getId()==id){
					auxMaterial=materiales.get(i);
					encontrado=true;
				}					
			return auxMaterial; 			
		}
		
		public Plantilla searchPlantilla(int id){
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
		public void updateFichaTecnicaDO(int id, Vivienda vivienda, String fechaLevantamiento){
			fichas.get(id).setVivienda(vivienda);
			fichas.get(id).setFechaLevantamiento(fechaLevantamiento);	
		}	
		
		public void updateMaterial(int id, String nombre, String unidadMedida, double precioUnitario){
			materiales.get(id).setNombre(nombre);
			materiales.get(id).setUnidadMedida(unidadMedida);
			materiales.get(id).setPrecioUnitario(precioUnitario);			
		}	
		
		public void updatePlantilla(int id, Cubicacion cubicacion, FichaTecnicaDO ficha){
			plantillas.get(id).setCubicacion(cubicacion);
			plantillas.get(id).setFichaTecnicaDO(ficha);		
		
		}	
			
		
		//Delete
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
	
	
	
	
	
	
	
	
	
	
	
	
	//Encapsulamiento
	public void setId(UUID id){
		this.id= id;
	}
	public UUID getId(){
		return id;
	}
	public void setConsejoPopular(String consejoPopular){
		this.consejoPopular= consejoPopular;			
	}
	public String getConsejoPopular(){
		return consejoPopular;		
	}	

	//Métodos
	public void addPlantilla(Plantilla plantilla){
		plantillas.add(plantilla);			
	}
	public void addMaterial(Material material){
		materiales.add(material);			
	}
	public void addCubicacion(Cubicacion cubicacion){
		cubicaciones.add(cubicacion);	
	}
	public void addFichaTecnicaDO(FichaTecnicaDO ficha){
		fichas.add(ficha);	
	}

	public Plantilla buscarMaterialMasCaro(){
		Plantilla aux= new Plantilla();

		for(Plantilla p : plantillas)
			if(p.calcularPrecioTotal()>aux.calcularPrecioTotal())
				aux=p;

		return aux;
	}
}




