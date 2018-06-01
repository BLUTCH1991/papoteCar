package Entities;


import java.time.LocalDateTime;

public class Trip {

    private Integer id;
    private LocalDateTime date_start;
    private LocalDateTime date_end;
    private Integer sits;
    private boolean state;
    private City city_start_id;
    private City city_end_id;
    private String adresse_start;
    private String adresse_end;

    public Trip() {
    }

    public Trip(Integer id, LocalDateTime date_start, LocalDateTime date_end, Integer sits, boolean state, City city_start_id, City city_end_id, String adresse_start, String adresse_end) {
        this.id = id;
        this.date_start = date_start;
        this.date_end = date_end;
        this.sits = sits;
        this.state = state;
        this.city_start_id = city_start_id;
        this.city_end_id = city_end_id;
        this.adresse_start = adresse_start;
        this.adresse_end = adresse_end;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDate_start() {
        return date_start;
    }

    public void setDate_start(LocalDateTime date_start) {
        this.date_start = date_start;
    }

    public LocalDateTime getDate_end() {
        return date_end;
    }

    public void setDate_end(LocalDateTime date_end) {
        this.date_end = date_end;
    }

    public Integer getSits() {
        return sits;
    }

    public void setSits(Integer sits) {
        this.sits = sits;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public City getCity_start_id() {
        return city_start_id;
    }

    public void setCity_start_id(City city_start_id) {
        this.city_start_id = city_start_id;
    }

    public City getCity_end_id() {
        return city_end_id;
    }

    public void setCity_end_id(City city_end_id) {
        this.city_end_id = city_end_id;
    }

    public String getAdresse_start() {
        return adresse_start;
    }

    public void setAdresse_start(String adresse_start) {
        this.adresse_start = adresse_start;
    }

    public String getAdresse_end() {
        return adresse_end;
    }

    public void setAdresse_end(String adresse_end) {
        this.adresse_end = adresse_end;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id='" + id + '\'' +
                ", date_start=" + date_start +
                ", date_end=" + date_end +
                ", sits=" + sits +
                ", state=" + state +
                ", city_start_id=" + city_start_id +
                ", city_end_id=" + city_end_id +
                ", adresse_start='" + adresse_start + '\'' +
                ", adresse_end='" + adresse_end + '\'' +
                '}';
    }
}
