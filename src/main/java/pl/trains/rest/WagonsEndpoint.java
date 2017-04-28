package pl.trains.rest;

import pl.trains.model.*;
import pl.trains.services.LocoService;
import pl.trains.services.WagonsService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mateusz on 19.04.17.
 */
@Path("/wagons")
@RequestScoped
public class WagonsEndpoint {
    @Inject
    WagonsService wagonsService;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        return Response.ok().entity(wagonsService.getAllWagons()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getWagonById(@PathParam("id") Long id){

        Wagon wagon = wagonsService.getWagonById(1L);
        if (wagon!=null){
            return Response.ok().entity(wagonsService.getWagonById(id)).build();
        }
        else
            return Response.status(404).build();
    }

    @GET
    @Path("/getwagonbyanything/{anything}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getWagonByAnything(@PathParam("anything") String anything){
        List<Wagon> wagonList = wagonsService.getWagonByAnything(anything);
        if (!wagonList.isEmpty()){
            return Response.ok().entity(wagonList).build();
        }
        else
            return Response.noContent().build();
    }


    @POST
    @Path("/addwagon")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addLoco(Wagon wagon){
        wagonsService.addWagon(wagon);
        return Response.status(200).build();
    }

/*    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeLocoById(@PathParam("id") Long id){
        wagonsService.removeWagonById(id);
        return Response.ok().build();
    }*/
}
