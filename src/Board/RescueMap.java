package Board;

import Rooms.Room;

public class RescueMap
{
    private Room[][] building;
    private void RescueMap(Room[][] building)
    {
        this.building = building;
    }
    public void print()
    {
        for(int i = 0; i< building.length; i++)
        {
            for(int j = 0; j < building[i].length;j++)
            {
                System.out.print(building[i][j]);
            }
            System.out.println();
        }
    }
}
