package clases;

import java.util.ArrayList;
import java.util.UUID;

public class Cubicacion  {

	//Atributos	
	private ArrayList<MaterialACubicar> materiales;
	private UUID id;

	//Constructor
	public Cubicacion(){
		materiales = new ArrayList<MaterialACubicar>();
		setId();
	}

	//Encapsulamiento
	public UUID getId() {
		return id;
	}
	public void setId() {
		id=UUID.randomUUID();
	}
	
	public void setMateriales(ArrayList<MaterialACubicar> materiales){
		this.materiales=materiales;
	}		
	public ArrayList<MaterialACubicar> getMateriales(){
		return materiales;
	}		

	//CRUD-MaterialACubicar ARREGLAR
	//Create	

	public MaterialACubicar createMaterialACubicar(Material material, double cantidad){
		return new MaterialACubicar(material, cantidad);

	}

	public void addMaterialACubicar(MaterialACubicar material){
		if(!materiales.contains(material))
			materiales.add(material);
		else
			throw new IllegalArgumentException("Este material ya fue cubicado");
	}

	//Read
	public MaterialACubicar searchMaterialACubicar(UUID id){
		boolean encontrado=false;
		MaterialACubicar auxMaterial= null;
		for(int i=0; i<materiales.size() && !encontrado; i++)
			if(materiales.get(i).getId()==id){
				auxMaterial=materiales.get(i);
				encontrado=true;
			}					
		return auxMaterial; 			
	}
	//Update
	public void updateMaterialACubicar(UUID id, Material material, double cantidad){
		boolean encontrado=false;

		for (int i=0;i<materiales.size() && !encontrado; i++)
			if(materiales.get(i).getId()==id){
				materiales.get(i).setMaterial(material);
				materiales.get(i).setCantidad(cantidad);
				encontrado=true;
			}
	}	
	//Delete
	public void deleteMaterialACubicar(UUID id){
		boolean encontrado=false;
		for (int i=0;i<materiales.size() && !encontrado; i++)
			if(materiales.get(i).getId()==id){
				materiales.remove(i);		
				encontrado=true;
			}
	}
	//Métodos

	public double calcularPrecioTotal(){
		double precioTotal=0;
		for(MaterialACubicar m: materiales){
			precioTotal+=m.calcularPrecioTotal();
		}
		return precioTotal;
	}

	//Metodos para cargar los datos desde el .txt




	//----------------------------------------------------------------------

	public void inicializarDatos(){




	}



	//----------------------------------------------------------------------


}


