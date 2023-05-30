package Modelo;

@SuppressWarnings("serial")

public class IngredienteRepetidoException extends HamburguesaException{
    private String ingredienteRepetido;

    public IngredienteRepetidoException(String ingredienteRepetido) {
        super("Error: Ingrediente repetido - " + ingredienteRepetido);
        this.ingredienteRepetido = ingredienteRepetido;
    }

    public String getIngredienteRepetido() {
        return ingredienteRepetido;
    }
}