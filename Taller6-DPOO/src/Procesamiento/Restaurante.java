package Procesamiento;

import java.util.List;
import java.util.Map;
import java.util.Set;

import Modelo.Combo;
import Modelo.Ingrediente;
import Modelo.IngredienteRepetidoException;
import Modelo.Pedido;
import Modelo.PedidoValorSuperiorException;
import Modelo.ProductoAjustado;
import Modelo.ProductoMenu;
import Modelo.ProductoRepetidoException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unused")
public class Restaurante
{
	
	private static Pedido pedidoEnCurso;
	private static ProductoAjustado ProductoModEnCurso;

	/*Attributes*/
	
	private ArrayList<ProductoMenu> productosMenu;
	private ArrayList<Ingrediente> ingredientes;
	private ArrayList<Combo> combos;
	private ArrayList<ProductoMenu> bebidas;
	private ArrayList<Pedido> pedidos;
	
	/*Constructor*/
	
	public Restaurante (ArrayList<ProductoMenu> productosMenu, ArrayList<Ingrediente> ingredientes, ArrayList<Combo> combos,ArrayList<ProductoMenu> bebidas, ArrayList<Pedido> pedidos)
	{
		this.productosMenu = productosMenu;
		this.ingredientes = ingredientes;
		this.combos = combos;
		this.bebidas = bebidas;
		this.pedidos = pedidos;

	}
	
	/*Methods*/
	
	/*OBTENER MENU*/
	public ArrayList<ProductoMenu> getMenuBase() {
		
		return productosMenu;
		
	}
	
	/*OBTENER INGREDIENTES*/
	
	public ArrayList<Ingrediente> getIngredientes() {
		
		return ingredientes;
		
	}
	
	/*OBTENER COMBOS*/
	public ArrayList<Combo> getCombos() {
		
		return combos;
		
	}
	
	/*OBTENER BEBIDAS*/
	public ArrayList<ProductoMenu> getBebidas() {
		
		return bebidas;
		
	}
	
	public void aniadirPedidos(Pedido pedidoEnCurso) {
		
		pedidos.add(pedidoEnCurso);	
	}

/*LISTA PARA VISUALIZAR COMBOS*/
	
	public ArrayList<String> MostrarMenuCombos() throws IOException
	{
		
		ArrayList<Combo> MenuPrint = combos;
		ArrayList<String> MenuPrint2 = new ArrayList<>();
		
		for (int i=0; i<MenuPrint.size(); i++){
			
			String name =(MenuPrint.get(i)).getNombre();
			int precio =(MenuPrint.get(i)).getPrecio();
			
			MenuPrint2.add("COMBO"+name.toUpperCase()+"-------"+precio);
			
			ArrayList<ProductoMenu> items =(MenuPrint.get(i)).getItems();
			
			for (int j=0; j<items.size(); j++) {
				
				String itemscombi =items.get(j).getNombre();
				
				MenuPrint2.add("-"+itemscombi);				
			}		
		}	
		return MenuPrint2;		
	}
	/*LISTA PARA VISUALIZAR LAS BEBIDAS*/
	
	public ArrayList<String> MostrarMenuBebidas() throws IOException
	{

		ArrayList<ProductoMenu> MenuPrint = bebidas;
		ArrayList<String> MenuPrint2 = new ArrayList<>();
		
		for (int i=0; i<MenuPrint.size(); i++){
			
			String name =(MenuPrint.get(i)).getNombre();
			int precio =(MenuPrint.get(i)).getPrecio();
			
			MenuPrint2.add(name+"---------"+precio);
			
		}
		
		return MenuPrint2;}

/*LISTA PARA VISUALIZAR EL MENU*/
	
	public ArrayList<String> MostrarMenuComida() throws IOException
	{

		ArrayList<ProductoMenu> MenuPrint = productosMenu;
		ArrayList<String> MenuPrint2 = new ArrayList<>();
		
		for (int i=0; i<MenuPrint.size(); i++){
			
			String name =(MenuPrint.get(i)).getNombre();
			int precio =(MenuPrint.get(i)).getPrecio();
			
			MenuPrint2.add(name+"---------"+precio);
			
		}
		
		return MenuPrint2;
		
	}
	
/*LISTA PARA VISUALIZAR EL INGREDIENTES*/
	
	public ArrayList<String> MostrarMenuIngredientes() throws IOException
	{

		ArrayList<Ingrediente> MenuPrint = ingredientes;
		ArrayList<String> MenuPrint2 = new ArrayList<>();
		
		for (int i=0; i<MenuPrint.size(); i++){
			
			String name =(MenuPrint.get(i)).getNombre();
			int precio=(MenuPrint.get(i)).getPrecio();
			
			MenuPrint2.add(name+"---------"+precio);
			
		}
		
		return MenuPrint2;
		
	}
	
/*INICIAR PEDIDO*/
	int numeropedido=0;
	
