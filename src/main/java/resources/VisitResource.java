package resources;

import resources.pojos.pets.Pet;
import resources.pojos.visit.Visit;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/vet/{vet_id}/pet/{pet_id}/visit")
public class VisitResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("vet_id") Integer vet_id, @PathParam("pet_id") Integer pet_id, Visit visit) {

        visit.setVet_id(vet_id);
        visit.setPet_id(pet_id);
        visit.setVisit_id(3);

        return Response.status(Response.Status.CREATED)
                .entity(visit)
                .build();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{microchip}")
    public Response create(@PathParam("vet_id") Integer vet_id, @PathParam("pet_id") Integer pet_id,
                           @PathParam("microchip") Long microchip, Visit visit) {

        Pet pet = new Pet(pet_id, microchip, "Loky", "Canino", "Golden", "mediano", "macho",
                "golden,jpg", "SilenceCam");

        visit.setVet_id(vet_id);
        visit.setPet_id(pet_id);
        visit.setVisit_id(3);

        return Response.status(Response.Status.CREATED)
                .entity(visit)
                .build();

    }


}