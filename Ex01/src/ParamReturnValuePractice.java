/**
 * The Arrays_With_Loops_Part2 class has the methods CS 1A Spring 2023
 * 
 * @author Romir Hiremath
 *
 */

class PrintHelper extends Object
{

    public double[] getTemperatures()
    {
        double[] temps = new double[7];
        temps[0] = 5.6;
        temps[1] = 2;
        for (int i = 2; i < temps.length; i++)
            temps[i] = (i + 1) * 3 + 17;
        return temps;
    }

    /**
     * This method is used to print the double array.
     * 
     * @param doubarray This is the first paramter the input was double array
     *                  because the main had double array that was being passed
     * @return void This returns void because we don't want it to return anything,
     *         as we just print the output to console.
     */
    public void printArray(double[] doubarray)
    {
        for (int i = 0; i < doubarray.length; i++)
        {
            System.out.println(doubarray[i]);
        }
        // // print out all the elements of the array that will be passed
        // // to this method.
        // // This method (and all the others) should be able operate on the
        // // array that getTemperatures produces
    }

    /**
     * This method is used to get the average of double array
     * 
     * @param Passed double array because it was being passed
     * @return Returns average double value total divided by the length of doubarray
     */

    public double averageArray(double[] doubarray)
    {
        double total = 0;
        for (int i = 0; i < doubarray.length; i++)
        {
            total = total + doubarray[i];
        }
        return total / doubarray.length;
        // total up the array, then return the average
    }

    /**
     * This method is used to add 2 to each element in the array.
     * 
     * @param Passed double array because it was being passed
     * @return Returns the doubarray with 2 added to each element.
     */

    public double[] clonePlusTwo(double[] doubarray)
    {
        double[] clonearrayplus2 = new double[doubarray.length];
        for (int i = 0; i < doubarray.length; i++)
        {
            clonearrayplus2[i] = 2 + doubarray[i];
        }

        return clonearrayplus2;
        // create a new array, each element is 2 higher than the original
    }

    /**
     * This method is used to add 2 to each value in array
     * 
     * @param Passed double array because it was being passed
     * @return Returns an array with each of the same prior values but with 2 added.
     */

    public double[] upByTwo(double[] doubarray)
    {
        for (int i = 0; i < doubarray.length; i++)
        {
            doubarray[i] = 2 + doubarray[i];
        }
        return doubarray;
        // This method will be given an array. The method will then increase
        // the value of each element of that array by two.
    }

}

public class ParamReturnValuePractice extends Object
{
    public static void main(String[] args)
    {
        PrintHelper ph = new PrintHelper();

        double[] ts = new double[3];
        ts = ph.getTemperatures();
        System.out.println("Temperatures:");
        ph.printArray(ts);
        ph.upByTwo(ts);
        System.out.println("New Temperatures:");
        ph.printArray(ts);
        double[] clone2 = ph.clonePlusTwo(ts);
        ts[0] = 88;
        System.out.println("Cloned Temperatures");
        ph.printArray(clone2);
        System.out.println("Average of Cloned Temperatures" + ph.averageArray(clone2));
        
        //This is where we will write a while loop that sets the first 5 elements as numbers 6-10
        //below that is a for loop for printing the first 5 values of the array.
        double[] newarray = new double[5];
        int j = 0;
        while (j < newarray.length)
        {
            newarray[j] = j + 6;
            j++;
        }

        for (int i = 0; i < newarray.length; i++)
        {
            System.out.println(newarray[i]);
        }

    }
}
