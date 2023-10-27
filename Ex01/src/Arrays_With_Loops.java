import java.util.Scanner;

/**
 * The PrintHelper class has the methods for printing various shapes CS 1A
 * Spring 2023
 * 
 * @author Romir Hiremath
 *
 */
public class Arrays_With_Loops extends Object
{
    public static void main(String[] args)
    {

        // First: Create an array
        double[] myArray = new double[5];

        // set in while loop to set the array elements' values 1-5
        double d = 1.0;
        int i = 0;
        while (i < 5)
        {
            myArray[i] = d;

            i++;
            d++;
        }

        // Print array or loop to print out the array

        i = 0;
        while (i < 5)
        {
            System.out.println(myArray[i]);
            i++;
        }
    }
}