package paquete;

import java.util.*;
import java.util.ArrayList;

public class Main {
	// ------------ATRIBUTOS------------------------
	public static double valorFijo = 100;
	private static String input;
	private static Scanner s = new Scanner(System.in);
	private static ArrayList<Ventas> Arrayventas = new ArrayList<Ventas>(); // Coleccion de Ventas
	// -------------METODOS---------------------------------

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
			System.out.println("1 = calcular precio");
			System.out.println("2 = lista de ventas");
			System.out.println("3 = salir");
			input = s.nextLine();
			n1 = Integer.parseInt(input);
			switch (n1) {
			case 1:
				calcularPrecio();
				break;
			case 2:
				calcularVentas(Arrayventas);
				break;
			/*
			 * System.out.println(""); Iterator it = Arrayventas.iterator();
			 * while ( it.hasNext() ) { Object objeto = it.next(); Ventas
			 * producto = (Ventas)objeto; producto.MostrarVenta(producto);
			 */
			case 3:
				flag1 = false;
				break;
			default:
				System.out.println("XXX---OPCION INCORRECTA!!!!!!!");
			}

		}
	}

	private static void calcularPrecio() {
		boolean flag2 = true;
		int n2;
		loop2: while (flag2) {
			System.out.println("\nIngrese el tipo de prenda");
			System.out.println("1 = Saco");
			System.out.println("2 = Pantalon");
			System.out.println("3 = Camisa");
			System.out.println("4 = Volver atrás");
			input = s.nextLine();
			n2 = Integer.parseInt(input);
			Prenda prenda;
			switch (n2) {
			case 1:
				prenda = new Saco(false);
				break;
			case 2:
				prenda = new Pantalon(false);
				break;
			case 3:
				prenda = new Camisa(false);
				break;
			case 4:
				flag2 = false;
				break loop2;
			default:
				System.out.println("ERROR: Prenda inexistente.");
				break loop2;
			}
			boolean flagImportada = true;
			while (flagImportada) {
				System.out.print("\nEs importada? S/N: ");
				input = s.nextLine().toUpperCase();
				if ((input.contentEquals("S")) || (input.contentEquals("N"))) {
					flagImportada=false;		//sale del ciclo
				}
				else {System.out.println("XXX--- OPCION INCORRECTA");}
			}
			boolean importada = input.contentEquals("S");
			prenda.setImportada(importada);
			// double pf2 = prenda.precioFinal( tipo.getPrecioBase(), valorFijo,
			// imp);
			System.out.println("Precio final: $" + prenda.precioFinal(valorFijo));
			boolean flagRegistrar=true;
			while(flagRegistrar){
			System.out.print("Desea registrar venta? S/N: ");
			input = s.nextLine().toUpperCase();
			if ((input.contentEquals("S"))||(input.contentEquals("N"))) {
				flagRegistrar=false;
				if (input.contentEquals("S")){		//Registra la Venta
					System.out.print("Cantidad: ");
					input = s.nextLine();
					Ventas venta = new Ventas(prenda, Integer.parseInt(input), valorFijo);
					venta.mostrarVenta();
					Arrayventas.add(venta);
				}
			}
			else {System.out.println("OPCION INCORRECTA!");}
			}
			}
		}

	public static double calcularVentas(ArrayList<Ventas> Arrayventas) { // DEVUELVE EL TOTAL DE VENTAS DEL DIA
		// System.out.println("Entro: "+Arrayventas.size()); tamaño del array
		Arrayventas.forEach(venta -> venta.mostrarVenta());		 // muestra cada venta realizada
		double sumDia = calcularSuma(Arrayventas); 					// mapea y obtengo un Stream con todos los precios y el sum calcula el total
		System.out.println("Ganancia del dia: $" + sumDia + "\n");
		return sumDia;
	}

	private static double calcularSuma(ArrayList<Ventas> array) {
		return array.stream()
				.mapToDouble(ventas -> ventas.calcularPrecio())
				.sum();
	}
}