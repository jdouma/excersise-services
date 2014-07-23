package com.pluralsight.repository;

import com.pluralsight.model.Activity;
import com.pluralsight.model.User;

import java.util.List;

/**
 * Created by jdouma on 7/23/2014.
 */
public interface ActivityRepository {
    List<Activity> findAllActivities();

    Activity findActivity(String activityId);


}
