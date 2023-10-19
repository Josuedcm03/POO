package model;

public class CorreoInvalidoException extends Exception {
    public CorreoInvalidoException(String message) {
        // super se usa para marcar mensaje de error
        super(message);
    }
}