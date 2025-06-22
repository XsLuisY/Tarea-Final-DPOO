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
		MaterialACubicar m= readMaterialACubicar(material);
		if(m==null){
		  MaterialACubicar material= new MaterialACubicar(material,cantidad);
		  if(material!=null){
		    materiales.add(material)
		    add= true;
		  }
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
	/*Update*/public Boolean updateMaterialACubicar(Material material, double newcantidad){
		Boolean updt= false;
		MaterialACubicar m= readMaterialACubicar(material);
		if(m!=null){
		  m.setCantidad(newCantidad);
		  updt= true;
		}
		else throw new IllegalArgumentException("Este Material no existe");
		return updt;
	}
	/*Delete*/public Boolean deleteMaterialACubicar(Material material){
		Boolean del= false;
		MaterialACubicar m= readMaterialACubicar(material);
		if(m!=null){
		  materiales.remove(m);
		  del= true;
		}
		else throw new IllegalArgumentException("Este Material no existe");
		return del;
	}
	//M�todos
	public double calcularPrecioTotal(){
		double precioTotal=0;
		for(MaterialACubicar m: materiales){
			precioTotal+=m.calcularPrecioTotal();
		}
		return precioTotal;
	}
}
//----------------------------------------------------------------------


