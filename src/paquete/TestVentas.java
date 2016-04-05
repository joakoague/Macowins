package paquete;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import marcas.Armani;
import marcas.Sarkany;
import ropa.Camisa;
import ropa.Pantalon;
import ropa.Saco;

public class TestVentas {
	ArrayList<Ventas> arrayVentas = new ArrayList<Ventas>();
	//----------------MARCAS----------------------------------------
	Sarkany sarkany=new Sarkany();
	Armani armani=new Armani();
	// ----------------PRENDAS--------------------------------
	Saco sacoNacional = new Saco(false,armani); // $400*1,10=440
	Camisa camisaImportada = new Camisa(true,sarkany); // $300*1,3(importada)*1,65 = 644
	Pantalon pantalonNacional = new Pantalon(false,sarkany); // $350*1,65=578
	static double total = 0;
	// ----------------VENTAS---------------------------------------
	Ventas ventaSaco = new Ventas(sacoNacional, 3); // 3 sacos=$1650    (ABAJO LAS CUENTAS)
	Ventas ventaPantalon = new Ventas(pantalonNacional, 2); // 2 pantalones=$1816
	Ventas ventaCamisa = new Ventas(camisaImportada, 2); // 2 camisas=$1288
	// -----------------TESTS------------------------------------
	
	@Before
	public void initialize(){
		sacoNacional.setCantBotones(10);
		pantalonNacional.setCmTela(200);          //550*1,65=908
	}

	@Test
	public void testPrecioSacoNacional() {
		Assert.assertEquals(550, sacoNacional.precioFinal(), 0); 		
		/*botones($100)+300+valorFijo($100)=500 => 500*marca(1,1)=$550
		
		*/
		}

	@Test
	public void testPrecioCamisaImportada() {
		Assert.assertEquals(644, camisaImportada.precioFinal(), 0);
	}

	@Test
	public void testFechaVentas() {
		ventaCamisa.setFecha("25/10/1994");
		arrayVentas.add(ventaSaco);
		arrayVentas.add(ventaPantalon);
		arrayVentas.add(ventaCamisa);
		double total = Main.calcularVentas(arrayVentas, "25/10/1994");
		Assert.assertEquals(1288, total, 0);
	} // la unica prenda que coindice con la fecha es la VentaCamisa (1288)

	@Test
	public void testTotalVentas() {
		arrayVentas.add(ventaSaco);
		arrayVentas.add(ventaPantalon);
		arrayVentas.add(ventaCamisa);
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha=new Date();
		String fechaHoy=formato.format(fecha);
		double total = Main.calcularVentas(arrayVentas,fechaHoy);
		Assert.assertEquals(4754, total,0); 	//1650+1816+1288
	}
	@Test 
	public void testSarkany(){
		double precio=0;
		pantalonNacional.setMarca(sarkany); 
		precio=pantalonNacional.precioFinal();
		Assert.assertEquals(908,precio,0);
	}
}
