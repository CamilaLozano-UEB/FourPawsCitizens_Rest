package resources.pojos;

public class TotalCases {

    private String type;
    private Integer total;

    public TotalCases(String type, Integer total) {
        this.type = type;
        this.total = total;
    }

    public TotalCases(String type) {
        this.type = type;
        this.total = 1;
    }

    public TotalCases() {

    }

    public void increaseTotal() {
        this.total++;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
