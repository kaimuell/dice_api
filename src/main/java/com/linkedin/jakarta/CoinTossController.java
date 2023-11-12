package com.linkedin.jakarta;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.Random;

@Path("coin")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CoinTossController {
    Random random = new Random();

    @GET
    public Coin[] getThrows(@QueryParam("number")@DefaultValue("1") int numberOfThrows){
        if (numberOfThrows <= 0) return new Coin[0];
        Coin[] t = new Coin[numberOfThrows];
        for (int i = 0; i< numberOfThrows; i++){
            t[i] = random.nextInt(2) == 1? Coin.HEADS : Coin.TAILS;
        }
        return t;
    }

    public enum Coin{
        HEADS, TAILS
    }

}
