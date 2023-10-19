package model;

public class NombreInvalidoException extends Exception {
    public NombreInvalidoException(String message) {
        // super se usa para marcar mensaje de error
        super(message);
    }
}