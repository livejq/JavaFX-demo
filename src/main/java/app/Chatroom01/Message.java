package app.Chatroom01;

import java.sql.Timestamp;

/**
 * @author livejq
 * @since 2020/4/12
 **/
public class Message {

    public int id;
    public String Name;
    public String msg;
    public Timestamp timeStamp;
    public String picPath;
    public boolean status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Message(int id, String msg, Timestamp timeStamp) {
        this.id = id;
        this.msg = msg;
        this.timeStamp = timeStamp;
    }

    public Message(int id, String picPath, String name, boolean status) {
        this.id = id;
        Name = name;
        this.picPath = picPath;
        this.status = status;
    }
}
