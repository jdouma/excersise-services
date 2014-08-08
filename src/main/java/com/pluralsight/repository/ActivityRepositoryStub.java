package com.pluralsight.repository;

import com.pluralsight.model.Activity;
import com.pluralsight.model.User;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by jdouma on 7/23/2014.
 */
public class ActivityRepositoryStub implements ActivityRepository {


    private static List<Activity> activities = new ArrayList<Activity>();

    static {

        String[] userNames = {"Justin", "Mary", "Jake", "Betty", "Bob",
            "Vero", "Darlington", "Elsa", "Eddy", "Francis"};

        Random random = new Random();

        for (String name : userNames) {
            User user = new User(name);

            Activity activity1 = new Activity(user, "Swimming", random.nextInt(121));
            activities.add(activity1);

            Activity activity2 = new Activity(user, "Cycling", random.nextInt(121));
            activities.add(activity2);

            Activity activity3 = new Activity(user, "Running", random.nextInt(121));
            activities.add(activity3);
        }
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