	public void IniciarPedido(String nombre,String direccion, Restaurante restaurante) {
		
		numeropedido +=1;
		int id = numeropedido;
		ArrayList <Producto> itemsPedido= new ArrayList<>();
	    pedidoEnCurso = new Pedido(numeropedido, id, nombre, direccion, itemsPedido,0,0,0);
	}

/*MODIFICAR ITEM*/
	
	public void modificarItem(Restaurante restaurante,int opcion) {
		
		ProductoMenu productoagregadomod = (restaurante.getMenuBase()).get(opcion-1);
		ArrayList<Ingrediente> add=new ArrayList<>();
		ArrayList<Ingrediente> remove=new ArrayList<>();
		
		ProductoModEnCurso = new ProductoAjustado(productoagregadomod.getNombre(), productoagregadomod.getPrecio(),add, remove,productoagregadomod.getCalorias());
		
	}
	
/* AGREGAR AL PRODUCTO*/
	
	public void AgregarIngre(Restaurante restaurante,int opcion) {
		
		if ( ProductoModEnCurso!=null) {
			
			Ingrediente ingre = (restaurante.getIngredientes()).get(opcion-1);
			ProductoModEnCurso.agregar(ingre);
			
		}
	}
	
	
/* QUITAR AL PRODUCTO*/
	
	public void QuitarIngre(Restaurante restaurante,int opcion) {
		
		if ( ProductoModEnCurso!=null) {
			
			Ingrediente ingre = (restaurante.getIngredientes()).get(opcion-1);
			ProductoModEnCurso.quitar(ingre);}
			
	}
	
/*AGREGAR BEBIDAS A PEDIDO*/	
	
	public String agregarBebidaAPedido(Restaurante restaurante,int opcion) throws PedidoValorSuperiorException {
		
		if ( pedidoEnCurso!=null) {
			
			ProductoMenu productoagregado = (restaurante.getBebidas()).get(opcion-1);
			pedidoEnCurso.agregarProducto(productoagregado);
			return productoagregado.getNombre();
		
		}
		
		else {
			
			return "";		
		}
		
	}	
	
	
/*AGREGAR ITEM A PEDIDO*/	
	
	public String agregarItemAPedido(Restaurante restaurante,int opcion) throws PedidoValorSuperiorException {
		
		if ( pedidoEnCurso!=null) {
			
			ProductoMenu productoagregado = (restaurante.getMenuBase()).get(opcion-1);
			pedidoEnCurso.agregarProducto(productoagregado);
			return productoagregado.getNombre();
		
		}
		
		else {
			
			return "";		
		}
		
	}
	
/*AGREGAR COMBO A PEDIDO*/	
	
	public String agregarComboAPedido(Restaurante restaurante,int opcion) throws PedidoValorSuperiorException {
		
		if ( pedidoEnCurso!=null) {
				
				
				Producto productoagregado = (restaurante.getCombos()).get(opcion-1);
				pedidoEnCurso.agregarProducto(productoagregado);
				
					

			return productoagregado.getNombre();}
		
		
			
		return "";		
		
	}
	
/*AGREGAR ITEM MODIFICADO A PEDIDO*/
	
	public String agregarItemAjustadoAPedido(Restaurante restaurante) throws PedidoValorSuperiorException {
		
		if ( pedidoEnCurso!=null) {
			
			ProductoAjustado productoagregado = ProductoModEnCurso;
			pedidoEnCurso.agregarProducto(productoagregado);
			return productoagregado.getNombre();
		
		}
		
		else {
			
			return "";		
		}
		
	}
	
/*VISUALIZAR FACTURA*/
	
	public ArrayList<String> FACTURA(Restaurante restaurante) {
		
		
		pedidoEnCurso.getPrecioIvaPedido();
		pedidoEnCurso.getPrecioTotalPedido();
		
		return pedidoEnCurso.generarFacturaImprimir();
	
	}
	
/*CERRAR Y GUARDAR FACTURA*/
	
	public void cerrarYguardarFactura(Restaurante restaurante) throws IOException {

        restaurante.aniadirPedidos(pedidoEnCurso);
	}
	
/*Pedidos Iguales*/
	
	public boolean pedidosIguales(Restaurante restaurante) {
		
		boolean iguales=false;
		
		if (pedidos.size()>1) {
			
		ArrayList<String> lista1 = pedidoEnCurso.getItemsString();
	
		for (int i=0; i<pedidos.size()-1; i++) {
			
			if (lista1.equals(pedidos.get(i).getItemsString())){
				
				iguales=true;
			}
		
		}		
	}
		return iguales;}
	
/*CONSULTAR PEDIDO POR ID*/
	
