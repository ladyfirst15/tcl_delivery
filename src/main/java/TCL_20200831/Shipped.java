package TCL_20200831;

public class Shipped extends AbstractEvent {

    private Long id;
    private String status;

    public Shipped(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
