package com.pluralsight.client;

import com.pluralsight.model.Activity;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.*;


import java.util.List;


/**
 * Created by jdouma on 7/24/2014.
 */
public class ActivityClient {

    private Client mClient;
    private final WebTarget target;

    public ActivityClient() {
        mClient = ClientBuilder.newClient();
        target = mClient.target("http://localhost:8080/webapi/");
    }

    public Activity get(String id) {
        Response response = target.path("activities/" + id).request().get(Response.class);

        checkForErrors(response.getStatus());

        return response.readEntity(Activity.class);
    }

    public List<Activity> get() {

        List<Activity> response = target.path("activities")
                .request(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                .get(new GenericType<List<Activity>>() {});

        return response;
    }

    public Activity create(Activity activity) {

        Response response = target.path("activities/activity")
                .request().post(Entity.entity(activity, MediaType.APPLICATION_JSON));
        checkForErrors(response.getStatus());

        return response.readEntity(Activity.class);
    }

    public Activity update(Activity activity) {

        Response response = target.path("activities/" + activity.getId())
                .request().put(Entity.entity(activity, MediaType.APPLICATION_JSON));
        checkForErrors(response.getStatus());

        return response.readEntity(Activity.class);
    }

    private void checkForErrors(int statusCode) {
        if (statusCode != Status.OK.getStatusCode()) {
            throw new RuntimeException(statusCode +
                    ": there was an error on the server");
        }
    }
}
