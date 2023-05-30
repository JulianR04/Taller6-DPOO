package Consola;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Modelo.IngredienteRepetidoException;
import Modelo.Pedido;
import Modelo.PedidoValorSuperiorException;
import Modelo.ProductoMenu;
import Modelo.ProductoRepetidoException;
import Procesamiento.Restaurante;

//Taller 6

@SuppressWarnings("unused")
public class Aplicacion{

	private static Restaurante restaurante;

	/*ESTADOS DEL MENU*/
	
	public void ejecutarAplicacion() throws IOException, PedidoValorSuperiorException
	{

		System.out.println("Bienvenido a DPOO Burgirs\n");

		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				System.out.println(opcion_seleccionada);
				
				if (opcion_seleccionada == 1 && restaurante != null) {
					
					MostrarMenuComida(restaurante);
					MostrarMenuCombos(restaurante);
					MostrarMenuIngredientes(restaurante);
					MostrarMenuBebidas(restaurante);}
				
                if (opcion_seleccionada == 2 && restaurante != null) {
					
					IniciarPedido(restaurante);}
                
                if (opcion_seleccionada == 3 && restaurante != null) {
					
					gestorMenu(restaurante);}
                
                if (opcion_seleccionada == 4 && restaurante != null) {
					
					cerrarYguardarPedido(restaurante);
					System.out.println("Su pedido se guardo con exito, ya puede consultarlo.");}
                if (opcion_seleccionada == 5 && restaurante != null) {
					
                	consultarId(restaurante);}
                
                if (opcion_seleccionada == 6 && restaurante != null) {
					
					pedidosIguales(restaurante);}
		
				else if (opcion_seleccionada == 7 && restaurante != null)
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
					
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}
	
	


	/*MUESTRA EL MENU*/
	
		public void mostrarMenu()
		{
			System.out.println("\nOpciones de la aplicación\n");
			System.out.println("1. Ver Menu");
			System.out.println("2. Iniciar nuevo pedido");
			System.out.println("3. Agregar un elemento al pedido");
			System.out.println("4. Cerrar pedido y guardar la factura");
			System.out.println("5. Consultar la informacion de un pedido dando su id");
			System.out.println("6. Verificar si el pedido es igual a otro");
			System.out.println("7. Salir");
		}
		
	/*CARGAR MENU, COMBOS E INGREDIENTES PARA VISUALIZAR*/
		
		public static void ejecutarCargaryMostrarMenu() throws IOException, IngredienteRepetidoException, ProductoRepetidoException
		{
			String infobebidas= "C:\\Users\\Adriana Sofía Rozo C\\Documents\\Tercer Semestre\\Proyectos DPOO\\Taller6\\Taller6-Dpoo\\TALLER2-DPOO2023-main\\TALLER2\\TALLER2HAMBURGUESAS\\src\\data\\bebidas.txt";
			String infocombos="C:\\Users\\Adriana Sofía Rozo C\\Documents\\Tercer Semestre\\Proyectos DPOO\\Taller6\\Taller6-Dpoo\\TALLER2-DPOO2023-main\\TALLER2\\TALLER2HAMBURGUESAS\\src\\data\\combos.txt";
			String infoingredientes="C:\\Users\\Adriana Sofía Rozo C\\Documents\\Tercer Semestre\\Proyectos DPOO\\Taller6\\Taller6-Dpoo\\TALLER2-DPOO2023-main\\TALLER2\\TALLER2HAMBURGUESAS\\src\\data\\ingredientes.txt";
			String infoproductos= "C:\\Users\\Adriana Sofía Rozo C\\Documents\\Tercer Semestre\\Proyectos DPOO\\Taller6\\Taller6-Dpoo\\TALLER2-DPOO2023-main\\TALLER2\\TALLER2HAMBURGUESAS\\src\\data\\menu.txt";
			
			restaurante=Restaurante.cargarInformacionRestaurantes(infoingredientes,infoproductos,infocombos,infobebidas);
			
		}
		
	/*VERIFICAR PEDIDOS IGUALES*/
		
		public static void pedidosIguales (Restaurante restaurante) throws IOException {
			if (restaurante.pedidosIguales(restaurante)) {
				
				System.out.println("Se encontro un pedido igual");
				
			}
			else {
				System.out.println("No hay pedidos iguales");
			}
			
			
		}
		
	/*OMOSTRAR EL MENU DE COMBOS*/
		
