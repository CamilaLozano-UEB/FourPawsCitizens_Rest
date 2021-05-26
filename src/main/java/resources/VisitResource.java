package resources;

import resources.pojos.Case;
import resources.pojos.Visit;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/visit")
public class VisitResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{vet_id}/{pet_id}")
    public Response create(@PathParam("vet_id") Integer vet_id, @PathParam("pet_id") Integer pet_id, Visit visit) {

        visit.setVisit_id(3);//toca ver esto

        if (!visit.getType().equalsIgnoreCase("esterilización")
                && !visit.getType().equalsIgnoreCase("implantación ")
                && !visit.getType().equalsIgnoreCase("vacunación")
                && !visit.getType().equalsIgnoreCase("desparasitación")
                && !visit.getType().equalsIgnoreCase("urgencia ")
                && !visit.getType().equalsIgnoreCase("control")) {

            return Response.serverError().entity("El tipo de visita " + visit.getType() +
                    " no está entre las opciones").build();
        } else {
            visit.setVet_id(vet_id);
            visit.setPet_id(pet_id);
            return Response.status(Response.Status.CREATED)
                    .entity(visit)
                    .build();
        }
    }
}