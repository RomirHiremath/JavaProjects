import java.util.Scanner;

/*
 * The PrintHelper class has the methods for printing various shapes
 * CS 1A Spring 2023
 * @author  Romir Hiremath
 */
class PrintHelper
{
    // Your methods to print various shapes goes here
    public void printStars(int width)
    {

        System.out.println("Stars:");
        if (width <= 0)
        {
            System.out.println("Invalid input, input positive number");
            return;
        }

        int whichCol = 0;
        while (whichCol <= width)
        {
            System.out.print("*");
            ++whichCol;
        }
        // Print just a new-line character
        System.out.println("");
    }

    public void printRectangle(int width, int height)
    {

        System.out.println("Rectangle:");
        if (width <= 0 || height <= 0)
        {
            System.out.println("Invalid input, input positive number");
            return;
        }

        for (int column = 0; column < height; column++)
        {

            for (int row = 0; row < width; row++)
            {
                System.out.print("*");

            }
            System.out.println("");
            System.out.println("");
        }

        // Print just a new-line character
        System.out.println("");

    }

    /*
     * printRectangleHollow: This should have the exact same parameters as
     * PrintRectangle, and should function similarly, except that any 'interior'
     * spaces should be filled with blank spaces, not asterisks.
     * 
     */
    public void printRectangleHollow(int width, int height)
    {

        System.out.println("Hollow Rectangle:");
        if (width <= 0 || height <= 0)
        {
            System.out.println("Invalid input, input positive number");
            return;
        }

        for (int column = 0; column < height; column++)
        {

            for (int row = 0; row < width; row++)
            {
                if (column == 0 || column == height - 1)
                {
                    System.out.print("*");
                } else
                {
                    if (row == 0 || row == width - 1)
                    {
                        System.out.print("*");
                    } else
                    {
                        System.out.print(" ");
                    }
                }

            }
            System.out.println("");
            System.out.println("");
        }

        // Print just a new-line character
        System.out.println("");

    }

    /*
     * printLeftTriangle This should have only a single parameter, height, which is
     * an integer. This method will print out a 'triangle', with a straight vertical
     * edge long the left side of the screen
     * 
     */
    public void printLeftTriangle(int height)
    {

        System.out.println("Left Triangle:");
        if (height <= 0)
        {
            System.out.println("Invalid input, input positive number");
            return;
        }

        for (int column = 0; column < height; column++)
        {

            for (int row = 0; row < height - column; row++)
            {
                System.out.print("*");

            }
            System.out.println("");
            System.out.println("");
        }

        // Print just a new-line character
        System.out.println("");

    }

}

public class PrintingShapes extends Object
{
    public static void main(String[] args)
    {
        // TODO: You will also add more code to this main method
        PrintHelper printer = new PrintHelper();

        // printer.printStars(7);
        // printer.printRectangle(7, 6);
        // printer.printRectangleHollow(7,6);

        // printer.printRectangle(7, -6);
        // printer.printLeftTriangle(9);

        int width = 0;
        int height = 0;

        System.out.println("Star");
        System.out.println("Hello!  How many stars would you like me to print?");
        width = inputAnInt();
        printer.printStars(width);

        System.out.println("Rectangle");
        System.out.println("For a rectangle, how wide should it be?");
        width = inputAnInt();
        System.out.println("For a rectangle, how high should it be?");
        height = inputAnInt();
        printer.printRectangle(width, height);

        System.out.println("HollowRectangle");
        System.out.println("For a Hollow Rectangle, how wide should it be?");
        width = inputAnInt();
        System.out.println("For a Hollow Rectangle, how high should it be?");
        height = inputAnInt();
        printer.printRectangleHollow(width, height);

        System.out.println("Left Triangle");
        System.out.println("For a Left Triangle, how high should it be?");
        height = inputAnInt();
        printer.printLeftTriangle(height);

    }

    /*
     * Static method to get a non negative Int as input Ask until a correct input is
     * given
     */
    public static int inputAnInt()
    {
        Scanner keyboard = new Scanner(System.in);
        boolean doneGettingInt = false;
        int userInput = 0;

        while (!doneGettingInt)
        {
            if (keyboard.hasNextInt()) // if user typed in a Int
            {
                // go and get the number
                userInput = keyboard.nextInt();
                keyboard.nextLine(); // newline flush to “clear the buffer”

                if (userInput >= 0)
                {
                    doneGettingInt = true;
                } else
                {
                    // Bad Int
                    System.out.println(userInput + " is not a valid input. Please enter a non negative number");
                }
            } else
            {
                // Bad input
                String next = keyboard.nextLine(); // newline flush
                System.out.println(next + " is not a valid input. Expecting a non negative number");
            }
        }
        return userInput;
    }

}
