package paquete;


import java.util.ArrayList;


public class Macowins {
	// ------------ATRIBUTOS------------------------
	private static ArrayList<Ventas> Arrayventas = new ArrayList<Ventas>(); // Coleccion de Ventas
	// -------------METODOS---------------------------------

	public static double calcularVentas(ArrayList<Ventas> Arrayventas,String fecha) { // DEVUELVE EL TOTAL DE VENTAS DEL DIA
		// System.out.println("Entro: "+Arrayventas.size()); tamaño del array
		Arrayventas.stream()
					.filter(venta->(venta.fechaVenta).equals(fecha))
					.forEach(venta->venta.mostrarVenta());// muestra cada venta realizada
		double sumDia = calcularSuma(Arrayventas,fecha); 					// mapea y obtengo un Stream con todos los precios y el sum calcula el total
		System.out.println("Ganancia del dia: $" + sumDia + "\n");
		return sumDia;
	}

	private static double calcularSuma(ArrayList<Ventas> array,String fechaBuscar) {
		return array.stream()
				.filter(ventas->(ventas.fechaVenta).equals(fechaBuscar))
				.mapToDouble(ventas -> ventas.calcularPrecio())
				.sum();
	}
}