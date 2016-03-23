package paquete;

public class Prenda {
	
	private boolean importada;
	private Object Tipo;
	
	public Prenda(Object Tipo, boolean lugar){
		this.Tipo = Tipo;		
		this.importada = lugar;		
	}

	
	
	public boolean getLugar() {
		return importada;
	}
	public void setLugar(boolean lugar) {
		this.importada = lugar;
	}
	public Object getTipo() {
		return Tipo;
	}
	public void setTipo(Object Tipo) {
		this.Tipo = Tipo;
	}
	
	public double precioFinal(int precioB, int valorF, boolean importacion){
		double impo;
		
		if (importacion)
			impo = 1.3;
		else
			impo = 1;
			
		double pf = (valorF + precioB)*impo;
		return pf;
	}

	
}