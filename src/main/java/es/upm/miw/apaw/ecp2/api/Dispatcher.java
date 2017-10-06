package es.upm.miw.apaw.ecp2.api;

import es.upm.miw.apaw.ecp2.api.resources.CustomerResource;
import es.upm.miw.apaw.ecp2.api.resources.exception.CustomerInvalidException;
import es.upm.miw.apaw.ecp2.api.resources.exception.RequestInvalidException;
import es.upm.miw.apaw.ecp2.http.HttpRequest;
import es.upm.miw.apaw.ecp2.http.HttpResponse;
import es.upm.miw.apaw.ecp2.http.HttpStatus;

public class Dispatcher {

    private CustomerResource customerResource = new CustomerResource();

    private void responseError(HttpResponse response, Exception e) {
        response.setBody("{\"error\":\"" + e + "\"}");
        response.setStatus(HttpStatus.BAD_REQUEST);
    }

    public void doGet(HttpRequest request, HttpResponse response) {
        try {
            if (request.isEqualsPath(CustomerResource.CUSTOMERS + CustomerResource.ID)) {
                response.setBody(customerResource.readCustomer(Integer.valueOf(request.paths()[1])).toString());
            } else {
                throw new RequestInvalidException(request.getPath());
            }
        } catch (Exception e) {
            responseError(response, e);
        }
    }

    public void doPost(HttpRequest request, HttpResponse response) {
        try {
            if (request.isEqualsPath(CustomerResource.CUSTOMERS)) {
                if ((request.getBody() == null) || (request.getBody().split(":").length < 2)) {
                    throw new CustomerInvalidException();
                } else {
                    String customerName = request.getBody().split(":")[0];
                    String customerAddress = request.getBody().split(":")[1];
                    customerResource.createCustomer(customerName, customerAddress);
                    response.setStatus(HttpStatus.CREATED);
                }
            } else {
                throw new RequestInvalidException(request.getPath());
            }
        } catch (Exception e) {
            responseError(response, e);
        }

    }

    public void doPut(HttpRequest request, HttpResponse response) {
        // TODO Auto-generated method stub

    }

    public void doPatch(HttpRequest request, HttpResponse response) {
        // TODO Auto-generated method stub

    }

    public void doDelete(HttpRequest request, HttpResponse response) {
        // TODO Auto-generated method stub

    }

}
