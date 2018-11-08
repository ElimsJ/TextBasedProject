package Game;

import People.Person;
import Rooms.*;
import java.util.Scanner;
import java.util.Random;
import Board.RescueMap;

public class Runner extends RescueMap
{
    private static boolean gameOn = true;

    public static void main(String[] args)
    {
        Room[][] building = new Room[5][5];
        int hostage = 0;
        Random r = new Random ();
        int weapons = 0;
        String[] items = {""};
        String[] weaponList = {"AK-12","M4A1","SCAR-LI"};
        //Fill the building with normal rooms
        for (int x = 0; x<building.length; x++)
        {
            for (int y = 0; y < building[x].length; y++)
            {
                building[x][y] = new Room(x,y);
            }
        }
        //Create a random winning room.
        int x = (int)(Math.random()*building.length);
        int y = (int)(Math.random()*building.length);
        building[x][y] = new HostageRoom(x, y);

        int a = (int)(Math.random()*building.length);
        int b = (int)(Math.random()*building.length);
        building[a][b] = new TerroristRoom(a, b);

        int w = (int)(Math.random()*building.length);
        int n = (int)(Math.random()*building.length);
        building[w][n] = new WeaponRoom(w, n);

        int e = (int)(Math.random()*building.length);
        int z = (int)(Math.random()*building.length);
        building[e][z] = new SecretEscapeRoute(e, z)
        {
            @Override
            public void enterRoom(Person x) {
                super.enterRoom(x);
            }
        };
        System.out.println("hostageRoom "+x + "," + y);
        System.out.println("escapeRoute "+e + "," + z);
        System.out.println("terroristRoom "+a + "," + b);
        System.out.println("weaponRoom "+w + "," + n);
        //Setup player 1 and the input scanner
        Person player1 = new Person("FirstName", "FamilyName", 0,0);
        building[0][0].enterRoom(player1);
        Scanner in = new Scanner(System.in);

        while(gameOn)
        {
            System.out.println("Where would you like to move? (Choose N, S, E, W)");
            String move = in.nextLine();
            if(player1.getxLoc() == x)
            {
                if(player1.getyLoc() == y)
                {
                    hostage = 1;
                }
            }
                if(player1.getxLoc()== e)
                {
                    if(player1.getyLoc() == z)
                    {
                        if(hostage>0)
                        {
                            System.out.println("Mission Complete");
                            gameOff();
                        }
                    }
                }
            if(player1.getxLoc()== w)
            {
                if(player1.getyLoc()==n)
                {
                    weapons++;
                    items[0] += weaponList[r.nextInt(weaponList.length)];
                }
            }
            if(player1.getxLoc()==a)
            {
                if (player1.getyLoc()== b)
                {
                    if (weapons == 0)
                    {
                        System.out.println("you have been killed by the terrorist");
                        gameOff();
                    }
                    else
                    {
                        System.out.println("you have defeated the terrorist");
                    }
                }
            }
            if(validMove(move, player1, building))
            {
                System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());
            }
            else {
                System.out.println("Please choose a valid move.");
            }
        }
        in.close();
    }

    /**
     * Checks that the movement chosen is within the valid game map.
     * @param move the move chosen
     * @param p person moving
     * @param map the 2D array of rooms
     * @return
     */
    public static boolean validMove(String move, Person p, Room[][] map)
    {
        move = move.toLowerCase().trim();
        switch (move)
        {
            case "n":
                if (p.getxLoc() > 0)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()-1][p.getyLoc()].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }
            case "e":
                if (p.getyLoc()< map[p.getyLoc()].length -1)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()][p.getyLoc() + 1].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }

            case "s":
                if (p.getxLoc() < map.length - 1)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()+1][p.getyLoc()].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }

            case "w":
                if (p.getyLoc() > 0)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()][p.getyLoc()-1].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }
            default:
                break;

        }
        return false;
    }
    public static void gameOff()
    {
        gameOn = false;
    }
}
