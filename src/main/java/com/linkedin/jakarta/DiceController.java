package com.linkedin.jakarta;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.Random;

@Path("dice")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DiceController {

    @POST
    public DiceRollResult rollDice(Dice d){
        return new DiceRollResult(d.getSides(),d.roll());
    }

    public static class Dice {

        private int sides;
        private Random random = new Random();


        public Dice(int sides){
            this.sides = sides;
        }

        public Dice() {
        }

        public int getSides() {
            return sides;
        }

        public void setSides(int sides) {
            this.sides = sides;
        }

        public Random getRandom() {
            return random;
        }

        public void setRandom(Random random) {
            this.random = random;
        }

        public int roll(){
            return random.nextInt(sides)+1;
        }
    }

    public record DiceRollResult(int sides, int value){}
}
