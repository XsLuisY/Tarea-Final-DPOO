package clases;

import java.util.ArrayList;

public class OficinaTramites{

	//Atributos
	private String id;
	private String consejoPopular;
	private ArrayList<Plantilla> plantillas;
	private ArrayList<Material> materiales;
	private ArrayList<Cubicacion> cubicaciones;
	private ArrayList<FichaTecnicaDO> fichas;

	//Constructor
	public OficinaTramites(String id, String consejoPopular){
		setId(id);
		setConsejoPopular(consejoPopular);
		fichas = new ArrayList<FichaTecnicaDO>();	
		cubicaciones = new ArrayList<Cubicacion>();
		materiales = new ArrayList<Material>();
		plantillas = new ArrayList<Plantilla>();
	}	

	public OficinaTramites() {
		id=null;
		consejoPopular=null;
		fichas = new ArrayList<FichaTecnicaDO>();	
		cubicaciones = new ArrayList<Cubicacion>();
		materiales = new ArrayList<Material>();
		plantillas = new ArrayList<Plantilla>();
	}	


	//Encapsulamiento
	public void setId(String id){
		this.id= id;
	}
	public String getId(){
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




