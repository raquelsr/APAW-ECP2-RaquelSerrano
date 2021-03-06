package es.upm.miw.apaw.ecp2.api;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.ecp2.api.daos.DaoFactory;
import es.upm.miw.apaw.ecp2.api.daos.memory.DaoMemoryFactory;
import es.upm.miw.apaw.ecp2.api.resources.OrderResource;
import es.upm.miw.apaw.ecp2.http.HttpClientService;
import es.upm.miw.apaw.ecp2.http.HttpException;
import es.upm.miw.apaw.ecp2.http.HttpMethod;
import es.upm.miw.apaw.ecp2.http.HttpRequest;
import es.upm.miw.apaw.ecp2.http.HttpRequestBuilder;

public class OrderResourceFunctionalTesting {

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }

    private void createOrder() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(OrderResource.ORDERS).body("7").build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testCreateOrder() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(OrderResource.ORDERS).body("7").build();
        new HttpClientService().httpRequest(request);
    }

    @Test(expected = HttpException.class)
    public void testCreateOrderInvalidAmount() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(OrderResource.ORDERS).body("-7").build();
        new HttpClientService().httpRequest(request);
    }

    @Test(expected = HttpException.class)
    public void testCreateOrderWithoutBody() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(OrderResource.ORDERS).build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testReadListOrders() {
        this.createOrder();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(OrderResource.ORDERS).body("8").build();
        new HttpClientService().httpRequest(request);
        HttpRequest request2 = new HttpRequestBuilder().method(HttpMethod.GET).path(OrderResource.ORDERS).build();
        assertEquals("[{\"id\":1,\"amount\":\"7\"}, {\"id\":2,\"amount\":\"8\"}]", new HttpClientService().httpRequest(request2).getBody());
    }

}
