package es.upm.miw.apaw.ecp2.api;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.ecp2.api.daos.DaoFactory;
import es.upm.miw.apaw.ecp2.api.daos.memory.DaoMemoryFactory;
import es.upm.miw.apaw.ecp2.api.resources.CustomerResource;
import es.upm.miw.apaw.ecp2.api.resources.exception.CustomerInvalidException;
import es.upm.miw.apaw.ecp2.http.HttpClientService;
import es.upm.miw.apaw.ecp2.http.HttpException;
import es.upm.miw.apaw.ecp2.http.HttpMethod;
import es.upm.miw.apaw.ecp2.http.HttpRequest;
import es.upm.miw.apaw.ecp2.http.HttpRequestBuilder;

public class CustomerResourceFunctionalTesting {

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }

    private void createCustomer() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(CustomerResource.CUSTOMERS).body("Paco:Calle Francia").build();
        new HttpClientService().httpRequest(request);
    }
    
    @Test
    public void testCreateCustomer() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(CustomerResource.CUSTOMERS).body("Juan:Calle Francia")
                .build();
        new HttpClientService().httpRequest(request);
    }

    @Test(expected = HttpException.class)
    public void testCreateCustomerEmpty() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(CustomerResource.CUSTOMERS).body("").build();
        new HttpClientService().httpRequest(request);
    }

    @Test(expected = HttpException.class)
    public void testCreateWithoutCustomerBody() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(CustomerResource.CUSTOMERS).build();
        new HttpClientService().httpRequest(request);
    }
    
    @Test
    public void testReadCustomer() {
        this.createCustomer();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(CustomerResource.CUSTOMERS).path(CustomerResource.ID)
                .expandPath("1").build();
        assertEquals("{\"id\":1,\"name\":\"Paco,\"address\":\"Calle Francia\"}", new HttpClientService().httpRequest(request).getBody());

    }
    
    @Test(expected = HttpException.class)
    public void testReadCustomerIdNotFoundException() {
        this.createCustomer();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(CustomerResource.CUSTOMERS).path(CustomerResource.ID)
                .expandPath("4").build();
        new HttpClientService().httpRequest(request);
    }
    
    @Test(expected = HttpException.class)
    public void testReadCustomerIdInvalidException() {
        this.createCustomer();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(CustomerResource.CUSTOMERS).path(CustomerResource.ID)
                .expandPath("-1").build();
        new HttpClientService().httpRequest(request);
    }
    
    @Test
    public void testDeleteCustomer() {
         this.createCustomer();
         HttpRequest request = new HttpRequestBuilder().method(HttpMethod.DELETE).path(CustomerResource.CUSTOMERS).path(CustomerResource.ID)
                 .expandPath("1").build();
         new HttpClientService().httpRequest(request);
    }
    
    
    @Test
    public void testDeleteCustomerIdNotFoundException() {
         this.createCustomer();
         HttpRequest request = new HttpRequestBuilder().method(HttpMethod.DELETE).path(CustomerResource.CUSTOMERS).path(CustomerResource.ID)
                 .expandPath("2").build();
         new HttpClientService().httpRequest(request);
    }

}
