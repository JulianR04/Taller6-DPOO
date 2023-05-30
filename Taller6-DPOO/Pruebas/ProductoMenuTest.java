package Pruebas;

import static org.junit.jupiter.api.Assertions.*;
import Modelo.ProductoMenu;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Pruebas para clase ProductoMenu")

public class ProductoMenuTest {
	
	    
	 	private ProductoMenu producto;	 	
	    @BeforeEach
	    public void setUp() {
	        producto = new ProductoMenu("Hamburguesa", 14000, 546);
	    }
	    @Test
	    @DisplayName("Pruebas para el método getNombre()")
	    public void testGetNombre() {
	    	assertNotNull(producto, "Error: Producto no inicializado");
	        assertEquals("Hamburguesa", producto.getNombre(), "El nombre del producto no corresponde");
	    }
	    @Test
	    @DisplayName("Pruebas para el método getPrecio())")
	    public void testGetPrecio() {
	    	assertNotNull(producto, "Error: Producto no inicializado");
	        assertEquals(14000, producto.getPrecio(), "El precio no corresponde");
	    }
	    @ParameterizedTest
	    @CsvSource({ "Hamburguesa, 600", "Gaseosa, 100", "Pizza, 800" })
	    @DisplayName("Pruebas para el método getCalorias()")
	    public void testGetCalorias(String nombre, int calorias) {
	    	assertNotNull(producto, "Error: Producto no inicializado");
	        producto.setNombre(nombre);
	        producto.setCalorias(calorias);
	        
	        if (producto.getNombre().equalsIgnoreCase(nombre)) {
	            assertEquals(calorias, producto.getCalorias(), "Las calorías no corresponden al producto.");
	        } else {
	            fail("El producto no es " + nombre + ".");
	        }
	    }
	    @Test
	    @DisplayName("Pruebas para el método generarTextoFactura()")
	    
	    public void testGenerarTextoFactura() {
	    	assertNotNull(producto, "Error: Producto no inicializado");
	    	String factura = producto.generarTextoFactura();
	    	boolean condicion = factura.equals("Hamburguesa---------14000");
	        assertTrue(condicion , "El texto no se generó correctamente porque la información no corresponde");
	    }
	}