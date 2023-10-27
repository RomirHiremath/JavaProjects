class ArrayHelper2 extends Object {
    public void printArray(int[] someArrayOfInts) {
        for (int element : someArrayOfInts) {
            System.out.println(element);
        }
    }
    public void findMaxInArray(int[] someArrayOfInts) {
        int max = -1; // Assuming all data is positive
        int locationOfMax = -1;
        for (int i = 0; i < someArrayOfInts.length; ++i) {
            if (someArrayOfInts[i] > max) {
                max = someArrayOfInts[i];
                locationOfMax = i;
            }
        }
        if (locationOfMax != -1) {
            System.out.println("The largest value in the array is: " + max);
            System.out.println("The location of the largest value in the array is: " + locationOfMax);
        }
    }
}

public class Quiz19 extends Object {
    public static void main(String[] args) {
        ArrayHelper2 ah = new ArrayHelper2();

        // Now set up the array stuff, which is more interesting:
        int[] shortArray = new int[4];
        int i;
        for (i = 0; i < shortArray.length; i++) {
            shortArray[i] = (i + 1) * 2;
        }

        int[] longArray = new int[14];
        // We want to put numbers into the long array in reverse order
        // we should thus count DOWN through the slot numbers,
        // and simultaneously have counter count UP
        int counter = 0;
        for (i = longArray.length - 1; i >= 0; i--) {
            longArray[i] = (counter + 1) * 3;
            counter++;
        }
        System.out.println("Short Array: ");
        ah.printArray(shortArray);
        System.out.println("Long Array:  ");
        ah.printArray(longArray);
        ah.findMaxInArray(shortArray);
        ah.findMaxInArray(longArray);
    }
}
