package es.upm.miw.apaw.ecp2.api.resources.exception;

public class RequestInvalidException extends Exception {

    private static final long serialVersionUID = -8698774560911281339L;

    public static final String DESCRIPTION = "Petición no implementada";

    public RequestInvalidException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public RequestInvalidException() {
        this("");
    }

}
