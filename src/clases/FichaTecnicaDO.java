package clases;
import java.util.ArrayList;


public class FichaTecnicaDO {
	//Atributos
	private Vivienda vivienda;
	private String fechaLevantamiento;
	private ArrayList<Mueble> mueblesAfectados;
	private ArrayList<Afectacion> afectaciones;

	//Constructor
	public FichaTecnicaDO(Vivienda vivienda, String fechaLevantamiento){
		
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
		if(mueble!=null)
			mueblesAfectados.add(mueble);
		return agregado;
	}
	
}