		public static void MostrarMenuCombos(Restaurante restaurante) throws IOException {
			
			System.out.println("Menu Combos");
			System.out.println("/n");
			int countcombi=0;
			ArrayList<String> MenuPrint = restaurante.MostrarMenuCombos();
			
			for (int i=0; i<MenuPrint.size(); i++){
				
				String name =(MenuPrint.get(i));
				
				if (i%4==0) {
				
				System.out.println((countcombi+1)+(". ")+name);
				countcombi+=1;
				}
				
				else {
					
					System.out.println(name);
				}
			}
			
		}
		
	/*MOSTRAR EL MENU DE BEBIDAS*/
		
		public static void MostrarMenuBebidas(Restaurante restaurante) throws IOException
		{
			
			System.out.println("Menu Bebidas");
			System.out.println("/n");
			ArrayList<String> MenuPrint = restaurante.MostrarMenuBebidas();
			
			for (int i=0; i<MenuPrint.size(); i++){
				
				String name =(MenuPrint.get(i));
				
				System.out.println((i+1)+(". ")+name);
			}
			
		}
			
	/*MOSTRAR EL MENU DE COMIDA*/
		
		public static void MostrarMenuComida(Restaurante restaurante) throws IOException
		{
			
			System.out.println("Menu Productos");
			System.out.println("/n");
			ArrayList<String> MenuPrint = restaurante.MostrarMenuComida();
			
			for (int i=0; i<MenuPrint.size(); i++){
				
				String name =(MenuPrint.get(i));
				
				System.out.println((i+1)+(". ")+name);
			}
			
		}
		
	/*MOSTRAR EL MENU DE INGREDIENTES*/
		
		public static void MostrarMenuIngredientes(Restaurante restaurante) throws IOException
		{

			System.out.println("Menu Adiciones");
			System.out.println("/n");
			ArrayList<String> MenuPrint = restaurante.MostrarMenuIngredientes();
			
			for (int i=0; i<MenuPrint.size(); i++){
				
				String name =(MenuPrint.get(i));
				
				System.out.println((i+1)+(". ")+name);
			}
			
		}
		
	/*CONSULTAR ID*/
		
		public void consultarId(Restaurante restaurante) {
			
			int idaconsultar = Integer.parseInt(input("Por favor ingrese el Id a consultar "));
			 ArrayList <String> pedidoget=restaurante.consultarPedido(idaconsultar);
			 
			 for (int i=0; i<pedidoget.size();i++) {
				 
				 System.out.println(pedidoget.get(i));
			 }
			
			
		}
		
	/*SELECCIONAR OPCIONES DEL MENU DE COMIDA*/
		
		//mostrarNuevasOpciones();
		
		int numeropedido=0;
		
		public void IniciarPedido(Restaurante restaurante) throws IOException {
			
			String nombre = (input("Por favor ingrese su nombre "));
			String direccion = (input("Por favor ingrese la direccion del cliente "));
			restaurante.IniciarPedido(nombre, direccion,restaurante);
			
			System.out.println("Su pedido fue creado de manera exitosa. Ahora puede agregar los productos.");
			obtenerStringFactura(restaurante);
		}
		
		/*AGREGAR COMBO A PEDIDO*/
		private void agregarComboAPedido(Restaurante restaurante2) throws IOException, PedidoValorSuperiorException {
			
			MostrarMenuCombos(restaurante);
			int item_seleccionado = Integer.parseInt(input("Por favor seleccione una opción"));
			String printNewPedido = "Debe iniciar un pedido nuevo para poder agregar productos. Seleccione la opcion 2";
			
			
			String nuevo=restaurante.agregarComboAPedido(restaurante2, item_seleccionado);
			
			if (nuevo!="") {
				printNewPedido = nuevo + "fue agregado al pedido.";}
			
			
			System.out.println(printNewPedido);
			obtenerStringFactura(restaurante);
			
		}
		
		/*GESTOR DE MENUS*/
		
		private void gestorMenu(Restaurante restaurante2) throws IOException, PedidoValorSuperiorException {
			
			System.out.println("\n MENU \n");
			System.out.println("1. Ver productos");
			System.out.println("2. Ver combos");
			System.out.println("3. Ver bebidas");
			System.out.println(" \n");
			
			int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
			System.out.println(opcion_seleccionada);
			
			if (opcion_seleccionada == 1 && restaurante != null) {
				
				System.out.println(" \n");
				agregarItemAPedido(restaurante);}
			
            if (opcion_seleccionada == 2 && restaurante != null) {
				
            	System.out.println(" \n");
				agregarComboAPedido(restaurante);}
            
            if (opcion_seleccionada == 3 && restaurante != null) {
				
				System.out.println(" \n");
				agregarBebidaAPedido(restaurante);}

            else
			{
				System.out.println("Por favor seleccione una opción válida.");
				System.out.println(" \n");
				
			}	
		}
		
