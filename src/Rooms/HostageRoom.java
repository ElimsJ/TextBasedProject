package Rooms;
import Game.Runner;
import People.Person;

public class HostageRoom extends Room
{
    public HostageRoom(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void enterRoom(Person x)
    {
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("You found the HostageRoom! Now go to the Secret Entrance");
    }
}