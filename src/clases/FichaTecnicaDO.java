package clases;
import java.util.ArrayList;
import java.util.UUID;


public class FichaTecnicaDO {
	//Atributos
	private Vivienda vivienda;
	private String fechaLevantamiento;
	private ArrayList<Afectacion> afectaciones;
	private ArrayList<Mueble> mueblesAfectados;
	private int id;
	
	//Constructor
	public FichaTecnicaDO(Vivienda vivienda, String fechaLevantamiento){
	    setVivienda(vivienda);
		setFechaLevantamiento(fechaLevantamiento);
		afectaciones = new ArrayList<>();
		mueblesAfectados = new ArrayList<>();
	}

	//Encapsulamiento
	public void setVivienda(Vivienda vivienda){
		this.vivienda= vivienda;		
	}
	public Vivienda getVivienda(){
		return vivienda;		
	}
	public void setFechaLevantamiento(String fechaLevantamiento){
		this.fechaLevantamiento= fechaLevantamiento;
	}
	public String getFechaLevantamiento(){
		return fechaLevantamiento;		
	}	

	//Métodos CRUD de Mueble
	//Create
	public Boolean addMueble(String nombre, int cantidad){
		Mueble mueble= new Mueble(nombre,cantidad);
		Boolean agregado=false;
		if(mueble!=null){
			mueblesAfectados.add(mueble);
			agregado=true;
		}
		return agregado;
	
    }
  
	//Read
    public Mueble readByNameMueble(String nombre){
    	Mueble mueble= null;
    	int i=0;
		Boolean found= false;
		while(i<mueblesAfectados.size() && !found){
			if(mueblesAfectados.get(i).getNombre().equalsIgnoreCase(nombre)){
				found= true;
				mueble= mueblesAfectados.get(i);
			}
			i++;
		}
		return mueble;
    }
    //Update
    public Boolean updtMueble(String nombre,int newCant){
    	Boolean exit= false;
    	Mueble mueble= readByNameMueble(nombre);
    	if(mueble!=null){
    		mueble.setCantidad(newCant);
    		exit= true;
    	}
    	return exit;
    }
    //Delete
    public Boolean delMueble(String nombre){
    	Boolean exit= false;
    	Mueble mueble= readByNameMueble(nombre);
    	if(mueble!=null){
    		mueblesAfectados.remove(mueble);
    		exit= true;
    	}
    	return exit;
    }
    
	//Métodos CRUD de Afectacion
	//Create
	public Boolean addAfectacionTecho(Boolean esDerrumbeTotal, String materialPredominante,UUID id){
	    Afectacion afectacion= new AfectacionTecho(esDerrumbeTotal,materialPredominante,id);
		Boolean agregado=false;
    
		if(afectacion!=null){
			afectaciones.add(afectacion);
			agregado=true;
		}
		return agregado;
	}
  
	public Boolean addAfectacionPared(Boolean esDerrumbeTotal, String materialPredominante,UUID id, Boolean esDeCarga){
	    Afectacion afectacion= new AfectacionPared(esDerrumbeTotal,materialPredominante,id,esDeCarga);
		Boolean agregado=false;
		if(afectacion!=null){
			afectaciones.add(afectacion);
			agregado=true;
		}
		return agregado;
	}
	//Read
    public Afectacion readByIDAfectacion(UUID id){
    	Afectacion afectacion= null;
    	int i=0;
		Boolean found= false;
		while(i<afectaciones.size() && !found){
			if(afectaciones.get(i).getId()==id){
				found= true;
				afectacion= afectaciones.get(i);
			}
			i++;
		}
		return afectacion;
    }
    //Update
    public Boolean updtAfectacion(UUID id, Boolean newEsDerrumbeTotal, String newMaterialPredominante, Boolean newEsDeCarga){
    	Boolean exit= false;
        Afectacion afectacion= readByIDAfectacion(id);
    	if(afectacion!=null){
    		afectacion.setEsDerrumbeTotal(newEsDerrumbeTotal);
    		afectacion.setMaterialPredominante(newMaterialPredominante);
    		if(afectacion instanceof AfectacionPared)
    			((AfectacionPared)afectacion).setEsDeCarga(newEsDeCarga);
    		exit= true;
    	}
    	return exit;
    }
    //Delete
    public Boolean delAfectacion(UUID id){
    	Boolean exit= false;
        Afectacion afectacion= readByIDAfectacion(id);
    	if(afectacion!=null){
    		afectaciones.remove(afectacion);
    		exit= true;
    	}
    	return exit;
    }
