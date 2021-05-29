package resources;

import resources.pojos.pets.Pet;
import resources.pojos.visit.Visit;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/vet/{vet_id}/pet/{pet_id}/visits")
public class VisitResource {

    /**
     * Method that creates a new visit
     *
     * @param vet_id the vet id
     * @param pet_id the pet id
     * @param visit  a visit objet to be created
     * @return A response with the object created
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("vet_id") Integer vet_id, @PathParam("pet_id") Integer pet_id, Visit visit) {

        if (visit.getType().equalsIgnoreCase("implantación de microchip") && visit.getMicrochip() == null) {
            return Response.status(Response.Status.FORBIDDEN)
                    .entity("La opción de implantación de microchip requiere que este sea especificado!!!")
                    .build();

        } else if (!visit.getType().equalsIgnoreCase("implantación de microchip") && visit.getMicrochip() != null) {
            return Response.status(Response.Status.FORBIDDEN)
                    .entity("La opción " + visit.getType() + " no tiene permitido el campo microchip!!!")
                    .build();

        } else if (visit.getType().equalsIgnoreCase("implantación de microchip") && visit.getMicrochip() != null) {

            visit.setVet_id(vet_id);
            visit.setPet_id(pet_id);
            visit.setVisit_id(3);

            Pet pet = new Pet(pet_id, visit.getMicrochip(), "Loky", "Canino", "Golden", "mediano", "macho",
                    "golden,jpg", "SilenceCam");

            return Response.status(Response.Status.CREATED)
                    .entity(visit)
                    .build();
        } else {

            return Response.status(Response.Status.CREATED)
                    .entity(visit)
                    .build();
        }
    }
}