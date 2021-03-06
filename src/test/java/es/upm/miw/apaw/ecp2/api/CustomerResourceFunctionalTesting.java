package es.upm.miw.apaw.ecp2.api;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.ecp2.api.daos.DaoFactory;
import es.upm.miw.apaw.ecp2.api.daos.memory.DaoMemoryFactory;
import es.upm.miw.apaw.ecp2.api.resources.CustomerResource;
import es.upm.miw.apaw.ecp2.api.resources.OrderResource;
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

    private void createOrder() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(OrderResource.ORDERS).body("7").build();
        new HttpClientService().httpRequest(request);
    }

    private void createCustomer() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(CustomerResource.CUSTOMERS).body("Paco:Calle Francia")
                .build();
        new HttpClientService().httpRequest(request);
    }

    private void createCustomerWithOrder() {
        this.createOrder();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(CustomerResource.CUSTOMERS).body("Juan:Calle Francia:1")
                .build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testCreateCustomer() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(CustomerResource.CUSTOMERS).body("Juan:Calle Francia")
                .build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testCreateCustomerOrder() {
        this.createOrder();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(CustomerResource.CUSTOMERS).body("Juan:Calle Francia:1")
                .build();
        new HttpClientService().httpRequest(request);
    }
    
    @Test(expected = HttpException.class)
    public void testCreateCustomerIdOrderNotFound() {
        this.createOrder();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(CustomerResource.CUSTOMERS).body("Juan:Calle Francia:9")
                .build();
        new HttpClientService().httpRequest(request);
    }

    @Test(expected = HttpException.class)
    public void testCreateCustomerEmpty() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(CustomerResource.CUSTOMERS).body("").build();
        new HttpClientService().httpRequest(request);
    }

    @Test(expected = HttpException.class)
    public void testCreateCustomerWithoutBody() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(CustomerResource.CUSTOMERS).build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testReadCustomer() {
        this.createCustomer();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(CustomerResource.CUSTOMERS).path(CustomerResource.ID)
                .expandPath("1").build();
        assertEquals("{\"id\":1,\"name\":\"Paco\",\"address\":\"Calle Francia\"}", new HttpClientService().httpRequest(request).getBody());

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
                .expandPath("-9").build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testReadCustomerOrder() {
        this.createCustomerWithOrder();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(CustomerResource.CUSTOMERS).path(CustomerResource.ID)
                .expandPath("1").path(CustomerResource.ORDERS).build();
        assertEquals("{\"pedidos\":[1]}", new HttpClientService().httpRequest(request).getBody());

    }
    
    @Test(expected = HttpException.class)
    public void testReadCustomerOrderIdNotFoundException() {
        this.createCustomer();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(CustomerResource.CUSTOMERS).path(CustomerResource.ID)
                .expandPath("8").build();
        new HttpClientService().httpRequest(request);
    }
    
    @Test(expected = HttpException.class)
    public void testReadCustomerOrderIdInvalid() {
        this.createCustomerWithOrder();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(CustomerResource.CUSTOMERS).path(CustomerResource.ID)
                .expandPath("-1").path(CustomerResource.ORDERS).build();
        new HttpClientService().httpRequest(request);
    }
    
    @Test
    public void testDeleteCustomer() {
        this.createCustomer();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.DELETE).path(CustomerResource.CUSTOMERS).path(CustomerResource.ID)
                .expandPath("1").build();
        new HttpClientService().httpRequest(request);
    }

    @Test(expected = HttpException.class)
    public void testDeleteCustomerIdInvalidException() {
        this.createCustomer();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.DELETE).path(CustomerResource.CUSTOMERS).path(CustomerResource.ID)
                .expandPath("-3").build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testPatchCustomer() {
        this.createCustomer();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.PATCH).path(CustomerResource.CUSTOMERS).path(CustomerResource.ID)
                .expandPath("1").body("Calle Madrid").build();
        assertEquals("{\"id\":1,\"name\":\"Paco\",\"address\":\"Calle Madrid\"}", new HttpClientService().httpRequest(request).getBody());
    }


    
    @Test(expected = HttpException.class)
    public void testPatchCustomerIdInvalidException() {
        this.createCustomer();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.PATCH).path(CustomerResource.CUSTOMERS).path(CustomerResource.ID)
                .expandPath("-1").body("Calle Madrid").build();
        new HttpClientService().httpRequest(request);
    }

    @Test(expected = HttpException.class)
    public void testPatchWithoutCustomerBody() {
        this.createCustomer();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.PATCH).path(CustomerResource.CUSTOMERS).path(CustomerResource.ID)
                .expandPath("1").build();
        new HttpClientService().httpRequest(request);
    }
    
    @Test(expected = HttpException.class)
    public void testPutCustomerRequestInvalid() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.PUT).path(CustomerResource.CUSTOMERS).path(CustomerResource.ID)
                .expandPath("1").build();
        new HttpClientService().httpRequest(request);
    }
}
