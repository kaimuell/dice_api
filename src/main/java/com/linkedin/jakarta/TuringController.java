package com.linkedin.jakarta;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("turing")
public class TuringController {

    @Inject
    private TuringAwardService turingAwardService;

    @GET
    public String fetchTurningAwardWinner(@QueryParam("year")@DefaultValue("2020") int year){
        return turingAwardService.fetchTuringAwardWinner(year);
    }
}
