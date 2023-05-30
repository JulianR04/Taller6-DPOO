package Modelo;

@SuppressWarnings("serial")
public class PedidoValorSuperiorException extends Exception {
    private int precio;

    public PedidoValorSuperiorException(int precio) {
        super("Error valor superior: " + precio);
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
