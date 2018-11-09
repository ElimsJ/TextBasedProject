package Rooms;
import People.*;
import Game.Runner;

public class TerroristRoom extends Room
{

    public TerroristRoom(int a, int b)
    {
        super(a, b);
    }

    @Override
    public void enterRoom(Person x)
    {
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("You have encountered terrorist,");

    }
}