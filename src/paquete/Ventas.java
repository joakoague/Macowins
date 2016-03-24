package paquete;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Ventas {

	private int cantidad;
	String fecha;
	private boolean importada;
	public boolean isImportada() {
		return importada;
	}
	private String prendaVendida;
	private double precioBaseVenta, valorFijoVenta;	//El valor fijo que tenian cuando se registro la venta
	private double precioFinal;
	
	public Ventas(Prenda prenda, int cantidad, double valorfijo, double precioFinal){
		this.prendaVendida=prenda.getNombrePrenda() ;
		this.cantidad = cantidad;
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy --- HH:mm:ss");
		Date fecha=new Date();
		this.fecha=formato.format(fecha);
		this.valorFijoVenta=valorfijo;
		this.precioBaseVenta=prenda.getPrecioBase();
		this.precioFinal = precioFinal;
	}

	public void mostrarVenta(Ventas Venta){
		//Prenda prenda=new Prenda(Venta.precioBaseVenta,Venta.isImportada());
		System.out.println("\nPrenda: "+Venta.getPrendaVendida()+"  -  Cantidad: "+Venta.getCantidad()+"  -  Precio :$"+Venta.getPrecioFinal()+"\nFecha: "+Venta.getFecha());
	}

	public double getPrecioFinal(){
		return precioFinal;
	}
	public int getCantidad() {
		return cantidad;
	}
	public String getFecha() {
		return fecha;
	}
	public String getPrendaVendida() {
		return prendaVendida;
	}
	public double getPrecioBaseVenta() {
		return precioBaseVenta;
	}
	public double getValorFijoVenta() {
		return valorFijoVenta;
	}
}
