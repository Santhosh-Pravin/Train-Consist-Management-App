package model;

/**
 * Custom Runtime Exception for unsafe cargo assignment
 */
public class CargoSafetyException extends RuntimeException {

    public CargoSafetyException(String message) {
        super(message);
    }
}