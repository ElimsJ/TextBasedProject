package Rooms;
import People.*;
import Game.Runner;
public class SecretEscapeRoute extends Room
{
    public SecretEscapeRoute(int x, int y)
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
        System.out.println("You found the Escape Route. GG");
    }
}