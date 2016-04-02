package paquete;

public class Prenda {
	public double precioFijo=100;
	private boolean importada;
	protected double precioBase;
	
//--------------GETTERS/SETTERS------------------------	
	public void setPrecioBase(double precio) {
		this.precioBase = precio;
	}
	public void setImportada(boolean importada) {
		this.importada = importada;
	}
	public Prenda(boolean importada) {
		this.importada = importada;
	}

	public boolean isImportada() {
		return importada;
	}

	public double getPrecioBase() {
		return precioBase;
	}
//--------------------METODOS-------------------------------
	public String getNombrePrenda() {				//DEVUELVE EL NOMBRE DE LA PRENDA
		return this.getClass().getSimpleName(); // Nombre de la clase
	}

	public double precioFinal(double valorFijo) {
		double porcentajeImportacion;
		double tasaImportacion = 1.3;
		double tasaNacional=1;
		porcentajeImportacion = (importada) ? tasaImportacion : tasaNacional;
		double precioFinal = (precioBase + valorFijo) * porcentajeImportacion;
		return precioFinal;
	}
	public double precioFinal(){
		return precioFinal(precioFijo);
	}

}