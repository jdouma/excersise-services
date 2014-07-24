package com.pluralsight.repository;

import com.pluralsight.model.Activity;
import com.pluralsight.model.User;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jdouma on 7/23/2014.
 */
public class ActivityRepositoryStub implements ActivityRepository {


    private static List<Activity> activities = new ArrayList<Activity>();

    static {

        User user1 = new User("Justin");

        Activity activity1 = new Activity(user1, "Swimming", 55);
        activities.add(activity1);

        Activity activity2 = new Activity(user1, "Cycling", 120);
        activities.add(activity2);
    }

    @Override
    public List<Activity> findAllActivities() {

        return activities;
    }

    @Override
    public Activity findActivity(String activityId) {

        for (Activity a: activities) {
            if (a.getId().equals(activityId)) {
                return a;
            }
        }
        return null;
    }

    @Override
    public void create(Activity activity) {
        activities.add(activity);
    }

    @Override
    public void update(Activity newActivity) {

        if (newActivity != null) {
            Activity oldActivity = findActivity(newActivity.getId());
            if (oldActivity != null) {
                int index = activities.indexOf(oldActivity);
                activities.set(index, newActivity);
            } else {
                activities.add(newActivity);
            }
        }
    }

    public Activity findActivityIndex (String activityId) {

        int index = 0;
        for (Activity a: activities) {
            if (a.getId().equals(activityId)) {
                return a;
            }
        }
        return null;
    }
}
