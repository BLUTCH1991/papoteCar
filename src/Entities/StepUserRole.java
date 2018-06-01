package Entities;

public class StepUserRole {

    private String id;
    private String name;

    public StepUserRole() {
    }

    public StepUserRole(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
