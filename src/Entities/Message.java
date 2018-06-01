package Entities;

import java.util.SimpleTimeZone;

public class Message {

    private String id;
    private String content;
    private User senderUser;
    private User receiverUser;
    private SimpleTimeZone date;
    private Trip trip;

    public Message() {
    }

    public Message(String id, String content, User senderUser, User receiverUser, SimpleTimeZone date, Trip trip) {
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

    public User getSenderUser() {
        return senderUser;
    }

    public void setSenderUser(User senderUser) {
        this.senderUser = senderUser;
    }

    public User getReceiverUser() {
        return receiverUser;
    }

    public void setReceiverUser(User receiverUser) {
        this.receiverUser = receiverUser;
    }

    public SimpleTimeZone getDate() {
        return date;
    }

    public void setDate(SimpleTimeZone date) {
        this.date = date;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
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
