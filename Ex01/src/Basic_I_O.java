import becker.robots.*;
import java.util.Scanner;

/*
Starting Template:
This file was created in order to provide you with a pre made 'starter' program
 */

public class Basic_I_O extends Object
{
    public static void main(String[] args)
    {
        System.out.println("THE PROGRAM STARTS HERE!!");

        int userChoice = 0;

        City toronto = new City();
        Robot jo = new Robot(toronto, 3, 0, Direction.EAST, 0);
        Thing baton = new Thing(toronto, 3, 2);
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Type 1 if you want the robot to turn left");
        System.out.println("Type 2 if you want it to move 1 intersection");
        System.out.println("Type 3 if you want the robot to pick a thing");
        System.out.println("Type 4 if you want it to put a thing down");

        if (keyboard.hasNextInt())
        {
            userChoice = keyboard.nextInt(); // nextInt actually gets the input
        } else
        {
            System.out.println("You did NOT type in a whole number!");
        }
        keyboard.nextLine(); // DON'T FORGET TO CLEAR ANY REMAINING INPUT!!
        keyboard.close(); // You don't have to close the Scanner resource, but
        // it is good practice to do so

        /* Your code should after here: */
        if (userChoice == 1)
        {
            jo.move();
        }
        else if (userChoice == 2)
        {
            jo.turnLeft();
        }
        else if (userChoice == 3)
        {
            if (jo.canPickThing())
            {
                jo.pickThing(baton);
            }
        }
        else if (userChoice == 4)
        {
            if (jo.countThingsInBackpack() > 1)
            {
                jo.putThing(baton);
            }
        } else
        {
            System.out.println("Choice is invalid");
        }

    }
}
