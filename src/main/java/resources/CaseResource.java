package resources;

import resources.pojos.Case;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/case")
public class CaseResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{pet_id}")
    public Response create(@PathParam("pet_id") Integer pet_id, Case pCase) {

        pCase.setCase_id(3);//toca ver esto

        if (!pCase.getType().equalsIgnoreCase("pérdida") && !pCase.getType().equalsIgnoreCase("perdida")
                && !pCase.getType().equalsIgnoreCase("robo") && !pCase.getType().equalsIgnoreCase("fallecimiento")) {

            return Response.serverError().entity("El tipo de caso " + pCase.getType() + " no está entre las opciones").build();

        } else {
            pCase.setPet_id(pet_id);
            return Response.status(Response.Status.CREATED)
                    .entity(pCase)
                    .build();
        }
    }
}