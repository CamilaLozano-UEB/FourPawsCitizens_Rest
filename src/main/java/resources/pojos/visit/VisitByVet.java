package resources.pojos.visit;

public class VisitByVet {
    private String username;
    private Integer total;

    /**
     * @param vet   the visit vet
     * @param total the visit total of that vet
     */
    public VisitByVet(String vet, Integer total) {
        this.username = vet;
        this.total = total;
    }

    public VisitByVet() {
    }

    /**
     * @return the username of the vet
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the total of visits of the type
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * @param total the new total of visit of that type
     */
    public void setTotal(Integer total) {
        this.total = total;
    }
}
