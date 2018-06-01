package Entities;

public class StepUser {

    private Integer id;
    private User user;
    private Step step;
    private Trip trip;
    private Step stepUserRole;

    public StepUser() {
    }

    public StepUser(Integer id, User user, Step step, Trip trip) {
        this.id = id;
        this.user = user;
        this.step = step;
        this.trip = trip;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Step getStep() {
        return step;
    }

    public void setStep(Step step) {
        this.step = step;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Step getStepUserRole() {
        return stepUserRole;
    }

    public void setStepUserRole(Step stepUserRole) {
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
