package Rooms;
import People.*;
import Game.Runner;
public class SecretEscapeRoute extends Room
{
    public SecretEscapeRoute(int e, int z)
    {
        super(e, z);
    }

    @Override
    public void enterRoom(Person x)
    {
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("You found the Escape Route.");
    }
}