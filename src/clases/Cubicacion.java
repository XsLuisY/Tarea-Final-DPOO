package clases;

import interfaces.Identificable;

import java.util.ArrayList;
import java.util.UUID;

public class Cubicacion implements Identificable{

	//Atributos	
	private ArrayList<MaterialACubicar> materiales;
	private UUID id;

	//Constructor
	public Cubicacion(){
		materiales = new ArrayList<MaterialACubicar>();
		setId();
	}
	public Cubicacion(ArrayList<MaterialACubicar> materiales){
		setMateriales(materiales);
		setId();
	}

	//Encapsulamiento
	public UUID getId() {
		return id;
	}
	public void setId() {		
		do
			id=UUID.randomUUID();
		while(MICONS.getMICONS().getListaId().containsKey(id));
		MICONS.getMICONS().getListaId().put(id, this);
	}	
	public void setMateriales(ArrayList<MaterialACubicar> materiales){
		if(materiales!=null)
			this.materiales=materiales;
		else throw new NullPointerException("La nueva lista de materiales no puede ser null");
	}		
	public ArrayList<MaterialACubicar> getMateriales(){
		return materiales;
	}		

	//CRUD-MaterialACubicar ARREGLAR
	/*Create*/ public Boolean addMaterialACubicar(Material material, double cantidad){
		Boolean add=false;
		MaterialACubicar m= readMaterialACubicar(material);
		if(m==null){
			MaterialACubicar materialACubicar= new MaterialACubicar(material,cantidad);
			materiales.add(materialACubicar);
			add= true;
		}
		else throw new IllegalArgumentException("Este Material ya existe");
		return add;
	}
	/*Read*/ public MaterialACubicar readMaterialACubicar(Material material){	
		//Busca y devuelve el objeto, si no lo encuentra devuelve null
		MaterialACubicar m= null;
		for(int i=0; i<materiales.size() && m== null; i++)
			if(materiales.get(i).getMaterial().equals(material)){
				m = materiales.get(i);
			}				
		return m; 			
	}
	/*Update*/public Boolean updateMaterialACubicar(Material material, double newCantidad){
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


