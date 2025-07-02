package clases;
import interfaces.Identificable;

import java.util.ArrayList;
import java.util.UUID;
import java.util.Date;

import javax.swing.JOptionPane;


public class FichaTecnicaDO implements Identificable{
	//Atributos
	private static final String TECHO = "Techo";
	private static final String PARED = "Pared";
	private static final String PARED_CARGA = "Pared de carga";

	private Vivienda vivienda;
	private Date fechaLevantamiento;
	private ArrayList<Afectacion> afectaciones;
	private ArrayList<Mueble> muebles;
	private UUID id;

	//Constructor
	public FichaTecnicaDO(Vivienda vivienda, ArrayList<Afectacion> afectaciones, ArrayList<Mueble> muebles){
		setId();
		setVivienda(vivienda);
		setFechaLevantamiento();
		tieneAfectaciones(muebles, afectaciones);
	}

	public FichaTecnicaDO() {				
		afectaciones = new ArrayList<Afectacion>();
		muebles = new ArrayList<Mueble>();
	}

	//Encapsulamiento
	public void setVivienda(Vivienda vivienda){
		if(vivienda!=null){
			this.vivienda= vivienda;
			MICONS.getMICONS().getListaViviendaAsignada().put(vivienda, true);
		}
		else throw new NullPointerException("Debes seleccionar una vivienda para asignar.");
	}
	public Vivienda getVivienda(){
		return vivienda;		
	}
	public void setFechaLevantamiento(){
		fechaLevantamiento=new Date();
	}
	public Date getFechaLevantamiento(){
		return fechaLevantamiento;		
	}	
	public void setAfectaciones(ArrayList<Afectacion> afectaciones){
		if(afectaciones!=null)
			this.afectaciones=afectaciones;
		else throw new NullPointerException("La lista de afectaciones no puede ser null");
	}
	public ArrayList<Afectacion> getAfectaciones(){
		return afectaciones;
	}
	public void setMuebles(ArrayList<Mueble> muebles){
		if(muebles!=null)
			this.muebles=muebles;
		else throw new NullPointerException("La lista de afectaciones no puede ser null");
	}
	public ArrayList<Mueble> getMuebles(){
		return muebles;
	}
	public UUID getId() {
		return id;
	}

	public void setId() {
		do
			id=UUID.randomUUID();
		while(MICONS.getMICONS().getListaId().containsKey(id));
		MICONS.getMICONS().getListaId().put(id, this);
	}

	public void tieneAfectaciones(ArrayList<Mueble> muebles, ArrayList<Afectacion> afectaciones){
		if(afectaciones.isEmpty() && muebles.isEmpty())
			throw new IllegalArgumentException("La ficha técnica debe contener al menos una afectación o un mueble afectado.");
		else{
			setAfectaciones(afectaciones);
			setMuebles(muebles);
		}
	}

	//CRUD-Mueble
	/*Create*/ public Boolean addMueble(String nombre, int cantidad){
		Boolean add=false;
		Mueble m= readMueble(nombre);
		if(m==null){
			Mueble mueble= new Mueble(nombre,cantidad);
			if(mueble!=null){
				muebles.add(mueble);
				add= true;
			}new NullPointerException("El mueble no puede ser null");
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
	/*Update*/ public Boolean updtMueble(String nombre, String newNombre, int newcantidad){	
		Boolean updt= false;
		Mueble mueble= readMueble(newNombre);
		Mueble m= readMueble(nombre);
		if(m!=null){
			if(mueble==null || mueble.getNombre().equals(m.getNombre())){
				m.setCantidad(newcantidad);
				m.setNombre(newNombre);
				updt= true;
			}
			else throw new IllegalArgumentException("Este nombre de mueble ya existe");
		}
		else throw new IllegalArgumentException("Este Mueble no existe");
		return updt;
	}
	/*Delete*/ public Boolean delMueble(String nombre){
		Boolean del= false;
		Mueble m= readMueble(nombre);
		if(m!=null){
			muebles.remove(m);
			del= true;
		}
		else throw new IllegalArgumentException("Este Mueble no existe");
		return del;
	}

	//CRUD-Afectacion
	/*Create*/ 
	public boolean addAfectacion(String tipo, String material, boolean esDerrumbeTotal) {
		boolean add = false;

		if (tipo.equals(TECHO)) 
			add =addAfectacionTecho(esDerrumbeTotal, material);
		else if (tipo.equals(PARED_CARGA)) 
			add =addAfectacionPared(esDerrumbeTotal, material, true);
		else if (tipo.equals(PARED)) 
			add =addAfectacionPared(esDerrumbeTotal, material, false);	       

		return add;
	}
	public Boolean addAfectacionTecho(Boolean esDerrumbeTotal, String materialPredominante){
		Boolean add=false;

		if(!existAfectacionTecho(esDerrumbeTotal, materialPredominante)){
			AfectacionTecho a = new AfectacionTecho(esDerrumbeTotal, materialPredominante);
			afectaciones.add(a);	
			add=true;
		}
		else throw new IllegalArgumentException("Esta afectacion ya existe");
		return add;
	}

	public Boolean addAfectacionPared(Boolean esDerrumbeTotal, String materialPredominante, Boolean esDeCarga){
		Boolean add=false;

		if(!existAfectacionPared(esDerrumbeTotal, materialPredominante, esDeCarga)){
			AfectacionPared a = new AfectacionPared(esDerrumbeTotal, materialPredominante, esDeCarga);
			afectaciones.add(a);	
			add=true;
		}
		else throw new IllegalArgumentException("Esta Afectacion ya existe");
		return add;
	}
	/*Read*/ public Afectacion readAfectacion(UUID id){
		Afectacion afectacion= null;
		for(int i=0; i<afectaciones.size() && afectacion==null; i++)
			if(afectaciones.get(i).getId().equals(id))
				afectacion=afectaciones.get(i);			

		if(afectacion==null) throw new NullPointerException("Esta afectacion no existe");
		return afectacion; 			
	}
	/*Update*/ 
	public Boolean updtAfectacionPared(UUID id, Boolean esDerrumbeTotal, String materialPredominante, Boolean esDeCarga){
		Boolean updt=false;

		if(existAfectacion(id)){
			AfectacionPared a = (AfectacionPared) readAfectacion(id);
			a.setEsDerrumbeTotal(esDerrumbeTotal);
			a.setMaterialPredominante(materialPredominante);
			a.setEsDeCarga(esDeCarga);
			updt=true;
		}else throw new IllegalArgumentException("Esta afectacion no existe");

		return updt;
	}
	public Boolean updtAfectacionTecho(UUID id, Boolean esDerrumbeTotal, String materialPredominante){
		Boolean updt=false;

		if(existAfectacion(id)){
			AfectacionTecho a = (AfectacionTecho) readAfectacion(id);
			a.setEsDerrumbeTotal(esDerrumbeTotal);
			a.setMaterialPredominante(materialPredominante);
			updt=true;
		}else throw new IllegalArgumentException("Esta afectacion no existe");

		return updt;
	}
	/*Delete*/ public Boolean delAfectacion(UUID id){
		Boolean del=existAfectacion(id);
		if(del)			
			afectaciones.remove(readAfectacion(id));
		else throw new IllegalArgumentException("Esta afectacion no existe");
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