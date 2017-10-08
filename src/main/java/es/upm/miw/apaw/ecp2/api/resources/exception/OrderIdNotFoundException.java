package es.upm.miw.apaw.ecp2.api.resources.exception;

public class OrderIdNotFoundException extends Exception {

    private static final long serialVersionUID = 7132866980191097812L;
    public static final String DESCRIPTION = "El id del pedido no existe";

    public OrderIdNotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public OrderIdNotFoundException() {
        this("");
    } 
}
