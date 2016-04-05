package ropa;

import marcas.Marca;

public class Saco extends Prenda {
private int cantBotones;

	public int getCantBotones() {
	return cantBotones;
}

public void setCantBotones(int cantBotones) {
	this.cantBotones = cantBotones;
	precioBase+=cantBotones*10;
}

	public Saco(boolean importada,Marca unaMarca) {
		super(importada,unaMarca);
		precioBase=300;
	}
}