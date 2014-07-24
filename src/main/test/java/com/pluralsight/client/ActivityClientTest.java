package com.pluralsight.client;

import com.pluralsight.model.Activity;
import com.pluralsight.model.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jdouma on 7/24/2014.
 */
public class ActivityClientTest {

    private ActivityClient client;

    @Before
    public void setUp() {
        client = new ActivityClient();
    }

    @Test
    public void testGet() {
        Activity activity = client.get("1234");
        assertNotNull(activity);
    }

    @Test
    public void testGetList() {
        List<Activity> activities = client.get();
        assertNotNull(activities);
    }

    // Invalid ID
    @Test(expected = RuntimeException.class)
    public void testGetWithBadRequest() {
        client.get("123");
    }


    //ID not found
    @Test(expected = RuntimeException.class)
    public void testGetRequestNotFound() {
        client.get("9999");
    }


    @Test
    public void testCreate() {
        User user = new User("Johnny");
        Activity activity = new Activity(user, "Swimming", 90);

        activity = client.create(activity);

        assertNotNull(activity);
    }

    @Test
    public void testPut() {
        Activity activity = new Activity("3456",new User("Sam"), "Yoga", 77);
        activity = client.update(activity);

        assertNotNull(activity);
    }
}
