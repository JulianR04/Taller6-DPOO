package Modelo;

import Procesamiento.Producto;

public class ProductoMenu implements Producto{
	
	/*Attributes*/
	
	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}

	private String nombre;
	private int precio;
	private int calorias;
	
	/*Constructor*/
	
	public ProductoMenu(String nombre, int precio, int calorias) {
		
		this.nombre=nombre;
		this.precio=precio;
		this.calorias=calorias;
		
	}
	
	/*Methods*/
	
	public String getNombre() {
		
		return nombre;
	}
	
	public int getPrecio() {
		
		return precio;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getCalorias() {
		
		return calorias;
	}
	
	public String generarTextoFactura() {
		
		return nombre+"---------"+precio;
	}

	
}