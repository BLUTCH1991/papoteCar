package Entities;


import java.time.LocalDateTime;

public class Step {

    private Integer id;
    private Trip trip;
    private City cityStart;
    private City cityEnd;
    private String adressStart;
    private String adressEnd;
    private LocalDateTime date;

    public Step() {
    }

    public Step(Integer id, Trip trip, City cityStart, City cityEnd, String adressStart, String adressEnd, LocalDateTime date) {
        this.id = id;
        this.trip = trip;
        this.cityStart = cityStart;
        this.cityEnd = cityEnd;
        this.adressStart = adressStart;
        this.adressEnd = adressEnd;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public City getCityStart() {
        return cityStart;
    }

    public void setCityStart(City cityStart) {
        this.cityStart = cityStart;
    }

    public City getCityEnd() {
        return cityEnd;
    }

    public void setCityEnd(City cityEnd) {
        this.cityEnd = cityEnd;
    }

    public String getAdressStart() {
        return adressStart;
    }

    public void setAdressStart(String adressStart) {
        this.adressStart = adressStart;
    }

    public String getAdressEnd() {
        return adressEnd;
    }

    public void setAdressEnd(String adressEnd) {
        this.adressEnd = adressEnd;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Step{" +
                "id='" + id + '\'' +
                ", trip=" + trip +
                ", cityStart=" + cityStart +
                ", cityEnd=" + cityEnd +
                ", adressStart='" + adressStart + '\'' +
                ", adressEnd='" + adressEnd + '\'' +
                ", date=" + date +
                '}';
    }
}
