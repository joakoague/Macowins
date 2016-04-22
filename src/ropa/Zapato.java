package ropa;

import marcas.Marca;

public class Zapato extends Prenda{
	double talle;
	public double getTalle() {
	return talle;
}
public void setTalle(double talle) {
	this.talle= talle;
	precioBase+=(5*talle);
}
	public Zapato(boolean importada,Marca unaMarca) {
		super(importada,unaMarca);
		precioBase=400;
	}
}
