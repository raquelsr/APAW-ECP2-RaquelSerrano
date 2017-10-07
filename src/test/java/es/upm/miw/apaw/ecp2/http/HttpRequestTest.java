package es.upm.miw.apaw.ecp2.http;

import static org.junit.Assert.*;

import org.junit.Test;

public class HttpRequestTest {

    @Test
    public void testToString() {
        HttpRequest httpRequest = new HttpRequest("path", HttpMethod.GET);
        httpRequest.addQueryParam("key1", "value1");
        httpRequest.addQueryParam("key2", "value2");
        assertEquals(0, httpRequest.toString().indexOf("GET /path?key1=value1&key2=value2"));
    }

    @Test
    public void testIsEqualsPathTrue() {
        HttpRequest httpRequest = new HttpRequest("path/3/path", HttpMethod.GET);
        assertTrue(httpRequest.isEqualsPath("path/{id}/path"));

    }

    @Test
    public void testIsEqualsPathFalseForDistinct() {
        HttpRequest httpRequest = new HttpRequest("path/3/path", HttpMethod.GET);
        assertFalse(httpRequest.isEqualsPath("path2/{id}/path"));
    }

    @Test
    public void testIsEqualsPathFalseForLength() {
        HttpRequest httpRequest = new HttpRequest("path/3/path", HttpMethod.GET);
        assertFalse(httpRequest.isEqualsPath("path/{id}/path/other"));
    }
   
    @Test (expected = HttpException.class)
    public void testClientServiceException() {
        HttpRequest request = new HttpRequest("path/3/path", HttpMethod.GET);
        HttpResponse response = new HttpClientService().httpRequest(request);
        assertNotNull(response);
    }
    
    @Test
    public void testHttpBuilder() {
        assertNotNull(new HttpRequestBuilder());
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path("/customers").body("Paco:Calle Madrid").build();
        assertEquals(HttpMethod.GET, request.getMethod());
        assertEquals("/customers", request.getPath());
        assertNotNull(request.getBody());
        assertNotNull(request.getHeaderParams());
        assertNotNull(request.getParams());
    }
    
    @Test
    public void testHttpBase() {
        HttpBase httpBase = new HttpBase();
        httpBase.addCookie("key1", "A");
        httpBase.addHeaderParam("key1", "B");
        assertNotNull(httpBase.getCookies());
        assertNotNull(httpBase.getHeaderParams());
        assertNull(httpBase.getBody());
    }

    @Test
    public void testServer() {
        Server server = new Server();
        HttpRequest requestPOST = new HttpRequestBuilder().method(HttpMethod.POST).build();
        assertNotNull(server.submit(requestPOST));
        HttpRequest requestPUT = new HttpRequestBuilder().method(HttpMethod.PUT).build();
        assertNotNull(server.submit(requestPUT));
        HttpRequest requestPATCH = new HttpRequestBuilder().method(HttpMethod.PATCH).build();
        assertNotNull(server.submit(requestPATCH));
        HttpRequest requestDELETE = new HttpRequestBuilder().method(HttpMethod.DELETE).build();
        assertNotNull(server.submit(requestDELETE));
    }
}
