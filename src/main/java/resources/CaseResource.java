package resources;

import resources.pojos.Case;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/case")
public class CaseResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{pet_id}")
    public Response create(@PathParam("pet_id") Integer pet_id, Case pCase) {

        if (!pCase.getType().equalsIgnoreCase("pérdida") && !pCase.getType().equalsIgnoreCase("perdida")
                && !pCase.getType().equalsIgnoreCase("robo") && !pCase.getType().equalsIgnoreCase("fallecimiento")) {

            return Response.serverError().entity("El tipo de caso " + pCase.getType() + " no está entre las opciones").build();

        } else {
            pCase.setCase_id(3);//toca ver esto
            pCase.setPet_id(pet_id);
            return Response.status(Response.Status.CREATED)
                    .entity(pCase)
                    .build();
        }
    }

    @GET
    @Path("/{typeOfCase}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@PathParam("typeOfCase") String typeOfCase) {

        List<Case> cases = new ArrayList<>();
        cases.add(new Case(0, "11/20/2020", "Robo", "Perro robado a mano armada", 0));
        cases.add(new Case(1, "11/20/2019", "Robo", "Perro recuperado", 0));
        cases.add(new Case(2, "11/20/2018", "Pérdida", "Perro perdido a las afueras de Bogotá", 1));
        cases.add(new Case(3, "11/20/2017", "fallecimiento", "Falleció a causa de un exceso de croquetas", 0));
        cases.add(new Case(4, "11/20/2016", "Pérdida", "Perro desaparecido en el centro de la ciudad", 0));

        int cont = 0;
        for (Case lCase : cases)
            if (typeOfCase.equalsIgnoreCase(lCase.getType()))
                cont++;
        return Response.ok().entity("Se han registrado " + cont + " casos del tipo " + typeOfCase).build();
    }
}