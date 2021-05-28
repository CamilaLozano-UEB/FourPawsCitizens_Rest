package resources;

import resources.pojos.cases.CaseByType;
import resources.pojos.cases.Cases;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/cases")
public class TotalCasesResource {

    /**
     * Create a response with an object that contains the total of cases and the total cases per type
     *
     * @return an object with the total of cases discriminated
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listTotalCasesByType() {
        List<CaseByType> caseByType = new ArrayList<>();

        caseByType.add(new CaseByType("Robo", 93));
        caseByType.add(new CaseByType("Pérdida", 107));
        caseByType.add(new CaseByType("Fallecimiento", 50));

        Cases cases = new Cases(250, caseByType);

        return Response.ok()
                .entity(cases)
                .build();
    }
}