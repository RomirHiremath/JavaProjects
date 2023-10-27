
/** Varun Venkatesh
 * Romir Hiremath
 * 
 *  CS F001A OBJ-ORIENTED PROG METHOD JAVA 02W Weusijana 40472
 *  2023 Spring
 *  Version 1.0
 *  Assignment 2
 */

import becker.robots.*;

import java.awt.Color;
import java.util.Random;


/* This is the class with the main method
 * This constructs the city and wall and creates Robot and runs it
 */

public class A2 extends Object
{
   public static void main(String[] args)
   {
      City wallville = new City(6, 12);

      /* Create a new RacerRobot that does things requirement for this assignment */

      RacerRobot rob = new RacerRobot(wallville, 1, 2, Direction.EAST, 0);

      A2.buildCity(wallville); // this calls the "BuildCity" method, below

      /*
       * Do everything
       */
      rob.doEverything();

   }

   /////////////////////////////////////////////////////////////////////////////////////////
   // No need to touch any of the code below.
   // All it does is construct the maze in the city.
   /////////////////////////////////////////////////////////////////////////////////////////
   public static void buildCity(City wallville)
   {
      // Width and height must be at least 2 (each)
      // Feel free to change these numbers, and see how your race track changes

      Random randomNumberGenerator = new Random();
      int top = 1;
      int left = 2;
      int height = 4;
      int width = 4 + randomNumberGenerator.nextInt(7);

      int streetNumber = top;
      while (streetNumber <= height)
      {
         if (streetNumber == 1)
         {
            // the topmost line:
            new Wall(wallville, streetNumber, left, Direction.NORTH);
         } else if (streetNumber == height)
         {
            // generate the 'holding spot' thing at the bottom: the corner:
            new Wall(wallville, streetNumber + 1, left, Direction.WEST);
            new Wall(wallville, streetNumber + 1, left, Direction.SOUTH);
            int spotNum = left + 1;
            int counter = 0;
            while (counter < height)
            {
               new Wall(wallville, streetNumber + 1, spotNum, Direction.NORTH);
               new Wall(wallville, streetNumber + 1, spotNum, Direction.SOUTH);
               // Uncomment the next line for a 'final state' picture (i.e., the second picture
               // in the assignment)
               // new Thing(wallville, streetNumber + 1, spotNum);
               ++spotNum;
               ++counter;
            }
            new Wall(wallville, streetNumber + 1, spotNum, Direction.WEST);
         }

         // the most western, vertical line:
         new Wall(wallville, streetNumber, left, Direction.WEST);
         // the most eastern, vertical line:
         new Wall(wallville, streetNumber, width, Direction.EAST);
         // the Thing at the end of the tunnel
         new Thing(wallville, streetNumber, width);

         int aveNum = left + 1;
         while (aveNum <= width)
         {
            new Wall(wallville, streetNumber, aveNum, Direction.NORTH);
            new Wall(wallville, streetNumber, aveNum, Direction.SOUTH);
            ++aveNum;
         }

         ++streetNumber;
      }
   }
}
