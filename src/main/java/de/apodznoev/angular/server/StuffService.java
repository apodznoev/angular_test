package de.apodznoev.angular.server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.TEXT_HTML;

/**
 * Created by apodznoev
 * date 17.01.2017.
 */
@Path("/api/v1/stuff")
public interface StuffService {

    @GET
    @Produces(TEXT_HTML)
    String getAll();

    @GET
    @Path("{id}")
    @Produces(TEXT_HTML)
    String getById(@PathParam("id") String id);

}