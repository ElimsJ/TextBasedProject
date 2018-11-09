package Rooms;
import People.*;
import java.util.Random;
import Game.Runner;

public class WeaponRoom extends Room
{

    public WeaponRoom(int w, int n)
    {
        super(w, n);
    }

    @Override
    public void enterRoom(Person x)
    {
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("You found the Weapon Room! You acquired an");
    }
}
