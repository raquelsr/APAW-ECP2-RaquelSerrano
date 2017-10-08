package es.upm.miw.apaw.ecp2.api.resources.exception;
 
public class BodyEmptyException extends Exception {

    private static final long serialVersionUID = 7746806702831850210L;
    
    public static final String DESCRIPTION = "El cuerpo de la petición no puede estar vacío";

    public BodyEmptyException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public BodyEmptyException() {
        this("");
    }
}
