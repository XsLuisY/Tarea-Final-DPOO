package clases;
import java.util.ArrayList;
import java.util.UUID;


public class FichaTecnicaDO {
	//Atributos
	private Vivienda vivienda;
	private String fechaLevantamiento;
	private ArrayList<Afectacion> afectaciones;
	private ArrayList<Mueble> muebles;
	private UUID id;

	//Constructor
	public FichaTecnicaDO(Vivienda vivienda, String fechaLevantamiento){
		setId();
		setVivienda(vivienda);
		setFechaLevantamiento(fechaLevantamiento);
		afectaciones = new ArrayList<Afectacion>();
		muebles = new ArrayList<Mueble>();
	}

	//Encapsulamiento
	public void setVivienda(Vivienda vivienda){
		this.vivienda= vivienda;		
	}
	public Vivienda getVivienda(){
		return vivienda;		
	}
	public void setFechaLevantamiento(String fechaLevantamiento){
		if (fechaLevantamiento != null && !fechaLevantamiento.trim().isEmpty()) {
			this.fechaLevantamiento = fechaLevantamiento.trim().replaceAll("\\s+", " ");
		}
		else
			throw new IllegalArgumentException("La fecha no puede estar vacía o ser null");
	}
	public String getFechaLevantamiento(){
		return fechaLevantamiento;		
	}	

	public UUID getId() {
		return id;
	}

	public void setId() {
		do
			id=UUID.randomUUID();
		while(MICONS.existUUID(id));
	}

	//CRUD-Mueble
	/*Create*/ public Boolean addMueble(String nombre, int cantidad){
		Boolean add=false;

		if(!existMueble(nombre)){
			Mueble m= new Mueble(nombre, cantidad);
			muebles.add(m);	
			add=true;
		}
		else throw new IllegalArgumentException("Este Mueble ya existe");
		return add;
	}
	/*Read*/ public Mueble readMueble(String nombre){
		Mueble mueble= null;
		boolean found=false;
		for(int i=0; i<muebles.size() && !found; i++)
			if(muebles.get(i).getNombre().equals(nombre)){
				mueble=muebles.get(i);
				found=true;
			}					
		return mueble; 	
	}
	/*Update*/ public Boolean updtMueble(String nombre, String newNombre, int cantidad){		
		Boolean updt=!existMueble(nombre);

		if(updt){
			Mueble m = readMueble(nombre);	
			m.setNombre(newNombre);
			m.setCantidad(cantidad);
		}else throw new IllegalArgumentException("Este Mueble no existe");
		return updt;
	}
	/*Delete*/ public Boolean delMueble(String nombre){
		Boolean del=existMueble(nombre);
		if(!del)			
			muebles.remove(readMueble(nombre));
		else throw new IllegalArgumentException("Este Mueble no existe");

		return del;
	}
	public Boolean existMueble(String nombre){
		Boolean exist=false;
		for(int i=0; i<muebles.size()&& !exist; i++){		
			if(muebles.get(i).getNombre().equals(nombre))				
				exist=true;
		}
		return exist;
	}

	//CRUD-Afectacion
	/*Create*/ 
	public Boolean addAfectacionTecho(Boolean esDerrumbeTotal, String materialPredominante){
		Boolean add=false;

		if(!existAfectacionTecho(esDerrumbeTotal, materialPredominante)){
			AfectacionTecho a = new AfectacionTecho(esDerrumbeTotal, materialPredominante);
			afectaciones.add(a);	
			add=true;
		}
		else throw new IllegalArgumentException("Esta Plantilla ya existe");
		return add;
	}
	public Boolean addAfectacionPared(Boolean esDerrumbeTotal, String materialPredominante, Boolean esDeCarga){
		Boolean add=false;

		if(!existAfectacionPared(esDerrumbeTotal, materialPredominante, esDeCarga)){
			AfectacionPared a = new AfectacionPared(esDerrumbeTotal, materialPredominante, esDeCarga);
			afectaciones.add(a);	
			add=true;
		}
		else throw new IllegalArgumentException("Esta Plantilla ya existe");
		return add;
	}
	/*Read*/ public Afectacion readAfectacion(UUID id){
		Afectacion afectacion= null;
		boolean found=false;
		for(int i=0; i<afectaciones.size() && !found; i++)
			if(afectaciones.get(i).getId().equals(id)){
				afectacion=afectaciones.get(i);
				found=true;
			}					
		return afectacion; 			
	}
	/*Update*/ 
	public Boolean updtAfectacionPared(UUID id, Boolean esDerrumbeTotal, String materialPredominante, Boolean esDeCarga){
		Boolean updt=!existAfectacion(id);

		if(updt){
			AfectacionPared a = (AfectacionPared) readAfectacion(id);
			a.setEsDerrumbeTotal(esDerrumbeTotal);
			a.setMaterialPredominante(materialPredominante);
			a.setEsDeCarga(esDeCarga);
		}else throw new IllegalArgumentException("Esta Afectacion no existe");
		return updt;
	}
	public Boolean updtAfectacionTecho(UUID id, Boolean esDerrumbeTotal, String materialPredominante){
		Boolean updt=!existAfectacion(id);

		if(updt){
			AfectacionTecho a = (AfectacionTecho) readAfectacion(id);
			a.setEsDerrumbeTotal(esDerrumbeTotal);
			a.setMaterialPredominante(materialPredominante);
		}else throw new IllegalArgumentException("Esta Afectacion no existe");
		return updt;
	}
	/*Delete*/ public Boolean delAfectacion(UUID id){
		Boolean del=existAfectacion(id);

		if(!del)			
			afectaciones.remove(readAfectacion(id));
		else throw new IllegalArgumentException("Esta Afectacion no existe");

		return del;
	}
	public Boolean existAfectacion(UUID id){
		Boolean exist=false;
		for(int i=0; i<afectaciones.size()&& !exist; i++){
			if(afectaciones.get(i).getId().equals(id))
				exist=true;
		}
		return exist;
	}
	public Boolean existAfectacionPared(Boolean esDerrumbeTotal, String materialPredominante, Boolean esDeCarga){
		Boolean exist=false;
		for(int i=0; i<afectaciones.size()&& !exist; i++){
			Afectacion a = afectaciones.get(i);
			if(a instanceof AfectacionPared)
				if(((AfectacionPared)a).getEsDerrumbeTotal().equals(esDerrumbeTotal)
						&& ((AfectacionPared)a).getMaterialPredominante().equals(materialPredominante)
						&& ((AfectacionPared)a).getEsDeCarga().equals(esDeCarga))				
					exist=true;
		}
		return exist;
	}
	public Boolean existAfectacionTecho(Boolean esDerrumbeTotal, String materialPredominante){
		Boolean exist=false;
		for(int i=0; i<afectaciones.size()&& !exist; i++){
			Afectacion a = afectaciones.get(i);
			if(a instanceof AfectacionTecho)
				if(((AfectacionTecho)a).getEsDerrumbeTotal().equals(esDerrumbeTotal)
						&& ((AfectacionTecho)a).getMaterialPredominante().equals(materialPredominante))				
					exist=true;
		}
		return exist;
	}
}