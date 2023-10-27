/**
 * Exercise 19 Part 3: Creating Predicate Methods CS 1A Spring 2023
 * 
 * @author Romir Hiremath
 *
 */


import becker.robots.*;

class RobotThatCanWalkDownAWall extends Robot
{
    RobotThatCanWalkDownAWall(City c, int st, int ave, Direction dir, int num)
    {
        super(c, st, ave, dir, num);
    }
    
    // Your code should go here:
    //This code is for determining whether the robot is north of a street, and
    //it is found by using the getStreet function.
    public boolean isNorthOfStreet(int st)
    {
       System.out.println("Get street "+getStreet());
       if (st == getStreet())
           return false;
        if (st < getStreet())
            return false;
        else 
            return true;
    }    
    
    //This code is for determining whether the robot is south of a street, and
    //it is found by using the getStreet function. 
    public boolean isSouthOfStreet(int st)
    {
       System.out.println("Get street "+getStreet());
       if (st == getStreet())
           return false;
        if (st < getStreet())
            return true;
        else 
            return false;
    }   
    
    
}

public class ICE_19 extends Object
{
    public static void main(String[] args)
    {   
        City wallingford = new City();
      //  RobotThatCanWalkDownAWall jo = new RobotThatCanWalkDownAWall(wallingford, 1, 2, Direction.SOUTH, 0);
        /* build tower*/
        new Wall(wallingford, 1, 1, Direction.EAST);
        new Wall(wallingford, 2, 1, Direction.EAST);
        new Wall(wallingford, 3, 1, Direction.EAST);
      
        // make robot goto street 2, facing north.
        RobotThatCanWalkDownAWall jo = new RobotThatCanWalkDownAWall(wallingford, 2, 2, Direction.NORTH, 0);

        //You should then ask if the robot is north of street 1
        System.out.println("Is Jo north of street 1?:" + jo.isNorthOfStreet(1));

        //if it's north of street 3 (it should be),
        System.out.println("Is Jo north of street 3?:" + jo.isNorthOfStreet(3));

        //and if it's north of street 2 (it isn't).
        System.out.println("Is Jo north of street 2?:" + jo.isNorthOfStreet(2));
        
        
        //You should then ask if the robot is south of street 1
        System.out.println("Is Jo south of street 1?:" + jo.isSouthOfStreet(1));

        //if it's south of street 3 (it should be),
        System.out.println("Is Jo south of street 3?:" + jo.isSouthOfStreet(3));

        //and if it's south of street 2 (it isn't).
        System.out.println("Is Jo south of street 2?:" + jo.isSouthOfStreet(2));
        

   }
}
