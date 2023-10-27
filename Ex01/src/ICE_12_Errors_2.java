/** Romir Hiremath
 *  CS F001A OBJ-ORIENTED PROG METHOD JAVA 02W Weusijana 40472
 *  2023 Spring
 *  Version 1.0

 */
import becker.robots.*;

// This robot will be able to keep track of how many
// moves it's made, and then be able to print a message to
// the user saying that.
class MoveRobot extends Robot
{
    int numberOfMovesMade = 0; // Corrected Type int not defined
    int numberOfLeftTurnsMade = 0; // adding left turn counter

    MoveRobot(City c, int st, int ave, Direction dir, int num)
    {
        super(c, st, ave, dir, num);
    }

    public void moveCounted()
    {
        this.move();
        this.numberOfMovesMade = this.numberOfMovesMade + 1; //Changed multiploer * 2 to addition + 1 

        
    }

    public void printNumberOfMoves()
    {
        System.out.println("Since I started counting, I moved:");
        System.out.println(this.numberOfMovesMade);
        System.out.println("times!");
    }

    /**
     * adding this method for keeping track of left turns
     */
    public void leftTurnsCounted()
    {
        this.turnLeft();
        this.numberOfLeftTurnsMade = this.numberOfLeftTurnsMade + 1;
    }

    /**
     * adding this method for print number of left turns
     */
    public void printNumberOfLeftTurns()
    {
        System.out.println("Since I started counting, I moved left:");
        System.out.println(this.numberOfLeftTurnsMade);
        System.out.println("times!");
    }
}

public class ICE_12_Errors_2 extends Object
{
    public static void main(String[] args)
    {
        City ForgetsVille = new City();
        MoveRobot mary = new MoveRobot(ForgetsVille, 4, 1, Direction.EAST, 0);
        new Wall(ForgetsVille, 2, 5, Direction.NORTH);
        // CityFrame frame = new CityFrame(ForgetsVille); //CityFrame is not a class
        // under robots (commenting the code)

        // First keep track of these 4
        mary.moveCounted();
        mary.moveCounted();
        mary.moveCounted();
        mary.moveCounted();
        mary.printNumberOfMoves();

        // mary.turnLeft();
        mary.leftTurnsCounted(); // calling the new method

        while (mary.frontIsClear())
        {
            mary.moveCounted(); // Move counted is method adding paranthesis will now move till the front is clear
        }
        mary.printNumberOfMoves(); // Missing . operator to call the printnumber of moves
        mary.printNumberOfLeftTurns();// calling newly added left turn method
    }
}
