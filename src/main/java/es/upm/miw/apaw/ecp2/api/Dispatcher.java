package es.upm.miw.apaw.ecp2.api;

import es.upm.miw.apaw.ecp2.api.resources.CustomerResource;
import es.upm.miw.apaw.ecp2.api.resources.OrderResource;
import es.upm.miw.apaw.ecp2.api.resources.exception.BodyEmptyException;
import es.upm.miw.apaw.ecp2.api.resources.exception.CustomerInvalidException;
import es.upm.miw.apaw.ecp2.api.resources.exception.RequestInvalidException;
import es.upm.miw.apaw.ecp2.http.HttpRequest;
import es.upm.miw.apaw.ecp2.http.HttpResponse;
import es.upm.miw.apaw.ecp2.http.HttpStatus;

public class Dispatcher {

    private CustomerResource customerResource = new CustomerResource();

    private OrderResource orderResource = new OrderResource();

    private void responseError(HttpResponse response, Exception e) {
        response.setBody("{\"error\":\"" + e + "\"}");
        response.setStatus(HttpStatus.BAD_REQUEST);
    }

    public void doGet(HttpRequest request, HttpResponse response) {
        try {
            if (request.isEqualsPath(CustomerResource.CUSTOMERS + CustomerResource.ID)) {
                response.setBody(customerResource.readCustomer(Integer.valueOf(request.paths()[1])).toString());
            } else if (request.isEqualsPath(CustomerResource.CUSTOMERS + CustomerResource.ID + CustomerResource.ORDERS)) {
                response.setBody(customerResource.readCustomerOrderList(Integer.valueOf(request.paths()[1])).toString());
            } else if (request.isEqualsPath(OrderResource.ORDERS)) {
                response.setBody(orderResource.readListOrders().toString());
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
                if (request.getBody() == null) {
                    throw new BodyEmptyException();
                } else if (request.getBody().split(":").length < 2) {
                    throw new CustomerInvalidException();
                } else {
                    String[] split = request.getBody().split(":");
                    String customerName = split[0];
                    String customerAddress = split[1];
                    if (split.length == 3) {
                        int orderId = Integer.parseInt(split[2]);
                        customerResource.createCustomerOrder(customerName, customerAddress, orderId);
                    } else {
                        customerResource.createCustomer(customerName, customerAddress);
                    }
                    response.setStatus(HttpStatus.CREATED);
                }
            } else if (request.isEqualsPath(OrderResource.ORDERS)) {
                if (request.getBody() == null) {
                    throw new BodyEmptyException();
                } else {
                    String amountOrder = request.getBody();
                    orderResource.createOrder(Double.valueOf(amountOrder));
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
        responseError(response, new RequestInvalidException(request.getPath()));
    }

    public void doPatch(HttpRequest request, HttpResponse response) {
        try {
            if (request.isEqualsPath(CustomerResource.CUSTOMERS + CustomerResource.ID)) {
                if (request.getBody() == null) {
                    throw new BodyEmptyException();
                } else {
                    customerResource.updateCustomer(Integer.valueOf(request.paths()[1]) , request.getBody());
                    response.setBody(customerResource.readCustomer(Integer.valueOf(request.paths()[1])).toString());
                }
            } else {
                throw new RequestInvalidException(request.getPath());
            }
        } catch (Exception e) {
            responseError(response, e);
        }
    }

    public void doDelete(HttpRequest request, HttpResponse response) {
        try {
            if (request.isEqualsPath(CustomerResource.CUSTOMERS + CustomerResource.ID)) {
                int id = Integer.parseInt(request.paths()[1]);
                this.customerResource.deleteCustomer(id);
                response.setStatus(HttpStatus.NO_CONTENT);
            } else {
                throw new RequestInvalidException(request.getPath());
            }
        } catch (Exception e) {
            responseError(response, e);
        }
    }

}
