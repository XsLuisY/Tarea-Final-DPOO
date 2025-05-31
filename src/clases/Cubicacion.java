package clases;

import java.util.ArrayList;

public class Cubicacion  {

	//Atributos	
	private ArrayList<MaterialACubicar> materiales;
	private int id;
	
	//Constructor
	public Cubicacion(){
		materiales = new ArrayList<MaterialACubicar>();
		setId(id);
	}

	//Encapsulamiento

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public ArrayList<MaterialACubicar> getMateriales(){
		return materiales;
	}

	public void setMateriales(ArrayList<MaterialACubicar> materiales){
		this.materiales=materiales;	
	}

	//Create	
	public MaterialACubicar createMaterialACubicar(Material material, double cantidad){
		MaterialACubicar newMaterial= new MaterialACubicar(material, cantidad); 
		return newMaterial;
	}
	
	//Read
	public MaterialACubicar searchMaterialACubicar(int id){
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
	public void updateMaterialACubicar(int id, Material material, double cantidad){
		materiales.get(id).setMaterial(material);
		materiales.get(id).setCantidad(cantidad);
	}	
	
	//Delete
	public void deleteMaterialACubicar(int id){
		materiales.remove(id);
	}

	//Métodos
	public boolean addMaterialACubicar(MaterialACubicar material){
		boolean agregado=false;
		if(material!=null){
			materiales.add(material);
			agregado=true;
		}
		//		else
		//lanzar excepcion
		return agregado;
	}

	public double calcularPrecioTotal(){
		double precioTotal=0;
		for(MaterialACubicar m: materiales){
			precioTotal+=m.calcularPrecioTotal();
		}
		return precioTotal;
	}

	

}
