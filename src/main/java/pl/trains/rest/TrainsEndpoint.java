package pl.trains.rest;

import pl.trains.model.Train;
import pl.trains.services.TrainsService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Mateusz on 23.04.2017.
 */

@Path("/trains")
public class TrainsEndpoint {
    @Inject
    TrainsService trainsService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        return Response.ok().entity(trainsService.getAllTrains()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTrainById(@PathParam("id") Long id){
        if(trainsService.getTrainById(id) != null){
            return Response.ok().entity(trainsService.getTrainById(id)).build();
        }
        else
            return Response.status(404).build();
    }

    @GET
    @Path("/getbyname/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTrainByName(@PathParam("name") String name){
        List<Train> trainList = trainsService.getTrainByName(name);
        for (Train train:trainList) {
            System.out.println(train.getId() + " " + train.getWagons().toString());
        }
        if(!trainList.isEmpty()){
            return Response.ok().entity(trainList).build();
        }
        else
            return Response.noContent().build();
    }
    @POST
    @Path("/addtrain")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addTrain(Train train){
        trainsService.addTrain(train);
        return Response.ok().build();
    }


}
