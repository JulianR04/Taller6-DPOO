package Pruebas;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import Procesamiento.Producto;
import Modelo.Ingrediente;

import Modelo.ProductoAjustado;

@SuppressWarnings("unused")
@DisplayName("Pruebas para clase ProductoAjustado")

class ProductoAjustadoTest {
	
	//Atributos
	private ProductoAjustado producto;		
    @BeforeEach
    public void setUp() {    
        String nombre = "Corral";
        int precio = 14000;
        ArrayList<Ingrediente> agregados = new ArrayList<>();
        ArrayList<Ingrediente> eliminados = new ArrayList<>();
        int calorias = 0;

        producto = new ProductoAjustado(nombre, precio, agregados, eliminados, calorias);
    }
    
  //Pruebas

    @Test
    @DisplayName("Pruebas para el método getPrecio() y generarTextoFactura()")
    public void testGetPrecioYGenerarTextoFactura() {
       
    	assertNotNull(producto, "Error: ProductoAjustado no inicializado");
        testAgregar();

        int precio = producto.getPrecio();
        Assertions.assertEquals(15000, precio);
        String textoFactura = producto.generarTextoFactura();
        String textoFacturaEsperado = "Corral. adicion de.cebolla---------15000";
        Assertions.assertEquals(textoFacturaEsperado, textoFactura, "No corresponde ni el precio ni texto esperados");
    }


    @Test
    @DisplayName("Pruebas para el método agregar()")
    public void testAgregar() {
    	assertNotNull(producto, "Error: ProductoAjustado no inicializado");
        Ingrediente ingrediente = new Ingrediente("cebolla", 1000, 40);
        
        boolean ingredienteAgregado = false;
        for (int i = 0; i < producto.getAgregados().size(); i++) {
            if (producto.getAgregados().get(i).getNombre().equals(ingrediente.getNombre())) {
                ingredienteAgregado = true;
                break; 
            }
        }
        if (ingredienteAgregado) {
            fail("El producto ya está agregado");
        } else {
            producto.agregar(ingrediente);
        }

        Assertions.assertEquals(15000, producto.getPrecio());
        Assertions.assertEquals(40, producto.getCalorias());
    }

    
 
    @Test
    @DisplayName("Pruebas para el método quitar()")
    public void testQuitar() {
    	assertNotNull(producto, "Error: ProductoAjustado no inicializado");
       
        Ingrediente ingrediente = new Ingrediente("cebolla", 1000, 40);        
        boolean ingredienteEliminado = false;
        for (int i = 0; i < producto.getAgregados().size(); i++) {
            if (producto.getAgregados().get(i).getNombre().equals(ingrediente.getNombre())) {
                ingredienteEliminado = true;
                break;
            }
        }
        
        if (ingredienteEliminado) {
            fail("El producto ya está eliminado");
        } else {
            producto.quitar(ingrediente);
        }

        String nombreEsperado = "Corral. sin.cebolla";
        Assertions.assertEquals(nombreEsperado, producto.getNombre());
    }

}