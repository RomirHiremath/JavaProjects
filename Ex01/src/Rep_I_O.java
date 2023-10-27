
/** Romir Hiremath
 *  CS F001A OBJ-ORIENTED PROG METHOD JAVA 02W Weusijana 40472
 *  2023 Spring
 *  Version 1.0

 */
import becker.robots.*;
import java.util.Scanner;


public class Rep_I_O extends Object
{
    public static void main(String[] args)
    {
        System.out.println("THE PROGRAM STARTS HERE!!");

        int userChoice = 0;

        City toronto = new City();
        Robot jo = new Robot(toronto, 3, 0, Direction.EAST, 0);
        Thing baton = new Thing(toronto, 3, 2);
        Scanner keyboard = new Scanner(System.in);
        
        /*
         * In a while loop till quit command is received to break
         */

        while (true)
        {
            System.out.println("Type 1 if you want the robot to turn left");
            System.out.println("Type 2 if you want it to move 1 intersection");
            System.out.println("Type 3 if you want the robot to pick a thing");
            System.out.println("Type 4 if you want it to put a thing down");
            System.out.println("Type 5 if you want Quit");

            if (keyboard.hasNextInt())
            {
                userChoice = keyboard.nextInt(); // nextInt actually gets the input
                keyboard.nextLine(); // DON'T FORGET TO CLEAR ANY REMAINING INPUT!!
            } else
            {
                System.out.println("You did NOT type in a whole number 1-5 !");
                keyboard.nextLine(); // DON'T FORGET TO CLEAR ANY REMAINING INPUT!!
                continue;
            }

            /* Your code should after here: */
            if (userChoice == 1)
            {
                jo.turnLeft();

            } else if (userChoice == 2)
            {
                jo.move();

            } else if (userChoice == 3)
            {
                if (jo.canPickThing())
                {
                    jo.pickThing(baton);
                } else
                {
                    System.out.println("Nothing available to Pick");

                }

            } else if (userChoice == 4)
            {

                if (jo.countThingsInBackpack() > 0)
                {
                    jo.putThing(baton);

                } else
                {
                    System.out.println("Nothing available to drop");

                }

            } else if (userChoice == 5)
            {
                System.out.println("Quit command");
                break;
            } else
            {
                System.out.println("Choice is invalid please enter number 1-5 ");
            }
        }
        keyboard.close(); // You don't have to close the Scanner resource, but
        // it is good practice to do so
        System.out.println("Quit Command received THE PROGRAM ENDS HERE!!");

    }
}
