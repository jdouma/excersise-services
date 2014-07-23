package com.pluralsight;

import com.pluralsight.model.Activity;
import com.pluralsight.model.User;
import com.pluralsight.repository.ActivityRepository;
import com.pluralsight.repository.ActivityRepositoryStub;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
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

    @POST
    @Path("activity")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Activity createActivityParams(MultivaluedMap<String, String> formParams) {

        String desc = formParams.getFirst("description");
        String dur = formParams.getFirst("duration");
        String name = formParams.getFirst("name");

        System.out.println("description: " + desc);
        System.out.println("duration: " + dur);
        System.out.println("name: " + name);

        Activity activity = new Activity(new User(name), desc,
                Integer.parseInt(dur));

        return null;
    }
}


