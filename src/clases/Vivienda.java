package clases;
import java.util.UUID;

public class Vivienda{
	private	JefeNucleo jefeNucleo;
	private String direccion; 
	private	String documentoLegal;
	private String tipologiaHabitacional;
	private String tipologiaConstructiva;
	private Boolean facilidadTemporal;
	private double largo;
	private double ancho;
	private double altura;
	private int cantNinios;
	private int cantAncianos;
	private int cantEmbarazadas;
	private int totalHabitantes;


    //Constructor
	public Vivienda(String nombreJefeN, UUID idJefeN, String direccion,
			String documentoLegal, String tipologiaHabitacional,
			String tipologiaConstructiva, Boolean facilidadTemporal,
			double largo, double ancho, double altura, int cantNinios, int cantAncianos,
			int cantEmbarazadas, int totalHabitantes) {
		setJefeNucleo(nombreJefeN,idJefeN);
		setDireccion(direccion);
		setDocumentoLegal(documentoLegal);
		setTipologiaHabitacional(tipologiaHabitacional);
		setTipologiaConstructiva(tipologiaConstructiva);
		setFacilidadTemporal(facilidadTemporal);
		setLargo(largo);
		setAncho(ancho);
		setAltura(altura);
		setCantNinios(cantNinios);
		setCantAncianos(cantAncianos);
		setCantEmbarazadas(cantEmbarazadas);
		setTotalHabitantes(totalHabitantes);
	}
	//Encapsulamiento
	public JefeNucleo getJefeNucleo(){
		return jefeNucleo;
	}
	public void setJefeNucleo(String nombreJefeN,UUID idJefeN){
		jefeNucleo= new JefeNucleo(nombreJefeN, idJefeN);
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getDocumentoLegal() {
		return documentoLegal;
	}
	public void setDocumentoLegal(String documentoLegal) {
		this.documentoLegal = documentoLegal;
	}
	public String getTipologiaHabitacional() {
		return tipologiaHabitacional;
	}
	public void setTipologiaHabitacional(String tipologiaHabitacional) {
		this.tipologiaHabitacional = tipologiaHabitacional;
	}
	public String getTipologiaConstructiva() {
		return tipologiaConstructiva;
	}
	public void setTipologiaConstructiva(String tipologiaConstructiva) {
		this.tipologiaConstructiva = tipologiaConstructiva;
	}
	public Boolean getFacilidadTemporal() {
		return facilidadTemporal;
	}
	public void setFacilidadTemporal(Boolean facilidadTemporal) {
		this.facilidadTemporal = facilidadTemporal;
	}
	public double getLargo() {
		return largo;
	}
	public void setLargo(double largo) {
		this.largo = largo;
	}
	public double getAncho() {
		return ancho;
	}
	public void setAncho(double ancho) {
		this.ancho = ancho;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public int getCantNinos() {
		return cantNinios;
	}
	public void setCantNinios(int cantNinios) {
		this.cantNinios = cantNinios;
	}
	public int getCantAncianos() {
		return cantAncianos;
	}
	public void setCantAncianos(int cantAncianos) {
		this.cantAncianos = cantAncianos;
	}
	public int getCantEmbarazadas() {
		return cantEmbarazadas;
	}
	public void setCantEmbarazadas(int cantEmbarazadas) {
		this.cantEmbarazadas = cantEmbarazadas;
	}
	public int getTotalHabitantes() {
		return totalHabitantes;
	}
	public void setTotalHabitantes(int totalHabitantes) {
		this.totalHabitantes = totalHabitantes;
	}

}

