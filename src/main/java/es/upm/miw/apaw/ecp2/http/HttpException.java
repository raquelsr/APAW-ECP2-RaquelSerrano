package es.upm.miw.apaw.ecp2.http;

public class HttpException extends RuntimeException {
    private static final long serialVersionUID = 7271728903247259709L;

    public HttpException(String msg) {
        super(msg);
    }

}
