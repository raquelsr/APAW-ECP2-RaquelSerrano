package es.upm.miw.apaw.ecp2.api.resources.exception;

public class CustomerIdInvalidException extends Exception {

    private static final long serialVersionUID = -1114229143403477951L;

    public static final String DESCRIPTION = "El id no es correcto";

    public CustomerIdInvalidException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public CustomerIdInvalidException() {
        this("");
    }
}
