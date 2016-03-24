package paquete;

import java.util.*;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	public static double valorFijo = 100;
	public static String input;
	public static Scanner s = new Scanner(System.in);
	public static ArrayList<Ventas> Arrayventas = new ArrayList<Ventas>();

	public static void main(String[] args) {

		boolean flag1 = true;
		int n1;
		/*
		 * System.out.println(
		 * "Ingrese el valor fijo determinado para las prendas: "); String input
		 * = s.nextLine(); int valorFijo = Integer.parseInt(input);
		 */

		while (flag1) {

			System.out.println("Ingrese que operacion desea realizar: ");
			System.out.println("1: calcular precio");
			System.out.println("2: lista de ventas");
			System.out.println("3: terminar");
			input = s.nextLine();
			n1 = Integer.parseInt(input);

			switch (n1) {
			case 1:
				calcularPrecio();
				break;
			case 2:
				mostrarVentas();
				break;
				/*
				 * System.out.println(""); Iterator it = Arrayventas.iterator();
				 * while ( it.hasNext() ) { Object objeto = it.next(); Ventas
				 * producto = (Ventas)objeto; producto.MostrarVenta(producto); */
			case 3:
				flag1 = false; 
				break;	 
			}

		}
	}

	private static void calcularPrecio() {
		boolean flag2 = true;
		int n2;
		loop2: while (flag2) {
			System.out.println("\nIngrese el tipo de prenda");
			System.out.println("0: salir");
			System.out.println("1: saco");
			System.out.println("2: pantalon");
			System.out.println("3: camisa");
			input = s.nextLine();
			n2 = Integer.parseInt(input);
			Prenda prenda;
			switch (n2) {
			case 0:
				flag2 = false;
				break loop2;
			case 1:
				prenda = new Saco(false);
				break;
			case 2:
				prenda = new Pantalon(false);
				break;
			case 3:
				prenda = new Camisa(false);
				break;
			default:
				System.out.println("ERROR: Prenda inexistente.");
				break loop2;
			}
			System.out.print("\nEs importada? S/N: ");
			input = s.nextLine().toUpperCase();
			boolean importada = (input.contentEquals("S"));
			prenda.setImportada(importada);
			/*
			 * SACADO POR JULIAN ------ Prenda prenda = new Prenda (tipo,imp);
			 * double pf = prenda.precioFinal( ((Saco)
			 * prenda.getTipo()).getPrecioBase(), valorFijo, imp); //esta
			 * casteando saco para saber el objeto, tiene que ser general
			 */
			// double pf2 = prenda.precioFinal( tipo.getPrecioBase(), valorFijo,
			// imp);
			System.out.println("Precio final: $" + prenda.precioFinal(valorFijo, prenda));
			System.out.print("Desea registrar venta? S/N: ");
			input = s.nextLine();
			if (input.contentEquals("s")) {
				System.out.print("\nCantidad?: ");
				input = s.nextLine();
				Ventas venta = new Ventas(prenda, Integer.parseInt(input), valorFijo);
				venta.mostrarVenta(venta);
				Arrayventas.add(venta);
			}
		}
	}/*
	private static void mostrarVentas(){
	Double totalVentasDelDia=(double) 0;
	ArrayList<Double>precios=new ArrayList<Double>();
	System.out.println("Entro: "+Arrayventas.size());
	Arrayventas.forEach(v->v.mostrarVenta(v));		//muestra cada venta realizada
	}			TODAVIA NO FUNCIONA ESTA MIERDA, NO PUEDO SACAR LA SUMATORIA �� 	*/
}