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

    private static int activityCount = 1233;

    public Activity(String id, User user, String desc, int duration) {
        this.id = id;
        this.user = user;
        this.description = desc;
        this.duration = duration;
    }

    // Provide ID if not provided
    public Activity(User user, String desc, int duration) {
        this(Integer.toString(++activityCount), user, desc, duration);
    }

    public Activity(String description, int duration) {
        this(new User("Default User"), description, duration);
    }

    public Activity() {}


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
