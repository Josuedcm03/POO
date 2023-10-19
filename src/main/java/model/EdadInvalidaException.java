package model;

public class EdadInvalidaException extends Exception {
    public EdadInvalidaException(String message) {
        // super se usa para marcar mensaje de error
        super(message);
    }
}