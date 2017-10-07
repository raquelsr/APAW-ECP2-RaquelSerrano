package es.upm.miw.apaw.ecp2.resources.exception;

import static org.junit.Assert.*;

import org.junit.Test;

import es.upm.miw.apaw.ecp2.api.resources.exception.CustomerInvalidException;

public class ExceptionTest {

    @Test
    public void testCustomerInvalidException() {
        assertNotNull(new CustomerInvalidException());
        assertNotNull(new CustomerInvalidException("aa"));
        //assertEquals("Los valores de nombre o dirección no pueden ser nulos. Desc", new CustomerInvalidException("Desc").getMessage());
    }

}
