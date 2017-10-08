package es.upm.miw.apaw.ecp2.resources.exception;

import static org.junit.Assert.*;

import org.junit.Test;

import es.upm.miw.apaw.ecp2.api.resources.exception.BodyEmptyException;
import es.upm.miw.apaw.ecp2.api.resources.exception.CustomerIdInvalidException;
import es.upm.miw.apaw.ecp2.api.resources.exception.CustomerIdNotFoundException;
import es.upm.miw.apaw.ecp2.api.resources.exception.CustomerInvalidException;
import es.upm.miw.apaw.ecp2.api.resources.exception.OrderIdNotFoundException;
import es.upm.miw.apaw.ecp2.api.resources.exception.OrderInvalidException;
import es.upm.miw.apaw.ecp2.api.resources.exception.RequestInvalidException;

public class ExceptionTest {

    @Test
    public void testCustomerInvalidException() {
        assertNotNull(new CustomerInvalidException());
        assertNotNull(new CustomerInvalidException("test"));
    }
    
    @Test
    public void testCustomerIdNotFoundException() {
        assertNotNull(new CustomerIdNotFoundException());
        assertNotNull(new CustomerIdNotFoundException("test"));
    }
    
    
    @Test
    public void testCustomerIdInvalidException() {
        assertNotNull(new CustomerIdInvalidException());
        assertNotNull(new CustomerIdInvalidException("test"));
    }
    
    @Test
    public void testBodyEmptyException() {
        assertNotNull(new BodyEmptyException());
        assertNotNull(new BodyEmptyException("test"));
    }

    
    @Test
    public void testOrderIdNotFoundException() {
        assertNotNull(new OrderIdNotFoundException());
        assertNotNull(new OrderIdNotFoundException("test"));
    }
    
    
    @Test
    public void testOrderInvalidException() {
        assertNotNull(new OrderInvalidException());
        assertNotNull(new OrderInvalidException("test"));
    }
    
    
    @Test
    public void testRequestInvalidException() {
        assertNotNull(new RequestInvalidException());
        assertNotNull(new RequestInvalidException("test"));
    }

}
