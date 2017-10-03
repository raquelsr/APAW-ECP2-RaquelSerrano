package es.upm.miw.apaw.ecp2.api;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.ecp2.api.daos.DaoFactory;
import es.upm.miw.apaw.ecp2.api.daos.memory.DaoMemoryFactory;
import es.upm.miw.apaw.ecp2.api.resources.CustomerResource;
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

}
