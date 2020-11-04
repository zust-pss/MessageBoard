package org.message.entity;

import java.util.Date;

public class MessageBoard {
    private int messageID;
    private int id;
    private String name;
    private Date time;
    private String title;
    private String message;

    public int getId() {
        return id;
    }

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageBoard(int id, String name, Date time, String title, String message) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.title = title;
        this.message = message;
    }

    public MessageBoard() {
    }

    public MessageBoard(int messageID, int id, String name, Date time, String title, String message) {
        this.messageID = messageID;
        this.id = id;
        this.name = name;
        this.time = time;
        this.title = title;
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageBoard{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time=" + time +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