		/*AGREGAR PRODUCTO A PEDIDO*/
		
		private void agregarBebidaAPedido(Restaurante restaurante) throws IOException, PedidoValorSuperiorException {
			
			MostrarMenuBebidas(restaurante);
			int item_seleccionado = Integer.parseInt(input("Por favor seleccione una opción"));
			
			String printNewPedido = "Debe iniciar un pedido nuevo para poder agregar productos. Seleccione la opcion 2";
			String nuevo=restaurante.agregarBebidaAPedido(restaurante, item_seleccionado);
			obtenerStringFactura(restaurante);
			
			if (nuevo!="") {
				
				printNewPedido = nuevo + "fue agregado al pedido.";
				
			}
			
		System.out.println(printNewPedido);}
			
			
		
		/*AGREGAR PRODUCTO A PEDIDO*/
		
		private void agregarItemAPedido(Restaurante restaurante2) throws IOException, PedidoValorSuperiorException {
			
			MostrarMenuComida(restaurante);
			int item_seleccionado = Integer.parseInt(input("Por favor seleccione una opción"));
			int modificar = Integer.parseInt(input("Si desea modificar su item ingrese 1, de lo contrario ponga 0"));
			boolean modificando = true;
			
			String printNewPedido = "Debe iniciar un pedido nuevo para poder agregar productos. Seleccione la opcion 2";
			
			if (modificar==1) {
				
				restaurante.modificarItem(restaurante,item_seleccionado);
				
				while (modificando) {	
					
				System.out.println("1. Agregar ingredientes al producto");
				System.out.println("2. Quitar ingredientes al producto");
				System.out.println("3. Salir");
				
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				System.out.println(opcion_seleccionada);
				
				if (opcion_seleccionada == 1) {
					
					MostrarMenuIngredientes(restaurante);
					int ingre_seleccionado = Integer.parseInt(input("Por favor seleccione una opción que desea agregar:"));
					restaurante.AgregarIngre(restaurante,ingre_seleccionado);}
				
                if (opcion_seleccionada == 2) {
					
                	MostrarMenuIngredientes(restaurante);
                	int ingre_seleccionado = Integer.parseInt(input("Por favor seleccione una opción que desea quitar:"));
					restaurante.QuitarIngre(restaurante,ingre_seleccionado);}
                
                if (opcion_seleccionada == 3) {
					
					modificando=false;
					
					String nuevo=restaurante.agregarItemAjustadoAPedido(restaurante);
					obtenerStringFactura(restaurante);
					printNewPedido = nuevo + "fue agregado al pedido.";
					
					}
				}
				}
			
			else {
			
			
			String nuevo=restaurante.agregarItemAPedido(restaurante2, item_seleccionado);
			obtenerStringFactura(restaurante);
			
			
			if (nuevo!="") {
				
				printNewPedido = nuevo + "fue agregado al pedido.";
				
			}}
			
			System.out.println(printNewPedido);
		}
		
	/*CERRAR Y GUARDAR FACTURA*/
		
		public void cerrarYguardarPedido(Restaurante restautante) throws IOException {
			
			restaurante.cerrarYguardarFactura(restautante);
		}
		
	/*OBTENER FACTURA*/
		
	public void obtenerStringFactura(Restaurante restaurante) {
		
		ArrayList<String> factura=restaurante.FACTURA(restaurante);
		
		System.out.println("_______________________________________");
		System.out.println(".");
		for (int i=0; i<factura.size(); i++){
					
			System.out.println(factura.get(i));
		}	
		System.out.println(".");
		System.out.println("_______________________________________");
		
	}
		
	/*METODO MAIN*/
		
		
		public static void main(String[] args) throws IOException, IngredienteRepetidoException, ProductoRepetidoException, PedidoValorSuperiorException
		{
			Aplicacion consola = new Aplicacion();
			ejecutarCargaryMostrarMenu();
			consola.ejecutarAplicacion();		
		}
		
    /*INPUT*/
		public String input(String mensaje)
		{
			try
			{
				System.out.print(mensaje + ": ");
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				return reader.readLine();
			}
			catch (IOException e)
			{
				System.out.println("Error leyendo de la consola");
				e.printStackTrace();
			}
			return null;
		}
		
	}
	
