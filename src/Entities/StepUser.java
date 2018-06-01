package Entities;

public class StepUser {

    private String id;
    private User user;
    private Step step;
    private Trip trip;

    public StepUser() {
    }

    public StepUser(String id, User user, Step step, Trip trip) {
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
