package es.upm.miw.apaw.ecp2.api.resources.exception;

public class OrderInvalidException extends Exception {

    private static final long serialVersionUID = -5619305602686114060L;

    public static final String DESCRIPTION = "El valor del pedido no pueden ser nulos";

    public OrderInvalidException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public OrderInvalidException() {
        this("");
    }
}
