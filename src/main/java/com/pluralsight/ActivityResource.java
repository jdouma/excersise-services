package com.pluralsight;

import com.pluralsight.model.Activity;
import com.pluralsight.model.User;
import com.pluralsight.repository.ActivityRepository;
import com.pluralsight.repository.ActivityRepositoryStub;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by jdouma on 7/23/2014.
 */
@Path("activities")
public class ActivityResource {

    private ActivityRepository mActivityRepository = new ActivityRepositoryStub();

    @GET
    @Produces({MediaType.APPLICATION_XML})
    public List<Activity> getAllActivities() {
        return mActivityRepository.findAllActivities();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("{activityId}")
    public Activity getActivity(@PathParam("activityId") String activityId) {
        return mActivityRepository.findActivity(activityId);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("{activityId}/user")
    public User getActivityUser(@PathParam("activityId") String activityId) {
        return mActivityRepository.findActivity(activityId).getUser();
    }

}


