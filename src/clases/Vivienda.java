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
	  if (direccion == null) {
    throw new NullPointerException("La direccion es null, algo raro pasó xD");
}
else{
   if (direccion.trim().isEmpty()) {
    throw new IllegalArgumentException("La direccion está vacía o solo tiene espacios. Por favor introduzca una direccion");
}
else
		this.direccion = direccion;
	}
	}
	public String getDocumentoLegal() {
		return documentoLegal;
	}
	public void setDocumentoLegal(String documentoLegal) {
	  if (documentoLegal == null) {
    throw new NullPointerException("El documento es null, algo raro pasó xD");
}
else{
   if (documentoLegal.trim().isEmpty()) {
    throw new IllegalArgumentException("El documento está vacío o solo tiene espacios. Por favor introduzca un documento");
}
else
		this.documentoLegal = documentoLegal;
	}
	}
	public String getTipologiaHabitacional() {
		return tipologiaHabitacional;
	}
	public void setTipologiaHabitacional(String tipologiaHabitacional) {
	  if (tipologiaHabitacional == null) {
    throw new NullPointerException("El tipo de habitación es null, algo raro pasó xD");
}
else{
   if (tipologiaHabitacional.trim().isEmpty()) {
    throw new IllegalArgumentException("El tipo de habitacion está vacío o solo tiene espacios. Por favor introduzca un tipo");
}
else
		this.tipologiaHabitacional = tipologiaHabitacional;
	}
	}
	public String getTipologiaConstructiva() {
		return tipologiaConstructiva;
	}
	public void setTipologiaConstructiva(String tipologiaConstructiva) {
	  if (tipologiaConstructiva == null) {
    throw new NullPointerException("El tipo de construcción es null, algo raro pasó xD");
}
else{
   if (tipologiaConstructiva.trim().isEmpty()) {
    throw new IllegalArgumentException("El tipo de construcción está vacía o solo tiene espacios. Por favor introduzca una direccion");
}
else
		this.tipologiaConstructiva = tipologiaConstructiva;
	}
	}
	public Boolean getFacilidadTemporal() {
		return facilidadTemporal;
	}
	public void setFacilidadTemporal(Boolean facilidadTemporal) {
	  if(facilidadTemporal==null)
	    throw new NullPointerException("Algo raro pasó xd");
	    else
		this.facilidadTemporal = facilidadTemporal;
	}
	public double getLargo() {
		return largo;
	}
	public void setLargo(double largo) {
	  if (largo == null) {
    throw new NullPointerException("El largo es null, algo raro pasó xD");
}
else{
   if (largo <=0) {
    throw new IllegalArgumentException("El largo no puede ser menor o igual a 0. Por favor introduzca un valor de Largo mayor que 0");
}
else
		this.largo = largo;
	}
	}
	public double getAncho() {
		return ancho;
	}
	public void setAncho(double ancho) {
	  if (ancho == null) {
    throw new NullPointerException("El ancho es null, algo raro pasó xD");
}
else{
   if (ancho <=0) {
    throw new IllegalArgumentException("El ancho no puede ser menor o igual a 0. Por favor introduzca un valor de Ancho mayor que 0");
}
else
		this.ancho = ancho;
	}
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
	  if (altura == null) {
    throw new NullPointerException("La altura es null, algo raro pasó xD");
}
else{
   if (altura<=0 || altura>=3000) {
    throw new IllegalArgumentException("La altura no puede ser menor o igual a 0. Por favor introduzca un valor de Altura mayor que 0 y menor que 3000");
}
else
		this.altura = altura;
	}
	}
	public int getCantNinos() {
		return cantNinios;
	}
	public void setCantNinios(int cantNinios) {
	  if (cantNinios == null) {
    throw new NullPointerException("La cantidad de ninios es null, algo raro pasó xD");
}
else{
   if (cantNinios <0 || cantNinios >8) {
    throw new IllegalArgumentException("La cantidad de ninios no puede ser menor a 0. Por favor introduzca una cantidad de ninios mayor o igual que 0 y menor o igual a 8");
}
else
		this.cantNinios = cantNinios;
	}
	}
	public int getCantAncianos() {
		return cantAncianos;
	}
	public void setCantAncianos(int cantAncianos) {
	  if (cantAncianos == null) {
    throw new NullPointerException("La cantidad de ancianos es null, algo raro pasó xD");
}
else{
   if (cantAncianos <0 || cantAncianos >8) {
    throw new IllegalArgumentException("La cantidad de ancianos no puede ser menor a 0. Por favor introduzca una cantidad de ancianos mayor o igual que 0 y menor o igual a 8");
}
else
		this.cantAncianos = cantAncianos;
	}
	}
	public int getCantEmbarazadas() {
		return cantEmbarazadas;
	}
	public void setCantEmbarazadas(int cantEmbarazadas) {
	  if (cantEmbarazadas == null) {
    throw new NullPointerException("La cantidad de embarazadas es null, algo raro pasó xD");
}
else{
   if (cantEmbarazadas <0 || cantEmbarazadas >8) {
    throw new IllegalArgumentException("La cantidad de embarazadas no puede ser menor a 0. Por favor introduzca una cantidad de embarazadas mayor o igual que 0 y menor o igual a 8");
}
else
		this.cantEmbarazadas = cantEmbarazadas;
	}
	}
	public int getTotalHabitantes() {
		return totalHabitantes;
	}
	public void setTotalHabitantes(int totalHabitantes) {
	  if (totalHabitantes == null) {
    throw new NullPointerException("El total de habitantes es null, algo raro pasó xD");
}
else{
   if (totalHabitantes <0 || totalHabitantes >30) {
    throw new IllegalArgumentException("El total de habitantes no puede ser menor a 0. Por favor introduzca un total de habitantes mayor o igual que 0 y menor o igual a 30");
}
else
		this.totalHabitantes = totalHabitantes;
	}
	}
	}

