package ropa;

import marcas.Marca;

public class Prenda {
	public double precioFijo=100;
	private boolean importada;
	protected double precioBase;
	private Marca marca;
	double tasaImportacion = 1.3;
	double tasaNacional=1;
	
//--------------GETTERS/SETTERS------------------------	
	public void setPrecioBase(double precio) {
		this.precioBase = precio;
	}
	public void setImportada(boolean importada) {
		this.importada = importada;
	}
	public Prenda(boolean importada,Marca unaMarca) {
		this.importada = importada;
		this.marca=unaMarca;
	}

	public boolean isImportada() {
		return importada;
	}

	public double getPrecioBase() {
		return precioBase;
	}
	
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
//--------------------METODOS-------------------------------
	public String getNombrePrenda() {				//DEVUELVE EL NOMBRE DE LA PRENDA
		return this.getClass().getSimpleName(); // Nombre de la clase
	}

	public double calcularPrecio(double valorFijo) {
		double porcentajeImportacion;
		porcentajeImportacion = (importada) ? tasaImportacion : tasaNacional;
		double precioFinal = (precioBase + valorFijo) * porcentajeImportacion;
		return precioFinal;
	}
	
	public double calcularPrecio(){
		return calcularPrecio(precioFijo);
	}

	public double precioFinal(){
		double precioPrenda=calcularPrecio();
		double total=precioPrenda*(marca.getCoefMarca(this));
		total=Math.round(total);
		return total;
	}
}