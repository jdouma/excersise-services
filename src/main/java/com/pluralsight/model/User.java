package com.pluralsight.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by jdouma on 7/23/2014.
 */
@XmlRootElement
public class User {

    private static int userCount = 0;

    private String name;
    private String id;

    public User () {}

    public User (String name) {
        this.id = Integer.toString(++userCount);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
