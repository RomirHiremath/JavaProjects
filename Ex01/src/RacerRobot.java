
/** Varun Venkatesh
 *  Romir Hiremath
 *  CS F001A OBJ-ORIENTED PROG METHOD JAVA 02W Weusijana 40472
 *  2023 Spring
 * Team Project
 *  Version 1.0
 *   Assignment 2
 */

import becker.robots.*;
import java.util.Random;
import java.awt.Color;

/**
 * This class represents a new type of Robot that races through horizontal pipe
 * and picks the Things up on the way, and put the Things in the final row of
 * the city no matter how long those pipes are
 * 
 * @author Varun Venkatesh
 * @author Romir Hiremath
 * 
 * 
 *         May 1, 2023
 *
 */

public class RacerRobot extends Robot
{

   /* Constructor */
   RacerRobot(City c, int st, int ave, Direction dir, int num)
   {
      super(c, st, ave, dir, num);

      /* Set the name and color for the Robot */
      this.setLabel("Racer");
      this.setColor(Color.RED);
   }

   /**
    * This method combines and does all the actions that are required for this
    * assignment
    */
   void doEverything()
   {
      /* From each of the 4 rows pick up the things */
      int count = 0;
      while (count < 4)
      {
         moveToWall();
         pickThingIfFoundSafely();
         turnAround();
         moveToWall();

         this.turnLeft();
         this.move();
         this.turnLeft();

         count++;
      }

      /*
       * A this point, Robot has all the things, it now needs to drop it last row in
       * each intersection, and come back to starting position
       */
      dropThingsInLastRow();
      returnToStart();

   }

   /** Move the Robot to the wall (obstruction) */
   public void moveToWall()
   {
      /* Check if this an obstruction and if not move */
      while (this.frontIsClear())
      {
         this.move();
      }

   }

   /** If this Robot can pick a thing then pick up a thing */
   public void pickThingIfFoundSafely()
   {

      if (this.canPickThing())
      {
         this.pickThing();
      }

   }

   /** This method turns the Robot around */
   public void turnAround()
   {
      this.turnLeft();
      this.turnLeft();
   }

   /** This method turns the Robot to Right */
   public void turnRight()
   {
      this.turnLeft();
      this.turnLeft();
      this.turnLeft();
   }

   /** Move the Robot to last row and drop thing in each intersection */
   public void dropThingsInLastRow()
   {

      /*
       * As long as Robot has thing in backpack, move and drop it in an intersection
       * as it moves along in the last row
       */
      while (this.countThingsInBackpack() > 0)
      {

         /* Check if this an obstruction and if not move */
         if (this.frontIsClear())
         {
            this.move();
            this.putThing();
         }
      }

   }

   /**
    * Move the Robot to starting position This requires it to turn around and go to
    * the wall, turn right, go the wall and turn right
    */
   public void returnToStart()
   {
      turnAround();
      moveToWall();
      turnRight();
      moveToWall();
      turnRight();

   }

}
