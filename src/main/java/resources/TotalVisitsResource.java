package resources;

import resources.pojos.visit.VisitByType;
import resources.pojos.visit.VisitByVet;
import resources.pojos.visit.Visits;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/visits")
public class TotalVisitsResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listOfTotalVisits() {

        List<VisitByType> visitByTypeList = new ArrayList<>();

        visitByTypeList.add(new VisitByType("Esterilización", 50));
        visitByTypeList.add(new VisitByType("Implantación de microchip", 15));
        visitByTypeList.add(new VisitByType("Vacunación", 11));
        visitByTypeList.add(new VisitByType("Desparasitación", 39));
        visitByTypeList.add(new VisitByType("Urgencia", 19));
        visitByTypeList.add(new VisitByType("Control", 16));

        List<VisitByVet> visitByVets = new ArrayList<>();

        visitByVets.add(new VisitByVet("Petcol", 73));
        visitByVets.add(new VisitByVet("Agrocampo", 43));
        visitByVets.add(new VisitByVet("Peluditos", 24));
        visitByVets.add(new VisitByVet("Huellitas", 10));

        Visits visits = new Visits(150, visitByTypeList, visitByVets);

        return Response.ok().entity(visits).build();
    }
}