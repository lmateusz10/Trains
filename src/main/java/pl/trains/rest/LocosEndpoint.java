package pl.trains.rest;

import pl.trains.model.Loco;
import pl.trains.model.Train;
import pl.trains.services.LocoService;
import pl.trains.services.TrainsService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by mateusz on 18.04.17.
 */
@Path("/locos")
@RequestScoped
public class LocosEndpoint {
    @Inject
    LocoService locoService;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        return Response.ok().entity(locoService.getAllLocos()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLocoById(@PathParam("id") Long id){
        if (locoService.getLocoById(id)!=null){
            return Response.ok().entity(locoService.getLocoById(id)).build();
        }
        else
            return Response.status(404).build();

    }


    @POST
    @Path("/addloco")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addLoco(Loco loco){
        locoService.addLoco(loco);
        return Response.status(200).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeLocoById(@PathParam("id") Long id){
        System.out.println("AAAAAA" + id);

        locoService.removeLocoById(id);
        return Response.ok().build();
        }
}
