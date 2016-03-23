package paquete;



public class Ventas {

	private int cantidad, fecha;
	private Object Prenda;
	
	public Ventas(Object Prenda, int cantidad, int fecha){
		this.Prenda = Prenda;
		this.cantidad = cantidad;
		this.fecha = fecha;
	}
	
	
	//public void Vender(Object prenda, int cantidad, int fecha){}
	
	public int getCantidad() {
		return cantidad;
	}
	public int getFecha() {
		return fecha;
	}
	public Object getPrenda() {
		return Prenda;
	}


	public void MostrarVenta(Ventas Venta){
		System.out.println("Prenda: "+((Saco) Venta.getPrenda()).getNombre()+"  -  Cantidad: "+Venta.getCantidad()+"  -  Fecha: "+Venta.getFecha());
		//Aca tambies estoy casteando Saco, porque sino no sabe si tiene el metodo getNombre
	}
}
