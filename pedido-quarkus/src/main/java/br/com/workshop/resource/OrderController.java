package br.com.workshop.resource;

import br.com.workshop.model.entity.Order;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/order")
public class OrderController {

    /*
    * Listando tudo
    * */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response allOrder() {
        return Response.ok(Order.findAll().list()).build();
    }
}