package Modelo;

import java.util.ArrayList;

import Procesamiento.Producto;

public class Combo implements Producto{
	
	/*Attributes*/
	
	private String nombre;
	private double descuento;
	private ArrayList<ProductoMenu> itemsCombo;
	private int precio=0;
	private int calorias;
	
	/*Constructor*/
	
	public Combo(String nombre, double descuento, ArrayList<ProductoMenu> items,int calorias ) {
		
		this.nombre=nombre;
		this.descuento=descuento;
		this. itemsCombo = items;
		this.calorias=calorias;
	}
	
	/*Methods*/
	
public ArrayList<ProductoMenu> getItems() {
		
		return itemsCombo;
	
	}
	
	
	public void agregarItemACombo(ProductoMenu itemCombo) {
		
		itemsCombo.add(itemCombo);
		precio=precio+(int)(itemCombo.getPrecio()-(itemCombo.getPrecio()*(descuento/100)));
		calorias=calorias+itemCombo.getCalorias();
	
	}
	
	public double getdescuento() {
		
		return descuento;
	}
	
	@Override
	public int getPrecio() {
		
		return precio;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}
	
	public int getCalorias() {
		
		return calorias;
	}

	@Override
	public String generarTextoFactura() {
		
		return nombre+"---------"+precio;
	}
	
}