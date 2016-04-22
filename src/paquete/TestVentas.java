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
import ropa.Zapato;

public class TestVentas {
	ArrayList<Ventas> arrayVentas = new ArrayList<Ventas>();
	//----------------MARCAS----------------------------------------
	Sarkany sarkany=new Sarkany();
	Armani armani=new Armani();
	// ----------------PRENDAS--------------------------------
	Saco sacoNacional = new Saco(false,armani); // $400*1,10=440
	Camisa camisaImportada = new Camisa(true,sarkany); // $300*1,3(importada)*1,65 = 644
	Pantalon pantalonNacional = new Pantalon(false,sarkany); // $350*1,65=578
	Zapato zapatoNacional=new Zapato(false,armani);
	static double total = 0;
	// ----------------VENTAS---------------------------------------
	Ventas ventaSaco = new Ventas(sacoNacional, 3); // 3 sacos=$1650    (ABAJO LAS CUENTAS)
	Ventas ventaPantalon = new Ventas(pantalonNacional, 2); // 2 pantalones=$1816
	Ventas ventaCamisa = new Ventas(camisaImportada, 2); // 2 camisas=$1288
	Ventas ventaZapato= new Ventas(zapatoNacional,10);
	// -----------------TESTS------------------------------------
	
	@Before
	public void initialize(){
		sacoNacional.setCantBotones(10);
		pantalonNacional.setCmTela(200);          //550*1,65=908
		zapatoNacional.setTalle(10);	//50
	}

	@Test
	public void testZapatoNacional(){
		Assert.assertEquals(908, zapatoNacional.precioFinal(),0);
	}
	@Test
	public void testPrecioSacoNacional() {
		Assert.assertEquals(825, sacoNacional.precioFinal(), 0); 		
		}

	@Test
	public void testPrecioCamisaImportada() {
		Assert.assertEquals(429, camisaImportada.precioFinal(), 0);
	}

	@Test
	public void testFechaVentas() {
		ventaCamisa.setFecha("25/10/1994");
		arrayVentas.add(ventaSaco);
		arrayVentas.add(ventaPantalon);
		arrayVentas.add(ventaCamisa);
		double total = Macowins.calcularVentas(arrayVentas, "25/10/1994");
		Assert.assertEquals(858, total, 0);
	} // la unica prenda que coindice con la fecha es la VentaCamisa (858)

	@Test
	public void testTotalVentas() {
		arrayVentas.add(ventaSaco);
		arrayVentas.add(ventaPantalon);
		arrayVentas.add(ventaCamisa);
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha=new Date();
		String fechaHoy=formato.format(fecha);
		double total = Macowins.calcularVentas(arrayVentas,fechaHoy);
		Assert.assertEquals(4819, total,0); 	//1650+1816+1288
	}
	@Test 
	public void testSarkany(){
		double precio=0;
		pantalonNacional.setMarca(sarkany); 
		precio=pantalonNacional.precioFinal();
		Assert.assertEquals(743,precio,0);
	}
}
