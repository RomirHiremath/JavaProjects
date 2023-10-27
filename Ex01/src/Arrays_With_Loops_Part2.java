
import java.util.Scanner;

/**
 * The Arrays_With_Loops_Part2 class has the methods CS 1A Spring 2023
 * 
 * @author Romir Hiremath
 *
 */
public class Arrays_With_Loops_Part2 extends Object
{
    public static void main(String[] args)
    {

        // Create an grade array
        double[] myGrades = new double[5];

        // Use a while loop to input array elements' values

        Scanner keyboard = new Scanner(System.in);

        int i = 0;
        boolean doneGettingInput = false;
        while (i < myGrades.length)
        {

            doneGettingInput = false;
            while (!doneGettingInput)
            {
                System.out.print("Please enter your Grade: ");
                if (keyboard.hasNextDouble()) // if user typed in a double
                {
                    // go and get the number
                    myGrades[i] = keyboard.nextDouble();
                    keyboard.nextLine(); // newline flush to “clear the buffer”
                    doneGettingInput = true;
                } else
                {
                    // Bad input
                    String next = keyboard.nextLine(); // newline flush
                    System.out.print(next + " is NOT a double number! Please enter a double number: ");
                }

            }
            i++;

        }

        // Third: Use a for loop to print out the grade
        i = 0;

        System.out.println("You have entered the following grades");
        while (i < myGrades.length)
        {
            System.out.println(myGrades[i]);
            i++;
        }

        // Sum up the grades and get average Use a for loop to get the Total grade

        double total = 0.0;
        for (int k = 0; k < myGrades.length; k++)
        {
            total = total + myGrades[k];
        }

        System.out.println("Sum Total of all grades is: " + total + " Average of all Grades entered is: " + total / 5);

        double inputGrade = 0.0;

        // Get another double to check if it is in the Array
        doneGettingInput = false;
        while (!doneGettingInput)
        {

            System.out.print("Enter a Grade to find in the Grades Array: ");
            if (keyboard.hasNextDouble()) // if user typed in a whole number
            {
                // go and get the number
                inputGrade = keyboard.nextDouble();
                keyboard.nextLine(); // newline flush to “clear the buffer”
                doneGettingInput = true;
            } else
            {
                // Bad input
                String next = keyboard.nextLine(); // newline flush
                System.out.print(next + " is NOT a double number! Please enter a double number: ");
            }

        }

        i = 0;
        boolean found = false;
        while (i < myGrades.length)
        {
            if (inputGrade == myGrades[i])
            {
                // Match
                System.out.println("Found that grade " + inputGrade + " in the Array at index " + i);
                found = true;

            }

            i++;
        }

        if (!found)
        {
            System.out.println("Could NOT Find the Grade " + inputGrade + " in the Array");
        }

    }
}