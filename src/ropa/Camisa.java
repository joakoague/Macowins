package ropa;

import marcas.Marca;

public class Camisa extends Prenda {

	public Camisa(boolean importada,Marca unaMarca) {
		super(importada,unaMarca);
		precioBase=200;
	}
}