package es.upm.miw.apaw.ecp2.api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import es.upm.miw.apaw.ecp2.dao.DaoFactory;
import es.upm.miw.apaw.ecp2.dao.memory.DaoMemoryFactory;
import es.upm.miw.apaw.ecp2.http.HttpClientService;
import es.upm.miw.apaw.ecp2.http.HttpException;
import es.upm.miw.apaw.ecp2.http.HttpMethod;
import es.upm.miw.apaw.ecp2.http.HttpRequest;
import es.upm.miw.apaw.ecp2.http.HttpRequestBuilder;
import es.upm.miw.apaw.ecp2.resource.CustomerResource;

public class CustomerResourceFunctionalTesting {
    
    private HttpRequest request;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        request = new HttpRequest();
    }

    @Test
    public void testCreateCustomer() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(CustomerResource.CUSTOMERS).body("Juan:Calle Francia").build();
        new HttpClientService().httpRequest(request);
    }
    
    @Test(expected = HttpException.class)
    public void testCreateCustomerEmpty() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(CustomerResource.CUSTOMERS).body("").build();
        new HttpClientService().httpRequest(request);
    }

    @Test(expected = HttpException.class)
    public void testCreateWithoutThemeBody() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(CustomerResource.CUSTOMERS).build();
        new HttpClientService().httpRequest(request);
    }

}
