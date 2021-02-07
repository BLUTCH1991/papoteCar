package Entities;

public class StepUserRole {

    private Integer id;
    private String name;

    public StepUserRole() {
    }

    public StepUserRole(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StepUserRole{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
