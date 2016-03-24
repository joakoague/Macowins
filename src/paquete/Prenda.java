package paquete;

public class Prenda {

	private boolean importada;
	private double precioBase;
	
	public void setImportada(boolean importada) {
		this.importada = importada;
	}
	public Prenda(double precioBase, boolean importada) {
		this.importada = importada;
		this.precioBase = precioBase;
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
		double pf = (prenda.precioBase + valorFijo) * porcentajeImportacion;
		return pf;
	}

}