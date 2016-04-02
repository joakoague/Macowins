package paquete;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class TestVentas {
	ArrayList<Ventas> arrayVentas = new ArrayList<Ventas>();
	static int valorFijo = 100;
	// ----------------PRENDAS--------------------------------
	Prenda sacoNacional = new Saco(false); // $300
	Prenda camisaImportada = new Camisa(true); // $200
	Prenda pantalonNacional = new Pantalon(false); // $250
	static double total = 0;
	// ----------------VENTAS---------------------------------------
	Ventas ventaSaco = new Ventas(sacoNacional, 3, valorFijo); // 3 sacos=$1200
	Ventas ventaPantalon = new Ventas(pantalonNacional, 2, valorFijo); // 2
																		// pantalones=$700
	Ventas ventaCamisa = new Ventas(camisaImportada, 2, valorFijo); // 2
																	// camisas=$780
	// -----------------TESTS------------------------------------

	@Test
	public void testPrecioSacoNacional() {
		Assert.assertEquals(400, sacoNacional.precioFinal(valorFijo), 0); // 300
																			// +
																			// el
																			// valorFijo(100)
	}

	@Test
	public void testPrecioCamisaImportada() {
		Assert.assertEquals(390, camisaImportada.precioFinal(valorFijo), 0); // (200+100)*1,3
	}

	@Test
	public void testFechaVentas() {
		ventaCamisa.setFecha("25/10/1994");
		arrayVentas.add(ventaSaco);
		arrayVentas.add(ventaPantalon);
		arrayVentas.add(ventaCamisa);
		double total = Main.calcularVentas(arrayVentas, "25/10/1994");
		Assert.assertEquals(780, total, 0);
	} // la unica prenda que coindice con la fecha es la camisa

	@Test
	public void testTotalVentas() {
		arrayVentas.add(ventaSaco);
		arrayVentas.add(ventaPantalon);
		arrayVentas.add(ventaCamisa);
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha=new Date();
		String fechaHoy=formato.format(fecha);
		double total = Main.calcularVentas(arrayVentas,fechaHoy);
		Assert.assertEquals(2680, total,0); // La unica prenda que coincide con
											// la fecha es la camisa
	}
}
