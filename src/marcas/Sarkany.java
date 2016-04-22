package marcas;

import ropa.Prenda;

public class Sarkany extends Marca{
	private double COEF_MAYOR_500=1.35;
	private double COEF_MENOR_500=1.35;
	

	public double getCoefMarca(Prenda unaPrenda){
		if (unaPrenda.calcularPrecio()<500){
			return COEF_MENOR_500;
		}
		return COEF_MAYOR_500;
	}
	
}
