package Rooms;
import People.*;
import Game.Runner;

public class TerroristRoom extends Room
{

    public TerroristRoom(int x, int y)
    {
        super(x, y);
    }

    /**
     * Triggers the game ending conditions.
     * @param x the Person entering
     */
    @Override
    public void enterRoom(Person x)
    {
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("You found the HostageRoom! Now go to the Secret Entrance");
    }
}