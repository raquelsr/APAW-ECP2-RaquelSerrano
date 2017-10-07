package es.upm.miw.apaw.ecp2.api.resources.exception;

public class CustomerIdNotFoundException extends Exception {

    private static final long serialVersionUID = 3996602627128914280L;
    public static final String DESCRIPTION = "El id del cliente no existe";

    public CustomerIdNotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public CustomerIdNotFoundException() {
        this("");
    }
}
