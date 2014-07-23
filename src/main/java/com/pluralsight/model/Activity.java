package com.pluralsight.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by jdouma on 7/23/2014.
 */
@XmlRootElement
public class Activity {

    private String id;
    private String description;
    private User user;
    private int duration;

    private static int activityCount = 0;

    public Activity() {}

    public Activity(User user, String desc, int duration) {
        this.id = Integer.toString(++activityCount);
        this.user = user;
        this.description = desc;
        this.duration = duration;
    }

    @XmlElement(name="desc")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
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
}
