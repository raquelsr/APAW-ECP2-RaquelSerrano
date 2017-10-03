package es.upm.miw.apaw.ecp2.api;

import es.upm.miw.apaw.ecp2.http.HttpRequest;
import es.upm.miw.apaw.ecp2.http.HttpResponse;
import es.upm.miw.apaw.ecp2.resource.CustomerResource;
import es.upm.miw.apaw.ecp2.resource.exception.RequestInvalidException;
import es.upm.miw.apaw.ecp2.http.HttpStatus;

public class Dispatcher {
    
    private CustomerResource customerResource = new CustomerResource();
    
    private void responseError(HttpResponse response, Exception e) {
        response.setBody("{\"error\":\"" + e + "\"}");
        response.setStatus(HttpStatus.BAD_REQUEST);
    }
    
    public void doGet(HttpRequest request, HttpResponse response) {
        // TODO Auto-generated method stub
        
    }

    public void doPost(HttpRequest request, HttpResponse response) {
        try {
            if (request.isEqualsPath(CustomerResource.CUSTOMERS)) {
                customerResource.createCustomer(request.getBody());
                response.setStatus(HttpStatus.CREATED);
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
