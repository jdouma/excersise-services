package com.pluralsight;

import com.pluralsight.model.Activity;
import com.pluralsight.model.User;
import com.pluralsight.repository.ActivityRepository;
import com.pluralsight.repository.ActivityRepositoryStub;
import org.glassfish.jersey.server.JSONP;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
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
    @JSONP
    @Produces("application/x-javascript")
    @Path("{activityId}")
    public Response getActivity(@PathParam("activityId") String activityId) {
        if (activityId == null || activityId.length() < 4 ) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        Activity activity = mActivityRepository.findActivity(activityId);
        if ( activity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        System.out.println("Getting activity " + activityId);
    //    System.out.println("callback: " + callback);

        return Response.ok().entity(activity).build();
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

        mActivityRepository.create(activity);

        return activity;
    }

    @POST
    @Path("activity")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Activity createActivity(Activity activity) {

        System.out.println(activity.getDescription());
        System.out.println(activity.getDuration());
        System.out.println(activity.getUser().getName());

        mActivityRepository.create(activity);

        return activity;
    }

    @PUT
    @Path("{activityId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response update(Activity activity) {
        System.out.println(activity.getDescription());
        System.out.println(activity.getDuration());
        System.out.println(activity.getUser().getName());

        mActivityRepository.update(activity);

        return Response.ok().entity(activity).build();

    }
}


