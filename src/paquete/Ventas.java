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
	
	public Ventas(Prenda prenda, int cantidad, double vf){
		this.prendaVendida=prenda.getNombrePrenda() ;
		this.cantidad = cantidad;
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy --- HH:mm:ss");
		Date fecha=new Date();
		this.fecha=formato.format(fecha);
		this.valorFijoVenta=vf;
		this.precioBaseVenta=prenda.getPrecioBase();
	}

	public void mostrarVenta(Ventas Venta){
		Prenda prenda=new Prenda(Venta.precioBaseVenta,Venta.isImportada());
		System.out.println("Prenda: "+Venta.getPrendaVendida()+"  -  Cantidad: "+Venta.getCantidad()+"  -  Precio :$"+prenda.precioFinal(Venta.getValorFijoVenta(), prenda)*Venta.getCantidad()+"\nFecha: "+Venta.getFecha());
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
