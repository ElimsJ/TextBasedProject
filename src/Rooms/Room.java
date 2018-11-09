package Rooms;

import People.Person;

public class Room
{
    Person occupant;
    int xLoc,yLoc;

    public Room(int x, int y)
    {
        xLoc = x;
        yLoc = y;
    }

    public void enterRoom(Person x)
    {
        System.out.println("Keep looking for hostage.");
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
    }

    public void leaveRoom(Person x)
    {
        occupant = null;
    }
    public String toString()
    {
       return "[]";
    }
}