package clases;

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
	public Vivienda(String nombreJefeN, Steing idJefeN, String direccion,
			String documentoLegal, String tipologiaHabitacional,
			String tipologiaConstructiva, Boolean facilidadTemporal,
			double largo, double ancho, double altura, int cantNinios, int cantAncianos,
			int cantEmbarazadas, int totalHabitantes) {
		this.jefeNucleo= new JefeNucleo(nombreJefeN, idJefeN);
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
	public void setJefeNucleo(String newNombreJefeN,String newIdJefeN){
		jefeNucleo.setNombre(newNombreJefeN);
		jefeNucleo.setId(newIdJefeN);
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
	  if (direccion != null && !direccion.trim().isEmpty()) {
      this.direccion = direccion.trim().replaceAll("\\s+", " ");
   }
   else
		throw new IllegalArgumentException("La direccion no puede estar vacía o ser null");
	}
	public String getDocumentoLegal() {
		return documentoLegal;
	}
	public void setDocumentoLegal(String documentoLegal) {
	  if (documentoLegal != null && !documentoLegal.trim().isEmpty()) {
    if(documentoLegal.matches()("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+"))
      this.documentoLegal = documentoLegal.trim().replaceAll("\\s+", " ");
    else
      throw new IllegalArgumentException("El documento legal solo debe tener letras");
   }
   else
		throw new IllegalArgumentException("El documento legal no puede estar vacío o ser null");
	}
	public String getTipologiaHabitacional() {
		return tipologiaHabitacional;
	}
	public void setTipologiaHabitacional(String tipologiaHabitacional) {
	  if (tipologiaHabitacional != null && !tipologiaHabitacional.trim().isEmpty()) {
    if(tipologiaHabitacional.matches()("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+"))
      this.tipologiaHabitacional = tipologiaHabitacional.trim().replaceAll("\\s+", " ");
    else
      throw new IllegalArgumentException("La tipologia habitacional solo debe tener letras");
   }
   else
		throw new IllegalArgumentException("La tipologia habitacional no puede estar vacía o ser null");
	}
	public String getTipologiaConstructiva() {
		return tipologiaConstructiva;
	}
	public void setTipologiaConstructiva(String tipologiaConstructiva) {
	  if (tipologiaConstructiva != null && !tipologiaConstructiva.trim().isEmpty()) {
    if(tipologiaConstructiva.matches()("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+"))
      this.tipologiaConstructiva = tipologiaConstructiva.trim().replaceAll("\\s+", " ");
    else
      throw new IllegalArgumentException("La tipologia constructiva solo debe tener letras");
   }
   else
		throw new IllegalArgumentException("La tipologia constructiva no puede estar vacía o ser null");
	}
	public Boolean getFacilidadTemporal() {
		return facilidadTemporal;
	}
	public void setFacilidadTemporal(Boolean facilidadTemporal) {
	  if(facilidadTemporal==null)
	    throw new NullPointerException("La facilidad temporal no debe ser null");
	    else
		this.facilidadTemporal = facilidadTemporal;
	}
	public double getLargo() {
		return largo;
	}
	public void setLargo(double largo) {
   if (largo <=0) {
    throw new IllegalArgumentException("El largo no puede ser menor o igual a 0. Por favor introduzca un valor de Largo mayor que 0");
}
else
		this.largo = largo;
	}
	public double getAncho() {
		return ancho;
	}
	public void setAncho(double ancho) {
   if (ancho <=0) {
    throw new IllegalArgumentException("El ancho no puede ser menor o igual a 0. Por favor introduzca un valor de Ancho mayor que 0");
}
else
		this.ancho = ancho;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
   if (altura<=0 || altura>=3000) {
    throw new IllegalArgumentException("La altura no puede ser menor o igual a 0. Por favor introduzca un valor de Altura mayor que 0 y menor que 3000");
}
else
		this.altura = altura;
	}
	public int getCantNinos() {
		return cantNinios;
	}
	public void setCantNinios(int cantNinios) {
   if (cantNinios <0 || cantNinios >8) {
    throw new IllegalArgumentException("La cantidad de ninios no puede ser menor a 0. Por favor introduzca una cantidad de ninios mayor o igual que 0 y menor o igual a 8");
}
else
		this.cantNinios = cantNinios;
	}
	public int getCantAncianos() {
		return cantAncianos;
	}
	public void setCantAncianos(int cantAncianos) {
   if (cantAncianos <0 || cantAncianos >8) {
    throw new IllegalArgumentException("La cantidad de ancianos no puede ser menor a 0. Por favor introduzca una cantidad de ancianos mayor o igual que 0 y menor o igual a 8");
}
else
		this.cantAncianos = cantAncianos;
	}
	public int getCantEmbarazadas() {
		return cantEmbarazadas;
	}
	public void setCantEmbarazadas(int cantEmbarazadas) {
   if (cantEmbarazadas <0 || cantEmbarazadas >8) {
    throw new IllegalArgumentException("La cantidad de embarazadas no puede ser menor a 0. Por favor introduzca una cantidad de embarazadas mayor o igual que 0 y menor o igual a 8");
}
else
		this.cantEmbarazadas = cantEmbarazadas;
	}
	public int getTotalHabitantes() {
		return totalHabitantes;
	}
	public void setTotalHabitantes(int totalHabitantes) {
   if (totalHabitantes <0 || totalHabitantes >30) {
    throw new IllegalArgumentException("El total de habitantes no puede ser menor a 0. Por favor introduzca un total de habitantes mayor o igual que 0 y menor o igual a 30");
}
else
		this.totalHabitantes = totalHabitantes;
	}
	
	}

