package paquete;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ventas {
	//---------------------------ATRIBUTOS----------------------------
	private int cantidad;
	String fecha;
	private boolean importada;
	private String prendaVendida;
	private double precioBaseVenta, valorFijoVenta;	//El valor fijo que tenian cuando se registro la venta
	//---------------------------METODOS----------------------------
	public Ventas(Prenda prenda, int cantidad,double valorFijo){
		this.prendaVendida=prenda.getNombrePrenda() ;
		this.cantidad = cantidad;
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy --- HH:mm:ss");
		Date fecha=new Date();
		this.fecha=formato.format(fecha);
		this.valorFijoVenta=valorFijo;
		this.precioBaseVenta=prenda.getPrecioBase();
		this.importada=prenda.isImportada();
	}

	public void mostrarVenta(Ventas Venta){
		double precio=calcularPrecio();
		System.out.println("Prenda: "+Venta.getPrendaVendida()+"  -  Cantidad: "+Venta.getCantidad()+"  -  Precio :$"+precio+"\nFecha: "+Venta.getFecha());
	}
	public double calcularPrecio(){
		Prenda prenda=new Prenda(this.isImportada());			//Creo una prenda, para que ELLA calcule su precio
		prenda.setPrecioBase(this.getPrecioBaseVenta());;
		double precio=prenda.precioFinal(this.getValorFijoVenta(), prenda)*this.getCantidad();
		return precio;
	}
//------------GETTERS, SETTERS-----------------------
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
	public boolean isImportada() {
		return importada;
	}
//------------------------------------------------
}

