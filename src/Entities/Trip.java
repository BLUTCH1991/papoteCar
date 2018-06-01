package Entities;

import java.util.SimpleTimeZone;

public class Trip {

    private String id;
    private SimpleTimeZone date_start;
    private SimpleTimeZone date_end;
    private Integer sits;
    private boolean state;
    private int city_start_id;
    private int city_end_id;
    private String adresse_start;
    private String adresse_end;

    public Trip() {
    }

    public Trip(String id, SimpleTimeZone date_start, SimpleTimeZone date_end, Integer sits, boolean state, int city_start_id, int city_end_id, String adresse_start, String adresse_end) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SimpleTimeZone getDate_start() {
        return date_start;
    }

    public void setDate_start(SimpleTimeZone date_start) {
        this.date_start = date_start;
    }

    public SimpleTimeZone getDate_end() {
        return date_end;
    }

    public void setDate_end(SimpleTimeZone date_end) {
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

    public int getCity_start_id() {
        return city_start_id;
    }

    public void setCity_start_id(int city_start_id) {
        this.city_start_id = city_start_id;
    }

    public int getCity_end_id() {
        return city_end_id;
    }

    public void setCity_end_id(int city_end_id) {
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
