import becker.robots.*;

public class SaferRobot extends Robot
{
    public SaferRobot(City aCity, int aStreet, int anAvenue, Direction aDirection, int numThings)
    {
        super(aCity, aStreet, anAvenue, aDirection, numThings);

    }

    /*
     * This moveSafely method moves the robot forward without crashing into walls
     * and without leaving the default view of the city by never going past avenue
     * 6. It also returns how many blocks it moved.
     */
    public int moveSafely()
    {
        int blocksMoved = 0;
        while (frontIsClear())
        {
            this.move();
            blocksMoved++;

            if (this.getAvenue() >= 6)
            {
                return blocksMoved;

            }
            
        }
        return blocksMoved;

    }

    public static void main(String[] args)
    {
        City robotown = new City();
        SaferRobot robo = new SaferRobot(robotown, 0, 0, Direction.EAST, 0);
        int moved = robo.moveSafely();
        System.out.println("robo just moved " + moved + " blocks.");
    }
}

/*
 * class SaferRobot extends Robot { SaferRobot(City c, int st, int ave,
 * Direction dir, int num) { super(c, st, ave, dir, num); }
 * 
 * /** Picks up something, but only if there's something to pick up.
 * 
 * public void pickThingSafer() { if( this.canPickThing()) { this.pickThing();
 * this.pickThing(); }
 * 
 * }
 * 
 * 
 * /** Picks up something, but only if there's something to pick up.
 * 
 * public void putThingSafer() {
 * 
 * if(this.countThingsInBackpack()>0) { this.putThing(); }
 * 
 * }
 * 
 * }
 */
