package ropa;

import marcas.Marca;

public class Sombrero extends Prenda{
	double metroSexualidad;

public void setMetrosexualidad(double sexualidad) {
	this.metroSexualidad = sexualidad;
	precioBase*=(1+sexualidad);
}
	public Sombrero(boolean importada,Marca unaMarca) {
		super(importada,unaMarca);
		precioBase=150;
	}
}
