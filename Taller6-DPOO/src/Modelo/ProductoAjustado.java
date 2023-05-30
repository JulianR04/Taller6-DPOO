package Modelo;

import java.util.ArrayList;

import Procesamiento.Producto;

public class ProductoAjustado implements Producto{
	
	/*Attributes*/
	
	private String nombre;
	private int precio;
	private ArrayList<Ingrediente> agregados;
	private ArrayList<Ingrediente> eliminados;
	private int calorias;
	
	/*Constructor*/
	
	public ProductoAjustado(String nombre, int precio,ArrayList<Ingrediente> agregados,ArrayList<Ingrediente> eliminados,int calorias) {
		
		this.nombre=nombre;
		this.precio=precio;
		this.agregados=agregados;
		this.eliminados=eliminados;
		this.calorias=0;
		
	}
	
	/*Methods*/
	
	public String getNombre() {
		
		return nombre;
	}
	
	public int getPrecio() {
		
		return precio;
	}
	
	/*AGREGAR A LA LISTA*/
	
	public void agregar(Ingrediente ingre) {
		
		agregados.add(ingre);
		precio=precio+ingre.getPrecio();
		nombre=nombre+(". adicion de.")+ingre.getNombre();
		calorias=calorias+ingre.getCalorias();
		
	}
	
  public void quitar(Ingrediente ingre) {
		
		eliminados.add(ingre);
		nombre=nombre+(". sin.")+ingre.getNombre();
	}

	public int getCalorias() {
		
		return calorias;
	}

	
	public String generarTextoFactura() {
		
		return nombre+"---------"+precio;
	}

	public ArrayList<Ingrediente> getAgregados() {
		return agregados;
	}

	public void setAgregados(ArrayList<Ingrediente> agregados) {
		this.agregados = agregados;
	}

	
}