package Entities;

import java.text.SimpleDateFormat;
import java.util.SimpleTimeZone;

public class Step {

    private String id;
    private int trip;
    private int cityStart;
    private int cityEnd;
    private String adressStart;
    private String adressEnd;
    private SimpleTimeZone date;

    public Step() {
    }

    public Step(String id, int trip, int cityStart, int cityEnd, String adressStart, String adressEnd, SimpleTimeZone date) {
        this.id = id;
        this.trip = trip;
        this.cityStart = cityStart;
        this.cityEnd = cityEnd;
        this.adressStart = adressStart;
        this.adressEnd = adressEnd;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTrip() {
        return trip;
    }

    public void setTrip(int trip) {
        this.trip = trip;
    }

    public int getCityStart() {
        return cityStart;
    }

    public void setCityStart(int cityStart) {
        this.cityStart = cityStart;
    }

    public int getCityEnd() {
        return cityEnd;
    }

    public void setCityEnd(int cityEnd) {
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

    public SimpleTimeZone getDate() {
        return date;
    }

    public void setDate(SimpleTimeZone date) {
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
