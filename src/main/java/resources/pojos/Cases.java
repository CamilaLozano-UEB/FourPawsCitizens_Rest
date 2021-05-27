package resources.pojos;

import java.util.ArrayList;
import java.util.List;

public class Cases {
    List<Case> cases;
    List<TotalCases> totalCases;

    public Cases() {
        this.cases = new ArrayList<>();
        this.totalCases = new ArrayList<>();
    }

    public List<Case> getCases() {
        return cases;
    }

    public void setCases(List<Case> cases) {
        this.cases = cases;
    }

    public List<TotalCases> getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(List<TotalCases> totalCases) {
        this.totalCases = totalCases;
    }
}
