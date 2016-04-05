package ropa;

import marcas.Marca;

public class Pantalon extends Prenda {
double cmTela;
	public double getCmTela() {
	return cmTela;
}
public void setCmTela(double cmTela) {
	this.cmTela = cmTela;
	precioBase+=cmTela;
}
	public Pantalon(boolean importada,Marca unaMarca) {
		super(importada,unaMarca);
		precioBase=250;
	}
}