package resources;

import resources.pojos.Case;
import resources.pojos.Cases;
import resources.pojos.TotalCases;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/case")
public class CaseResource {

    private Cases cases;

    public CaseResource() {
        this.cases = new Cases();
        this.cases.getCases().add(new Case(0, "11/20/2020", "Robo", "Perro robado a mano armada", 0));
        this.cases.getTotalCases().add(new TotalCases("Robo"));
        this.cases.getCases().add(new Case(1, "11/20/2019", "Robo", "Perro recuperado", 0));
        this.cases.getTotalCases().get(0).increaseTotal();
        this.cases.getCases().add(new Case(2, "11/20/2018", "Pérdida", "Perro perdido a las afueras de Bogotá", 1));
        this.cases.getTotalCases().add(new TotalCases("Pérdida"));
        this.cases.getCases().add(new Case(3, "11/20/2017", "fallecimiento", "Falleció a causa de un exceso de croquetas", 0));
        this.cases.getTotalCases().add(new TotalCases("fallecimiento"));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{pet_id}")
    public Response create(@PathParam("pet_id") Integer pet_id, Case pCase) {

        pCase.setCase_id(this.cases.getCases().size());
        pCase.setPet_id(pet_id);
        this.cases.getCases().add(pCase);

        boolean caseTypeExistent = false;
        for (TotalCases totalCases : this.cases.getTotalCases()) {
            if (totalCases.getType().equalsIgnoreCase(pCase.getType())) {
                totalCases.increaseTotal();
                caseTypeExistent = true;
            }
        }
        if (!caseTypeExistent)
            this.cases.getTotalCases().add(new TotalCases(pCase.getType()));

        return Response.status(Response.Status.CREATED)
                .entity(pCase)
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        this.sendTotalCases();
        return Response.ok().entity(this.cases.getTotalCases()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendTotalCases() {
        return Response.ok().entity("Total de casos: " + this.cases.getCases().size()).build();
    }
}