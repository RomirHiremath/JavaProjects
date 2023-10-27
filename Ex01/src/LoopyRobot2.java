
/* TODO: Fix the all the sections marked with "TODO:" comments (compile-time/syntax and logic errors). 
 * Make sure you follow ALL the instructions in the comments!
 * LoopyRobot distributes the Things in its backpack across 3 streets.
 */
import becker.robots.*;
import java.util.Random;

public class LoopyRobot2 extends Robot
{

    static final int NUM_THINGS_INITIALLY_IN_BACKPACK = 20;
    static final int NUM_THINGS_TO_PUT_ON_STREET1 = 2;

    /**
     * @param aCity
     * @param aStreet
     * @param anAvenue
     * @param aDirection
     * @param numThings
     */
    public LoopyRobot2(City aCity, int aStreet, int anAvenue, Direction aDirection, int numThings)
    {
        super(aCity, aStreet, anAvenue, aDirection, numThings);
    }

    public void turnRight()
    {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    /*
     * This method distributes a random number of things across street 0.
     */
    public int putRandomNumThings()
    {
        Random randomGenerator = new Random();
        int numThingsToPut = randomGenerator.nextInt(21);
        System.out.println("The number " + numThingsToPut + " was randomly generated.");
        // Since we only know numThingsToPut will be 0 up to 20, it is best to
        // use a while-loop here.
        int counter = 0;

        while (counter < numThingsToPut)
        {

            // Make sure you leave at least (NUM_THINGS_TO_PUT_ON_STREET1 + 1)
            // things in the backpack for the other 2 streets by adding code here
            // inside the while-loop (HINT:use the 'return' keyword):

            if ((NUM_THINGS_INITIALLY_IN_BACKPACK - counter) == (NUM_THINGS_TO_PUT_ON_STREET1 + 1))
            {
                return counter;
            }

            if (this.countThingsInBackpack() > 0)
            {
                putThing();
                move();
                ++counter;
            }

        }
        return counter;
    }

    /*
     * This method moves the LoopyRobot south to the next street. Whichever
     * direction the robot was facing (east to west) it will be facing the opposite
     * direction when it gets to the next street.
     */
    public void gotoNextStreet()
    {
        if (getDirection() == Direction.EAST)
        {
            turnRight();
            move();
            turnRight();
        } else
        {
            // This LoopyRobot must be facing WEST
            turnLeft();
            move();
            turnLeft();
        }
    }

    /*
     * This method is used to put a certain number of things (using parameter
     * numThingsToPut) down on street 1.
     */
    public void putThings(int numThingsToPut)
    {
        // Since we know exactly how many Things to put down
        // it is best to use a for-loop here.
        int counter = 0;
        for (int i = 0; i < numThingsToPut; i++)
        {
            if (this.countThingsInBackpack() > 0)
            {
                putThing();
                counter++;

            }
            // Move only if you have more thing to drop in this street
            if (counter < numThingsToPut)
            {
                move();
            }
        }
        // No need to return how many things this LoopyRobot put down
        // because we knew that number in advance
    }

    /*
     * This method is used to put at least 1 thing down on street 2.
     */
    public int putAtLeast1Thing()
    {
        int counter = 0; // Don't change this line
        // Since we know we will put down at least 1 Thing use a do-while
        // loop here:
        do
        {
            if (this.countThingsInBackpack() > 0)
            {
                putThing();
                counter++;
            }

            // If there are more things in bag, move otherwise stay there
            if (this.countThingsInBackpack() > 0)
            {
                move();
            }

        } while (this.countThingsInBackpack() > 0);
        // Since we are not sure (in advance) about how many things will be put
        // down, we return the number that was actually put down.
        return counter;
    }

    /*
     * This method distributes things in the robot's backpack across 3 streets. It
     * also calls printScrollStatus() so users are warned if the robot is not
     * visible on the default city screen.
     */
    public void distributeThings()
    {

        if (NUM_THINGS_INITIALLY_IN_BACKPACK < 2)
        {
            System.out.println(
                    "The LoopyRobot has " + NUM_THINGS_INITIALLY_IN_BACKPACK + " Things. This is not enough to put "
                            + NUM_THINGS_TO_PUT_ON_STREET1 + " thing in street 1 and  atleast one thing in street 2");
            return;
        }

        // Put a random number of things down on street 0
        int thingsPutStreet0 = putRandomNumThings();
        // NOTE the use of an "else-if" to handle printing out what happened while
        // correctly
        // handling plurality language.
        if (thingsPutStreet0 > 1)
        {
            System.out.println("The LoopyRobot just put down " + thingsPutStreet0 + " Things.");
        } else if (thingsPutStreet0 == 1)
        {
            System.out.println("The LoopyRobot just put down only one Thing.");
        } else
        {
            System.out.println("The LoopyRobot didn't put down even one Thing.");
        }

        printScrollStatus();
        gotoNextStreet();

        // Put a preset number of things (from the constant
        // NUM_THINGS_TO_PUT_ON_STREET1)
        // on street 1
        putThings(NUM_THINGS_TO_PUT_ON_STREET1);
        System.out.println("The LoopyRobot loopy just put down " + NUM_THINGS_TO_PUT_ON_STREET1 + " Things.");

        printScrollStatus();
        gotoNextStreet();

        // Put the remaining things down on street 2. At this stage. there must be
        // at least 1 thing left in the robot's backpack for this to work properly!
        int thingsPutStreet2 = putAtLeast1Thing();
        if (thingsPutStreet2 > 1)
        {
            System.out.println("The LoopyRobot just put down " + thingsPutStreet2 + " Things.");
        } else
        {
            System.out.println("The LoopyRobot just put down only one Thing.");
        }

        printScrollStatus();
    }

    public void printScrollStatus()
    {
        // Let the user know if they need to scroll or not, and
        // if so, which way they should scroll, east or west. Use only 1
        // "else-if" statement.
        int currentAve = getAvenue();

        // Syntax Error -> -1 < currentAve < 7. Fixed
        if (currentAve > -1 && currentAve < 7)
        {
            System.out.println("You do not need to scroll to see the LoopyRobot");
        } else
        {
            if (currentAve < 0)
            {
                System.out.println("You need to scroll west to see the LoopyRobot");
            } else
            {
                System.out.println("You need to scroll east to see the LoopyRobot");
            }
        }
    }

    public static void main(String[] args)
    {
        City metro = new City();
        LoopyRobot2 loopy = new LoopyRobot2(metro, 0, 0, Direction.EAST, NUM_THINGS_INITIALLY_IN_BACKPACK);

        loopy.distributeThings();
    }
}
