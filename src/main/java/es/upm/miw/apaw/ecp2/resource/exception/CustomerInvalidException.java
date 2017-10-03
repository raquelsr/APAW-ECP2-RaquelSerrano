package es.upm.miw.apaw.ecp2.resource.exception;

public class CustomerInvalidException extends Exception {

    private static final long serialVersionUID = -1114229143403477951L;

    public static final String DESCRIPTION = "Los valores de nombre o dirección no pueden ser nulos";

    public CustomerInvalidException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public CustomerInvalidException() {
        this("");
    }
}
