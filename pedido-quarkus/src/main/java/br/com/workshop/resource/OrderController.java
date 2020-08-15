package br.com.workshop.resource;

import br.com.workshop.model.entity.Order;
import br.com.workshop.model.vo.ErrorMessageDefault;
import br.com.workshop.model.vo.OrderAmountOnlyVO;
import org.bson.types.ObjectId;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

@Path("/order")
public class OrderController {

    /*
     * Listando tudo
     * */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response allOrder(@QueryParam("page") int page, @QueryParam("pageSize") int pageSize) {
        if (pageSize == 0) pageSize = 2;
        return Response.ok(Order.findAll().page(page, pageSize).list()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") ObjectId id) {
        Order order = Order.findById(id);
        return Response.ok(order).build();
    }

    @GET
    @Path("/client/{client}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByClient(@PathParam("client") String cliente,
                                 @QueryParam("page") int page,
                                 @QueryParam("pageSize") int pageSize) {
        if (pageSize == 0) pageSize = 2;
        return Response.ok(Order.find("client", cliente).page(page, pageSize).list()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Order order) {
        if (Order.find("client = ?1 and product = ?2", order.getClient(), order.getProduct()).count() > 0) {
            return Response.status(BAD_REQUEST).entity(new ErrorMessageDefault("Bad Request", 44)).build();
        }

        order.persist();
        return Response.ok().build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(Order order) {
        Order.update(order);
        return Response.ok().build();
    }

    @PATCH
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizarParcial(@PathParam("id") ObjectId id, OrderAmountOnlyVO amountVo) {
        Order order = Order.findById(id);
        order.setAmount(amountVo.amount);
        order.persistOrUpdate();
        return Response.ok(order).build();
    }

    @DELETE
    @Path("/{id}")
    public Response atualizarParcial(@PathParam("id") ObjectId id) {
        Order.deleteById(id);
        return Response.ok().build();
    }


}