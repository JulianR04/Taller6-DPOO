package Modelo;

@SuppressWarnings("serial")
public class ProductoRepetidoException extends HamburguesaException{
    private String productoRepetido;

    public ProductoRepetidoException(String productoRepetido) {
        super("Error: Producto repetido - " + productoRepetido);
        this.productoRepetido = productoRepetido;
    }

    public String getProductoRepetido() {
        return productoRepetido;
    }
}