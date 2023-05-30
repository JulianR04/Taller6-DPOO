package Modelo;

public class Ingrediente{
	
	/*Attributes*/
	
	private String nombre;
	private int costoAdicional;
	private int calorias;
	
	/*Constructor*/
	
	public Ingrediente (String nombre, int costoAdicional, int calorias) {
		
		this.nombre=nombre;
		this.costoAdicional=costoAdicional;
		this.calorias=calorias;
		
	}
	
	/*Methods*/
	
	public String getNombre() {
		
		return nombre;
	}
	
	public int getPrecio() {
		
		return costoAdicional;
	}
	
	public int getCalorias() {
		
		return calorias;
	}

	public int getCostoAdicional() {
		// TODO Auto-generated method stub
		return costoAdicional;
	}
}

	