	public ArrayList <String> consultarPedido(int id) {
		ArrayList <String> IDconsulta = new ArrayList<>();
		
		IDconsulta.add("No hay ningun pedido con ese ID");
		IDconsulta.add("Consulta otro ID");
		
		for (int i=0; i<pedidos.size(); i++) {
			
			if (id==(pedidos.get(i).getID())){
				
				IDconsulta = pedidos.get(i).generarFacturaImprimir();
			}
			
		
	}
		return IDconsulta;}
	
	
	/*CARGA DE DATOS*/
	/*INGREDIENTES*/
	public static Restaurante cargarInformacionRestaurantes(String archivoingre, String archivomenu,String archivocombos,String archivobebidas) throws IOException, IngredienteRepetidoException, ProductoRepetidoException {
		ArrayList<Ingrediente> Ingre = cargarIngredientes(archivoingre);
		ArrayList<ProductoMenu> Prod =cargarMenu(archivomenu);
		ArrayList<Combo> Combi= cargarCombos(archivocombos, Prod);
		ArrayList<ProductoMenu> Bebi =cargarBebidas(archivobebidas);
		ArrayList<Pedido> Pedi = new ArrayList<>();
		
		Restaurante restaurante = new Restaurante(Prod, Ingre, Combi, Bebi, Pedi);
		return restaurante;
	}
	
	public static ArrayList<Ingrediente> cargarIngredientes(String archivoingre) throws IOException, IngredienteRepetidoException {
	    ArrayList<Ingrediente> ingredienteslista = new ArrayList<>();
	    Set<String> nombresIngredientes = new HashSet<>(); // Utilizamos un conjunto para verificar duplicados

	    try (BufferedReader br = new BufferedReader(new FileReader(archivoingre))) {
	        String linea = br.readLine();

	        while (linea != null) {
	            String[] partes = linea.split(";");
	            String nombre = partes[0];

	            if (nombresIngredientes.contains(nombre)) {
	                throw new IngredienteRepetidoException(nombre); // Lanzamos la excepción si el ingrediente ya existe
	            }

	            int precio = Integer.parseInt(partes[1]);
	            int CAL = Integer.parseInt(partes[2]);

	            Ingrediente elIngrediente = new Ingrediente(nombre, precio, CAL);
	            ingredienteslista.add(elIngrediente);
	            nombresIngredientes.add(nombre);

	            linea = br.readLine();
	        }
	    }

	    return ingredienteslista;
	}

	public static ArrayList<ProductoMenu> cargarMenu(String archivomenu) throws IOException, ProductoRepetidoException {
	    ArrayList<ProductoMenu> productoslista = new ArrayList<>();
	    Set<String> nombresProductos = new HashSet<>(); // Utilizamos un conjunto para verificar duplicados

	    try (BufferedReader br = new BufferedReader(new FileReader(archivomenu))) {
	        String linea = br.readLine();

	        while (linea != null) {
	            String[] partes = linea.split(";");
	            String nombre = partes[0];

	            if (nombresProductos.contains(nombre)) {
	                throw new ProductoRepetidoException(nombre); // Lanzamos la excepción si el producto ya existe
	            }

	            String precio = partes[1];
	            int CAL = Integer.parseInt(partes[2]);

	            ProductoMenu elItem = new ProductoMenu(nombre, Integer.parseInt(precio), CAL);
	            productoslista.add(elItem);
	            nombresProductos.add(nombre);

	            linea = br.readLine();
	        }
	    }

	    return productoslista;
	}

   
   /*BEBIDAS*/
   
   public static ArrayList<ProductoMenu> cargarBebidas(String archivomenu) throws IOException {
	   
	   ArrayList<ProductoMenu> bebidaslista = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(archivomenu));
		String linea = br.readLine();
		
		while (linea != null) {
			
			String[] partes = linea.split(";");
			String nombre = partes[0];
			String precio = partes[1];
			
			ProductoMenu elItem= new ProductoMenu(nombre,Integer.parseInt(precio),Integer.parseInt(partes[2]));
			
			
			bebidaslista.add(elItem);
			linea = br.readLine();
			
		}
		
		br.close();
		return bebidaslista;
   }
		
   
   /*COMBOS*/
   
   public static ArrayList<Combo> cargarCombos(String archivoCOMBOS, ArrayList<ProductoMenu> prod) throws IOException {
	   
	        ArrayList<Combo> listaCombo = new ArrayList<>();
	 		BufferedReader br = new BufferedReader(new FileReader(archivoCOMBOS));
	 		String linea = br.readLine();
	 		
	 		while (linea != null) {
	 			
	 			String[] partes = linea.split(";");
	 			String nombre = partes[0];
	 			String descuento = partes[1].substring(0, partes[1].length() - 1);;
	 			Double descuento2= Double.parseDouble(descuento);
	 			ArrayList<String> items = new ArrayList<>();	
	 			ArrayList<ProductoMenu> itemscombo = new ArrayList<>();
	 			items.add(partes[2]);
	 			items.add(partes[3]);
	 			items.add(partes[4]);
	 			
	 			Combo elItem= new Combo(nombre,descuento2,itemscombo,0);
	 			
	 			
	 			for (int i = 0; i < items.size();i++) {	
	 				for (int j = 0; j<prod.size(); j++ ) {
	 					if ((prod.get(j)).getNombre().equals(items.get(i))) {
	 						
	 						elItem.agregarItemACombo(prod.get(j));
	 						
	 						}				 				
		 			}	
	 			}
	 				
	 			listaCombo.add(elItem);
	 			linea = br.readLine();
	 			
	 		}
	 		
	 		br.close();
	 		return listaCombo;	 
	}

   
	
	
}