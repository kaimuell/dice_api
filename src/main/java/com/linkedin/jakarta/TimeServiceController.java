package com.linkedin.jakarta;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.sql.Timestamp;

@Path("time")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TimeServiceController {

    @Inject
    TimeService timeService;
    @GET
    public Timestamp getTime(@QueryParam("update") @DefaultValue("false") boolean set){
        if (set  && timeService instanceof MockTimeService mockTimeService) {
            mockTimeService.setTimestamp(new Timestamp(System.currentTimeMillis()));
        }
        return timeService.now();
    }

}
