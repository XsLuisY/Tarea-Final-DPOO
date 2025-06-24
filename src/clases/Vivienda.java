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
	public Vivienda(String nombreJefeN, String ciJefeN, String direccion,
			String documentoLegal, String tipologiaHabitacional,
			String tipologiaConstructiva, Boolean facilidadTemporal,
			double largo, double ancho, double altura, int cantNinios, int cantAncianos,
			int cantEmbarazadas, int totalHabitantes) {
		this.jefeNucleo= new JefeNucleo(nombreJefeN, ciJefeN);
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
	public Vivienda(){
		jefeNucleo=new JefeNucleo();
	}
	//Encapsulamiento
	public JefeNucleo getJefeNucleo(){
		return jefeNucleo;
	}
	public void setJefeNucleo(String newNombreJefeN,String newCIJefeN){
		jefeNucleo.setNombre(newNombreJefeN);
		jefeNucleo.setCI(newCIJefeN);
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		if (direccion != null && !direccion.trim().isEmpty()) {
			if(direccion.matches("[a-zA-ZñÑñáéíóúÁÉÍÓÚ0123456789 ]+"))
				this.direccion = direccion.trim().replaceAll("\\s+", " ");
			else
				throw new IllegalArgumentException("La direccion no debe tener caracteres especiales");
		}
		else
			throw new IllegalArgumentException("La direccion no puede estar vacÃ­a o ser null");
	}
	public String getDocumentoLegal() {
		return documentoLegal;
	}
	public void setDocumentoLegal(String documentoLegal) {
		if (documentoLegal != null && !documentoLegal.trim().isEmpty()) {
			if(documentoLegal.matches("[a-zA-ZÃ¡Ã©Ã­Ã³ÃºÃ�Ã‰Ã�Ã“ÃšÃ±Ã‘ ]+"))
				this.documentoLegal = documentoLegal.trim().replaceAll("\\s+", " ");
			else
				throw new IllegalArgumentException("El documento legal no debe tener caracteres especiales");
		}
		else
			throw new IllegalArgumentException("El documento legal no puede estar vacÃ­o o ser null");
	}
	public String getTipologiaHabitacional() {
		return tipologiaHabitacional;
	}
	public void setTipologiaHabitacional(String tipologiaHabitacional) {
		if (tipologiaHabitacional != null && !tipologiaHabitacional.trim().isEmpty()) {
			if(tipologiaHabitacional.matches("[a-zA-ZñÑñáéíóúÁÉÍÓÚ ]+"))
				this.tipologiaHabitacional = tipologiaHabitacional.trim().replaceAll("\\s+", " ");
			else
				throw new IllegalArgumentException("La tipologia habitacional no debe tener caracteres especiales");
		}
		else
			throw new IllegalArgumentException("La tipologia habitacional no puede estar vacÃ­a o ser null");
	}
	public String getTipologiaConstructiva() {
		return tipologiaConstructiva;
	}
	public void setTipologiaConstructiva(String tipologiaConstructiva) {
		if (tipologiaConstructiva != null && !tipologiaConstructiva.trim().isEmpty()) {
			if(tipologiaConstructiva.matches("[a-zA-ZñÑñáéíóúÁÉÍÓÚ ]+"))
				this.tipologiaConstructiva = tipologiaConstructiva.trim().replaceAll("\\s+", " ");
			else
				throw new IllegalArgumentException("La tipologia constructiva no debe tener caracteres especiales");
		}
		else
			throw new IllegalArgumentException("La tipologia constructiva no puede estar vacÃ­a o ser null");
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
		if (largo <=3) {
			throw new IllegalArgumentException("El largo no puede ser menor o igual a 3. Por favor introduzca un valor de Largo mayor que 3");
		}
		else
			if(largo*ancho> 50)
				throw new IllegalArgumentException("El Ã¡rea mÃ¡xima de una vivienda no puede exceder los 50mÂ². Ajuste el largo y ancho para que no suceda esto");
			else
				this.largo = largo;
	}
	public double getAncho() {
		return ancho;
	}
	public void setAncho(double ancho) {
		if (ancho <=3) {
			throw new IllegalArgumentException("El ancho no puede ser menor o igual a 3. Por favor introduzca un valor de Ancho mayor que 3");
		}
		else
			if(ancho*largo> 50)
				throw new IllegalArgumentException("El Ã¡rea mÃ¡xima de una vivienda no puede exceder los 50mÂ². Ajuste el largo y ancho para que no suceda esto");
			else
				this.ancho = ancho;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		if (altura<2 || altura>3) {
			throw new IllegalArgumentException("La altura no puede ser menor a 2 metros y mayor a 3 metros. Por favor introduzca un valor de Altura mayor o igual que 2 y menor o igual que 3");
		}
		else
			this.altura = altura;
	}
	public int getCantNinos() {
		return cantNinios;
	}
	public void setCantNinios(int cantNinios) {
		if (cantNinios <0 || cantNinios >10) {
			throw new IllegalArgumentException("La cantidad de ninios no puede ser menor a 0. Por favor introduzca una cantidad de ninios mayor o igual que 0 y menor o igual a 10");
		}
		else
			this.cantNinios = cantNinios;
	}
	public int getCantAncianos() {
		return cantAncianos;
	}
	public void setCantAncianos(int cantAncianos) {
		if (cantAncianos <0 || cantAncianos >10) {
			throw new IllegalArgumentException("La cantidad de ancianos no puede ser menor a 0. Por favor introduzca una cantidad de ancianos mayor o igual que 0 y menor o igual a 10");
		}
		else
			this.cantAncianos = cantAncianos;
	}
	public int getCantEmbarazadas() {
		return cantEmbarazadas;
	}
	public void setCantEmbarazadas(int cantEmbarazadas) {
		if (cantEmbarazadas <0 || cantEmbarazadas >10) {
			throw new IllegalArgumentException("La cantidad de embarazadas no puede ser menor a 0. Por favor introduzca una cantidad de embarazadas mayor o igual que 0 y menor o igual a 10");
		}
		else
			this.cantEmbarazadas = cantEmbarazadas;
	}
	public int getTotalHabitantes() {
		return totalHabitantes;
	}
	public void setTotalHabitantes(int totalHabitantes) {
   if (totalHabitantes <(cantNinios+cantAncianos+cantEmbarazadas) || totalHabitantes >40) {
    throw new IllegalArgumentException("El total de habitantes no puede ser menor al total de ninios, ancianos y embarazadas juntos ni mayor a 40");
}
else
		this.totalHabitantes = totalHabitantes;
	}
	}
		

}

