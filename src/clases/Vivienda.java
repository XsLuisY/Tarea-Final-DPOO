package clases;


public class Vivienda{
	private	JefeNucleo jefeNucleo;
	private String direccion; 
	private	String documentoLegal;
	private String tipologiaHabitacional;
	private String tipologiaConstructiva;
	private boolean facilidadTemporal;
	private int cantNinos;
	private int cantAncianos;
	private int cantEmbarazadas;
	private int totalHabitantes;
	private double largo; 
	private double ancho;
	private double altura;

	//Encapsulamiento
	public JefeNucleo getJefeNucleo() {
		return jefeNucleo;
	}
	public void setJefeNucleo(JefeNucleo jefeNucleo) {
		this.jefeNucleo = jefeNucleo;
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
	public boolean isFacilidadTemporal() {
		return facilidadTemporal;
	}
	public void setFacilidadTemporal(boolean facilidadTemporal) {
		this.facilidadTemporal = facilidadTemporal;
	}
	public Dimensiones getDimensiones() {
		return dimensiones;
	}
	public void setDimensiones(Dimensiones dimensiones) {
		this.dimensiones = dimensiones;
	}
	public int getCantNinos() {
		return cantNinos;
	}
	public void setCantNinos(int cantNinos) {
		this.cantNinos = cantNinos;
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
}

