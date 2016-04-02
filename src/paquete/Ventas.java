package paquete;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ventas {
	//---------------------------ATRIBUTOS----------------------------
	private int cantidadVendida;
	String fechaVenta;
	public String getFechaVenta() {
		return fechaVenta;
	}
	Prenda prendaVendida;
	private String nombrePrenda;
	private double valorFijoVenta;	//El valor fijo que tenian cuando se registro la venta
	//---------------------------METODOS----------------------------
	public Ventas(Prenda prenda, int cantidad){
		prendaVendida=prenda;
		nombrePrenda=prenda.getNombrePrenda() ;
		cantidadVendida = cantidad;
		valorFijoVenta=prenda.precioFijo;
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha=new Date();
		fechaVenta=formato.format(fecha);
	}

	public void mostrarVenta(){
		double precio=calcularPrecio();
		System.out.println("Prenda: "+this.nombrePrenda+"  -  Cantidad: "+this.cantidadVendida+"  -  Precio :$"+precio+"\nFecha: "+this.fechaVenta);
	}
	public double calcularPrecio(){
		double precio=prendaVendida.precioFinal(valorFijoVenta)*cantidadVendida;
		return precio;
	}
//------------GETTERS, SETTERS-----------------------
	public void setFecha(String fecha){
		fechaVenta=fecha;
	}
//------------------------------------------------

}

