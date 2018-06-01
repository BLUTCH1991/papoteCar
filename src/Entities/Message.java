package Entities;

import java.util.SimpleTimeZone;

public class Message {

    private String id;
    private String content;
    private int senderUser;
    private int receiverUser;
    private SimpleTimeZone date;
    private int trip;

    public Message() {
    }

    public Message(String id, String content, int senderUser, int receiverUser, SimpleTimeZone date, int trip) {
        this.id = id;
        this.content = content;
        this.senderUser = senderUser;
        this.receiverUser = receiverUser;
        this.date = date;
        this.trip = trip;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getSenderUser() {
        return senderUser;
    }

    public void setSenderUser(int senderUser) {
        this.senderUser = senderUser;
    }

    public int getReceiverUser() {
        return receiverUser;
    }

    public void setReceiverUser(int receiverUser) {
        this.receiverUser = receiverUser;
    }

    public SimpleTimeZone getDate() {
        return date;
    }

    public void setDate(SimpleTimeZone date) {
        this.date = date;
    }

    public int getTrip() {
        return trip;
    }

    public void setTrip(int trip) {
        this.trip = trip;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", senderUser=" + senderUser +
                ", receiverUser=" + receiverUser +
                ", date=" + date +
                ", trip=" + trip +
                '}';
    }
}
