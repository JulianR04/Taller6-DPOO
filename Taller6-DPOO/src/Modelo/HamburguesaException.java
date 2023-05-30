package Modelo;

@SuppressWarnings("serial")
public abstract class HamburguesaException extends Exception {
    public HamburguesaException(String mensaje) {
        super(mensaje);
    }
}