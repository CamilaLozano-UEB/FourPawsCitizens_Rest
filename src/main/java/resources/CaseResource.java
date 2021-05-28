package resources;

import resources.pojos.cases.Case;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/Pet/{pet_id}/cases")
public class CaseResource {

    /**
     * Creates a new pet case
     *
     * @param pet_id the pet id
     * @param pCase  the case to be created
     * @return the created entity
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("pet_id") Integer pet_id, Case pCase) {

        pCase.setCase_id(3);
        pCase.setPet_id(pet_id);

        return Response.status(Response.Status.CREATED)
                .entity(pCase)
                .build();
    }

}