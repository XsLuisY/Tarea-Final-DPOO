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
		do
			id=UUID.randomUUID();
		while(MICONS.existUUID(id));
	}	
	public void setMateriales(ArrayList<MaterialACubicar> materiales){
		this.materiales=materiales;
	}		
	public ArrayList<MaterialACubicar> getMateriales(){
		return materiales;
	}		

	//CRUD-MaterialACubicar ARREGLAR
	/*Create*/ public Boolean addMaterialACubicar(Material material, double cantidad){
		Boolean add=false;

		if(!existMaterialACubicar(material)){
			MaterialACubicar m= new MaterialACubicar(material, cantidad);
			materiales.add(m);	
			add=true;
		}
		else throw new IllegalArgumentException("Este Material ya existe");
		return add;
	}
	/*Read*/ public MaterialACubicar readMaterialACubicar(Material material){	
		//Busca y devuelve el objeto, si no lo encuentra devuelve null
		MaterialACubicar m= null;
		Boolean found=false;
		for(int i=0; i<materiales.size() && !found; i++)
			if(materiales.get(i).getMaterial().equals(material)){
				m = materiales.get(i);
				found=true;
			}					
		return m; 			
	}
	/*Update*/public Boolean updateMaterialACubicar(Material material, double cantidad){
		Boolean updt=!existMaterialACubicar(material);

		if(updt){
			MaterialACubicar m = readMaterialACubicar(material);	
			m.setMaterial(material);
			m.setCantidad(cantidad);
		}else throw new IllegalArgumentException("Este Material no existe");
		return updt;
	}
	/*Delete*/public Boolean deleteMaterialACubicar(Material material){
		Boolean del=existMaterialACubicar(material);
		if(!del)			
			materiales.remove(readMaterialACubicar(material));
		else throw new IllegalArgumentException("Este Material no existe");

		return del;
	}
	public boolean existMaterialACubicar(Material material){
		//Verificar si MaterialACubicar existe a traves de material 
		Boolean exist=false;
		for (int i=0; i<materiales.size() && !exist; i++) {
			if (materiales.get(i).getMaterial().equals(material))
				exist=true;
		}
		return exist;
	}

	//Métodos

	public double calcularPrecioTotal(){
		double precioTotal=0;
		for(MaterialACubicar m: materiales){
			precioTotal+=m.calcularPrecioTotal();
		}
		return precioTotal;
	}
}
//----------------------------------------------------------------------


