package paquete;
import java.util.*;
import java.util.ArrayList;
public class Main {
	
	

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<Ventas> Arrayventas = new ArrayList<Ventas>();
		boolean flag1=true,flag2=true;
		int n1,n2;
		
		System.out.println("Ingrese el valor fijo determinado para las prendas: ");
		String input = s.nextLine();
		int valorFijo = Integer.parseInt(input);
		
		
		while(flag1){
			
			System.out.println("\nIngrese que operacion desea realizar: ");
			System.out.println("calcular precio: 1");
			System.out.println("lista de ventas: 2");
			System.out.println("terminar: 3");
			input = s.nextLine();
			n1 = Integer.parseInt(input);
	
			switch(n1){
				case 1:
					Object tipo = null;
					flag2 = true;
					loop2: while (flag2){
						System.out.println("\nIngrese el tipo de prenda");
						System.out.println("salir: 0");
						System.out.println("saco: 1");
						System.out.println("pantalon: 2");
						System.out.println("camisa: 3");
						input = s.nextLine();
						n2 = Integer.parseInt(input);
						
						
						
						switch(n2){		
						case 0:
							flag2 = false;
							break loop2;
						case 1:
							Saco saco = new Saco();
							tipo = saco;
							break;
						case 2:
							Pantalon p = new Pantalon();
							tipo = p;
							break;
						case 3:
							Camisa c = new Camisa();
							tipo = c;
							break;			
						default:
							System.out.println("ERROR: Prenda inexistente.");
							break loop2;
						}
						System.out.println("\nEs importada? 1/0");
						input = s.nextLine();
						boolean imp = (Integer.parseInt(input) == 1);
						Prenda prenda = new Prenda (tipo,imp);
						double pf = prenda.precioFinal( ((Saco) prenda.getTipo()).getPrecioBase(), valorFijo, imp);		//esta casteando saco para saber el objeto, tiene que ser general
						//double pf2 = prenda.precioFinal( tipo.getPrecioBase(), valorFijo, imp);
						System.out.println("\nEl precio final de la prenda es de: $"+pf);
						
						System.out.println("\ndesea venderla? Y/N");
						input = s.nextLine();
						if(input.contentEquals("y")){
							System.out.println("\nCuantas?");
							input = s.nextLine();
							Arrayventas.add(new Ventas(tipo, Integer.parseInt(input), 23032016));
							}
						
						}
						break;
				case 2:
						System.out.println("");	
						Iterator it = Arrayventas.iterator(); 
						while ( it.hasNext() ) { 
						Object objeto = it.next(); 
						Ventas producto = (Ventas)objeto; 
						producto.MostrarVenta(producto); 
						}
						break;
				case 3:
					flag1 = false;
						break;
		
				}
			
		}
	}
	
}
