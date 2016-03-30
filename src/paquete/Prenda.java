package paquete;

public class Prenda {

	private boolean importada;
	protected double precioBase;
	
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

	public String getNombrePrenda() {
		return this.getClass().getSimpleName(); // Nombre de la clase
	}

	public double precioFinal(double valorFijo, Prenda prenda) {
		double porcentajeImportacion;
		porcentajeImportacion = (prenda.importada) ? 1.3 : 1;
		double precioFinal = (prenda.precioBase + valorFijo) * porcentajeImportacion;
		return precioFinal;
	}

}