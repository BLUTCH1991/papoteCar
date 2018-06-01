package Entities;

public class StepUser {

    private String id;
    private int user;
    private int step;
    private int trip;
    private int stepUserRole;

    public StepUser() {
    }

    public StepUser(String id, int user, int step, int trip) {
        this.id = id;
        this.user = user;
        this.step = step;
        this.trip = trip;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getTrip() {
        return trip;
    }

    public void setTrip(int trip) {
        this.trip = trip;
    }

    public int getStepUserRole() {
        return stepUserRole;
    }

    public void setStepUserRole(int stepUserRole) {
        this.stepUserRole = stepUserRole;
    }

    @Override
    public String toString() {
        return "StepUser{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", step=" + step +
                ", trip=" + trip +
                '}';
    }
}
