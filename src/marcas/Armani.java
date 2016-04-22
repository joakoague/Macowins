package marcas;

import ropa.Prenda;

public class Armani extends Marca{
	private double coef=1.65;
	
	
	public double getCoefMarca(Prenda unaPrenda){
		return coef;
	}
	
}
