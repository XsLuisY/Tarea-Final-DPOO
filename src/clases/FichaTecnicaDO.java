package clases;
import java.util.ArrayList;


public class FichaTecnicaDO {
	//Atributos
	private Vivienda vivienda;
	private String fechaLevantamiento;
	private ArrayList<Afectacion> afectaciones;
	private ArrayList<Mueble> mueblesAfectados;
	private int id;
	
	//Constructor
	public FichaTecnicaDO(Vivienda vivienda, String fechaLevantamiento){
		afectaciones = new ArrayList<Afectacion>();
		mueblesAfectados = new ArrayList<Mueble>();
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

	//Métodos
	public boolean addMueble(Mueble mueble){
		boolean agregado=false;
		if(mueble!=null){
			mueblesAfectados.add(mueble);
			agregado=true;
		}
		return agregado;
	}
	
	public AfectacionPared createAfectacionPared(boolean esDerrumbeTotal, String materialPredominante, boolean esDeCarga){
		AfectacionPared afectacion = new AfectacionPared(esDerrumbeTotal, materialPredominante, esDeCarga);
		return afectacion;		
	}
	
	public boolean addAfectacion(Afectacion afectacion){
		boolean agregado=false;
		if(afectacion!=null){
			afectaciones.add(afectacion);
			agregado=true;
		}
		return agregado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}


