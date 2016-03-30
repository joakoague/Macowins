package paquete;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class TestVentas {
	ArrayList<Ventas> arrayVentas=new ArrayList<Ventas>();
	static int valorFijo=100;
	Prenda sacoNacional=new Saco(false);	//$300
	Prenda camisaImportada=new Camisa(true);  //$200 
	Prenda pantalonNacional=new Pantalon(false); //$250
	static double total=0;
	@Test
	public void testPrecioSacoNacional() {
		Assert.assertEquals(400, sacoNacional.precioFinal(valorFijo),0); //300 + el valorFijo(100)
	}
	@Test
	public void testPrecioCamisaImportada(){
		Assert.assertEquals(390, camisaImportada.precioFinal(valorFijo),0); //(200+100)*1,3
	}
	@Test
	public void testVentas(){
		Ventas ventaSaco = new Ventas(sacoNacional, 3, valorFijo); //3 sacos=$1200
		Ventas ventaPantalon = new Ventas(pantalonNacional,2,valorFijo); //2 pantalones=$700
		Ventas ventaCamisa = new Ventas(camisaImportada,2,valorFijo); //2 camisas=$780
		arrayVentas.add(ventaSaco);
		arrayVentas.add(ventaPantalon);
		arrayVentas.add(ventaCamisa);
		double total=Main.calcularVentas(arrayVentas);
		Assert.assertEquals(2680, total,0);
	}	
}
