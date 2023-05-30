package Pruebas;
import Modelo.Combo;
import Modelo.ProductoMenu;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.ArrayList;

@DisplayName("Pruebas para Combo")

public class ComboPrueba {
    private Combo todoterreno;

    @BeforeEach
    public void setUp() {
        // Crear algunos productos para el combo
        ProductoMenu producto1 = new ProductoMenu("todoterreno", 25000, 858);
        ProductoMenu producto2 = new ProductoMenu("papas grandes", 6900, 500);
        ProductoMenu producto3 = new ProductoMenu("gaseosa", 5000, 41);

        // Crear un combo
        todoterreno = new Combo("todoterreno", 0.10, new ArrayList<>(), 0);

        // Agregar productos al combo
        todoterreno.agregarItemACombo(producto1);
        todoterreno.agregarItemACombo(producto2);
        todoterreno.agregarItemACombo(producto3);
    }

  //Pruebas de métodos
    @Test
    @DisplayName("Pruebas para el método getItems()")
    public void testGetItems() {
    	testAgregarItemACombo();
        ArrayList<ProductoMenu> itemsCombo = todoterreno.getItems();
        assertEquals(4, itemsCombo.size(), "No es correcto, no toma en cuenta los agregados");
    }
  
    @Test
    @DisplayName("Pruebas para el método agregarItemACombo()")
    public void testAgregarItemACombo() {
        ProductoMenu producto4 = new ProductoMenu("helado", 8000, 250);
        todoterreno.agregarItemACombo(producto4);
        ArrayList<ProductoMenu> itemsCombo = todoterreno.getItems();
        assertEquals(4, itemsCombo.size());
        assertEquals(44855, todoterreno.getPrecio(), "No corresponde al precio"); // Precio actualizado con el descuento
        assertEquals(1649, todoterreno.getCalorias(), "No son las calorias totales");
    }
    @Test
    @DisplayName("Pruebas para el método getDescuento()")
    public void testGetDescuento() {
        double descuento = todoterreno.getdescuento();
        assertEquals(0.10, descuento, "El descuento es incorrecto");
    }
    @Test
    @DisplayName("Pruebas para el método GetNombre()")
    public void testGetNombre() {
        String nombreCombo = todoterreno.getNombre();
        assertTrue(nombreCombo.equalsIgnoreCase("todoterreno"), "No es el nombre del combo");
    }
    @Test
    @DisplayName("Pruebas para el método getCalorias()")
    public void testGetCalorias() {
        int calorias = todoterreno.getCalorias();
        assertEquals(1399, calorias, "No corresponde a las calorias esperadas");
    }
    @Test
    @DisplayName("Pruebas para el método getPrecio() y generarTextoFactura()")
    public void testGetPrecioYGenerarTextoFactura() {
       	assertNotNull(todoterreno, "Error: ProductoAjustado no inicializado");
    	testAgregarItemACombo();
        int precio = todoterreno.getPrecio();
        Assertions.assertEquals(44855, precio, "No concuerda el precio");
        String textoFactura = todoterreno.generarTextoFactura();
        String textoFacturaEsperado = "todoterreno---------44855";
        Assertions.assertEquals(textoFacturaEsperado, textoFactura, "No corresponde ni el precio ni texto esperados");
    }
}
