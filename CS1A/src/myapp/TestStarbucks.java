package myapp;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Note: Provided test class is complete. Adding additional test cases are
 * optional.
 *
 * Assess declaration, initialization and usage of Classes. Assess evaluation of
 * boolean statements, conditional statements, loop structures. Assess usage of
 * Exceptions.
 */
public class TestStarbucks
{
    /**
     * Hard-coded 2D array representation of sbwu_elections.csv data input file.
     * Note: 2D array should not be referenced outside of this class. The number of
     * indices SAMPLE_CSV_DATA_IN_ROWS may change.
     */
    private final static String[][] SAMPLE_CSV_DATA_IN_ROWS =
    {
            { "20th Street and 3rd Ave", "Birmingham", "AL", "Yes", "4/11/22", "5/26/22", "45", "27", "1", "28", "33",
                    "0.8485", "0.9286", "0.9643", "Yes" },
            { "Katella & Los Alamitos", "Los Alamitos", "CA", "No", "3/16/22", "5/23/22", "68", "2", "11", "13", "19",
                    "0.6842", "-0.6923", "0.1538", "No" },
            { "Clares & 41st", "Capitola", "CA", "No", "3/30/22", "6/6/22", "68", "8", "3", "11", "21", "0.5238",
                    "0.4545", "0.7273", "Yes" },
            { "Katella & Anaheim", "Anaheim", "CA", "No", "3/28/22", "6/9/22", "73", "10", "1", "11", "29", "0.3793",
                    "0.8182", "0.9091", "Yes" },
            { "Downtown Disney Store", "Anaheim", "CA", "No", "3/28/22", "6/16/22", "80", "29", "15", "44", "90",
                    "0.4889", "0.3182", "0.6591", "Yes" },
            { "Hwy 111 & Jefferson, La Quinta", "La Quinta", "CA", "No", "4/11/22", "6/21/22", "71", "5", "4", "9",
                    "35", "0.2571", "0.1111", "0.5556", "Yes" },
            { "2nd & Covina", "Long Beach", "CA", "No", "4/11/22", "6/21/22", "71", "3", "5", "8", "22", "0.3636",
                    "-0.25", "0.375", "No" },
            { "Citrus & Rowland", "Covina", "CA", "No", "4/11/22", "6/21/22", "71", "7", "10", "17", "36", "0.4722",
                    "-0.1765", "0.4118", "No" },
            { "Mason & Lassen", "Los Angeles", "CA", "No", "2/2/22", "6/29/22", "147", "6", "9", "15", "35", "0.4286",
                    "-0.2", "0.4", "No" },
            { "Burton & Rosemont", "Grand Rapids", "MI", "Yes", "3/7/22", "5/13/22", "67", "15", "3", "18", "30", "0.6",
                    "0.6667", "0.8333", "Yes" },
            { "Main & Liberty", "Ann Arbor", "MI", "Yes", "2/4/22", "6/7/22", "123", "10", "3", "13", "19", "0.6842",
                    "0.5385", "0.7692", "Yes" },
            { "South University & Church", "Ann Arbor", "MI", "Yes", "2/4/22", "6/7/22", "123", "10", "2", "12", "29",
                    "0.4138", "0.6667", "0.8333", "Yes" },
            { "State & Liberty", "Ann Arbor", "MI", "Yes", "2/4/22", "6/7/22", "123", "15", "1", "16", "33", "0.4848",
                    "0.875", "0.9375", "Yes" },
            { "Jackson & Zeeb", "Ann Arbor", "MI", "Yes", "1/28/22", "6/7/22", "130", "10", "2", "12", "29", "0.4138",
                    "0.66 67", "0.8333", "Yes" },
            { "Glencoe Crossing", "Ann Arbor", "MI", "Yes", "1/28/22", "6/7/22", "130", "14", "0", "14", "30", "0.4667",
                    "1", "1", "Yes" },
            { "Grand River & Stoddard", "East Lansing", "MI", "Yes", "3/7/22", "6/9/22", "94", "19", "0", "19", "32",
                    "0.5938", "1", "1", "Yes" },
            { "Miller Road & I-75", "Flint", "MI", "Yes", "3/7/22", "6/9/22", "94", "13", "6", "19", "26", "0.7308",
                    "0.3684", "0.6842", "Yes" },
            { "Lake Lansing & Kerry St", "Lansing", "MI", "Yes", "2/4/22", "6/9/22", "125", "13", "3", "16", "37",
                    "0.4324", "0.625", "0.8125", "Yes" },
            { "S. Saginaw Street", "Grand Blanc", "MI", "Yes", "1/28/22", "6/9/22", "132", "8", "13", "21", "30", "0.7",
                    "-0.2381", "0.381", "No" },
            { "The Mall at Partridge Creek", "Clinton Township", "MI", "Yes", "1/28/22", "6/9/22", "132", "8", "3",
                    "11", "15", "0.7333", "0.4545", "0.7273", "Yes" },
            { "Carpenter Rd.", "Ann Arbor", "MI", "Yes", "4/12/22", "6/17/22", "66", "15", "2", "17", "38", "0.4474",
                    "0.7647", "0.8824", "Yes" } };

    /**
     * Tests the Starbucks class. Then, tests for valid data type and value.
     * 
     * @param args not used.
     */
    public static void main(String[] args)
    {
        TestStarbucks tester = null;

        // Constructs an object to set up application to creates objects of type
        // Starbucks and test the objects.
        tester = new TestStarbucks();

        // load data
        StarbucksStore sample = tester.createOneStore();
        // Only proceed if we can initialize a Starbucks store.
        if (sample == null)
        {
            String message = "Error in main(): Unable to initialize the first Starbucks store."
                    + "Check project description and test file.";
            throw new RuntimeException(message);
        }

        // Test accessing the name of the state a store resides in
        tester.testGetStateName();

        // load data
        // Note: The data is loaded from the hard-coded 2D array. You do not
        // need to read from the CSV file.
        // However, your implementation needs to be flexible to different
        // number of StarbucksStore objects. Refer to the CSV file under
        // resources for further testing.
        StarbucksStore[] sampleStarbucksStores = tester.loadSampleData();

        // Only proceed if we initialized Starbucks stores.
        if (sampleStarbucksStores == null)
            System.err.println("\nWarning! main(): Unable to initialize Starbucks stores.");
        else
            System.out.println("\nIn main(): Found " + sampleStarbucksStores.length
                    + " number of stores in our Starbucks corporation.");

        // Test StarbucksCorporation's addStores method
        tester.testAddStores();

        // Outputs all stores
        System.out.println("\nIn main(): Displaying all stores.");
        tester.theStarbucksCorporation.printAllStores();

        // Outputs name of all stores found for a more concise output
        tester.printStoreNames();

        // Check for valid Right To Work status.
        tester.testGetRTWstate();

        // Checks whether stores voted Yes to unionize.
        tester.testGetVoteResult();

        // Tests accessor method for the total number of stores with Right-to-Work laws.
        tester.testGetNumRTW();

        // Tests accessor method for the total number of stores that have a yes for the
        // result of the vote.
        tester.testGetNumYesVoteResults();

        // Checks is exceptions are caught
        tester.testStarbucksCorporationMain();
        System.out.println("In main(): Done.");
    } // end of main

    /**
     * Keeps track of all StarbucksStore elements that are added to the corporation.
     * Enables asking some questions about the store data stored via accessor
     * methods.
     */
    private StarbucksCorporation theStarbucksCorporation;

    /**
     * Constructs an object of type StarbucksCorporation by passing in the number of
     * stores in sample data. Note: The number of indices SAMPLE_CSV_DATA_IN_ROWS
     * may change.
     */
    public TestStarbucks()
    {
        int numberOfStoresInCorporation = SAMPLE_CSV_DATA_IN_ROWS.length;
        theStarbucksCorporation = new StarbucksCorporation(numberOfStoresInCorporation);
    }

    /**
     * Constructs one object of type StarbucksStore and tests whether the store was
     * initialized correctly with the expected hard-coded values.
     * 
     * @return the hard-coded StarbuckStore.
     */
    public StarbucksStore createOneStore()
    {
        // Declares a reference of type Starbucks
        StarbucksStore current;

        // Initialize an object of type Starbucks with hard-coded values
        current = new StarbucksStore("CS1ACafe");
        // Tries to update the store name.
        try
        {
            current.setStoreName("1234 El Monte Road");
        } catch (Exception receivedExc)
        {
            System.err.println("Warning! createOneStore(): Invalid store name. Unable to update.");
            receivedExc.printStackTrace();
        }
        // Tries to update the store location
        try
        {
            current.setStoreLocation("Los Altos Hills, CA");
        } catch (Exception receivedExc)
        {
            System.err.println("Warning! createOneStore(): Invalid store name. Unable to update.");
            receivedExc.printStackTrace();
        }

        // Access the store name.
        System.out.println("In createOneStore(): Created store with name \"" + current.getStoreName() + "\":");

        // Outputs a representation of the Starbucks object by including the storeName,
        // location and
        // the result of voting to unionize.
        current.printStore();

        return current;
    }

    /**
     * Initializes an array of type Starbucks to hold a fixed number of objects.
     * 
     * @return a one-dimensional array of StarbucksStore elements.
     */
    public StarbucksStore[] loadSampleData()
    {
        for (String[] data : SAMPLE_CSV_DATA_IN_ROWS)
        {
            StarbucksStore store;

            String storeName = data[0];
            String storeLocation = data[1];
            String stateAbbreviation = data[2];
            boolean hasRightToWork = data[3].equals("Yes");
            int numVotesYes = Integer.parseInt(data[7]);
            int numVotesNo = Integer.parseInt(data[8]);
            boolean result = data[14].equals("Yes");

            // Initializes a Starbucks object
            store = new StarbucksStore(storeName, storeLocation, stateAbbreviation, hasRightToWork, numVotesYes,
                    numVotesNo, result);

            // Determines whether the store can be added to one of states we want to test
            // Note: Ideally we would create a representation for each state.
            // Here, only testing a few states.
            theStarbucksCorporation.addStore(store);
        } // end of iterating over all data

        return theStarbucksCorporation.getAllStores();
    }

    /**
     * Prints to standard output the name of all stores in the order stored.
     */
    private void printStoreNames()
    {
        String[] names;
        names = theStarbucksCorporation.getStoreNames();
        System.out.println("In printStoreNames(): Found " + names.length + " stores in Starbucks corporation.");
        for (String name : names)
        {
            System.out.println(name);
        }
    }

    /**
     * Tests if addStores will behave correctly if you try to add too many stores.
     */
    private void testAddStores()
    {
        System.out.println("\nIn testAddStores(): "
                + "testing if addStores will behave correctly if you try to add too many stores.");

        final boolean EXPECTED_TEST_CASE_RESULT_1 = false;
        try
        {
            // theStarbucksCorporation should be full already after loadSampleData was
            // called
            if (theStarbucksCorporation.sizeOfCorporation() == TestStarbucks.SAMPLE_CSV_DATA_IN_ROWS.length)
            {
                // Try to add another StarbucksStore
                StarbucksStore store = new StarbucksStore("Generic StarbucksStore");
                boolean actualResultTestCase1 = theStarbucksCorporation.addStore(store);
                if (actualResultTestCase1 == EXPECTED_TEST_CASE_RESULT_1)
                {
                    System.out.println("Passed in testAddStores(): "
                            + "When trying to add another StarbucksStore to a full theStarbucksCorporation, addStore returned "
                            + actualResultTestCase1 + ".");
                } else
                {
                    System.err.println("Failed in testAddStores(): "
                            + "When trying to add another StarbucksStore to a full theStarbucksCorporation, addStore returned "
                            + actualResultTestCase1 + " when it should have returned " + EXPECTED_TEST_CASE_RESULT_1
                            + ".");
                }
            } else
            {
                System.err.println("Failed in testAddStores(): "
                        + "theStarbucksCorporation should have been full already after loadSampleData was called.");
            }
        } catch (Exception receivedExc)
        {
            System.err.println("Failed in testAddStores(): "
                    + "Trying to call theStarbucksCorporation.addStore() resulted in an Exception.\n");
            receivedExc.printStackTrace();
        }

    }

    /**
     * Tests accessor method for the total number of stores with Right-to-Work laws.
     */
    private void testGetNumRTW()
    {
        System.out.println("\nIn testGetNumRTW(): testing getting the total number of stores with Right-to-Work laws.");

        // Tests the store's result whether to unionize.
        final int EXPECTED_TEST_CASE_RESULT_1 = 13;
        try
        {
            int actualResultTestCase1 = theStarbucksCorporation.getNumRTW();
            if (actualResultTestCase1 == EXPECTED_TEST_CASE_RESULT_1)
            {
                System.out.println("Passed in testGetNumRTW(): "
                        + "found the total number of stores with Right-to-Work laws to be " + actualResultTestCase1
                        + ".");
            } else
            {
                System.err.println(
                        "Failed in testGetNumRTW(): found invalid total number of stores with Right-to-Work laws to be "
                                + actualResultTestCase1 + " when it should have been " + EXPECTED_TEST_CASE_RESULT_1
                                + ".");
            }
        } catch (Exception receivedExc)
        {
            System.err.println("Failed in testGetNumRTW(): "
                    + "Trying to call theStarbucksCorporation.getNumRTW() resulted in an Exception.\n");
            receivedExc.printStackTrace();
        }
    }

    /**
     * Tests accessor method for the total number of stores that chose to unionize.
     */
    private void testGetNumYesVoteResults()
    {
        System.out.println("\nIn testGetNumYesVoteResults(): "
                + "testing getting the total number of stores that chose to unionize.");

        // Tests the store's result whether to unionize.
        final int EXPECTED_TEST_CASE_RESULT_1 = 16;
        try
        {
            int actualResultTestCase1 = theStarbucksCorporation.getNumYesVoteResults();
            if (actualResultTestCase1 == EXPECTED_TEST_CASE_RESULT_1)
            {
                System.out.println("Passed in testGetNumYesVoteResults(): "
                        + "found the total number of stores that chose to unionize to be " + actualResultTestCase1
                        + ".");
            } else
            {
                System.err.println("Failed in testGetNumYesVoteResults(): "
                        + "found invalid total number of stores that chose to unionize to be " + actualResultTestCase1
                        + " when it should have been " + EXPECTED_TEST_CASE_RESULT_1 + ".");
            }
        } catch (Exception receivedExc)
        {
            System.err.println("Failed in testGetNumYesVoteResults(): "
                    + "Trying to call theStarbucksCorporation.getNumYesVoteResults() resulted in an Exception.\n");
            receivedExc.printStackTrace();
        }
    }

    /**
     * Tests if Right to Work status is valid.
     */
    private void testGetRTWstate()
    {
        System.out.println("\nIn testGetRTWstate(): testing select stores Right to Work status.");
        StarbucksStore storeToTest;
        int storeNum;

        // Tests the store's Right-to-Work requirement.
        final boolean TEST_CASE_RTW_1 = true;
        storeNum = 0;
        try
        {
            storeToTest = theStarbucksCorporation.getStoreNumber(storeNum);
            if (storeToTest.getRTWstate() == TEST_CASE_RTW_1)
            {
                System.out.println("Passed in testGetRTWstate(): for " + storeToTest.getStoreName()
                        + " found RTW to be " + storeToTest.getRTWstate() + ".");
            } else
            {
                System.err.println(
                        "Failed in testGetRTWstate(): for " + storeToTest.getStoreName() + " found invalid RTW to be "
                                + storeToTest.getRTWstate() + " when it should have been " + TEST_CASE_RTW_1 + ".");
            }
        } catch (Exception receivedExc)
        {
            System.err.println("Failed in testGetRTWstate(): Requested store at index " + storeNum + " is invalid.");
            receivedExc.printStackTrace();
        }

        // Tests the store's Right-to-Work requirement.
        final boolean TEST_CASE_RTW_2 = false;
        storeNum = 1;
        try
        {
            storeToTest = theStarbucksCorporation.getStoreNumber(storeNum);
            if (storeToTest.getRTWstate() == TEST_CASE_RTW_2)
            {
                System.out.println("Passed in testGetRTWstate(): for " + storeToTest.getStoreName()
                        + " found RTW to be " + storeToTest.getRTWstate() + ".");
            } else
            {
                System.err.println(
                        "Failed in testGetRTWstate(): for " + storeToTest.getStoreName() + " found invalid RTW to be "
                                + storeToTest.getRTWstate() + " when it should have been " + TEST_CASE_RTW_2 + ".");
            }
        } catch (Exception receivedExc)
        {
            System.err.println("Failed in testGetRTWstate(): Requested store at index " + storeNum + " is invalid.");
            receivedExc.printStackTrace();
        }
    }

    /**
     * Tests accessing the name of the state a store resides in
     */
    private void testGetStateName()
    {
        System.out.println("\nIn testGetStateName(): testing getting the name of the state a store resides in.");

        // Tests the store's result whether to unionize.
        final String EXPECTED_TEST_CASE_RESULT_1 = "CA";
        try
        {
            StarbucksStore store = new StarbucksStore("", "", EXPECTED_TEST_CASE_RESULT_1, false, 0, 0, false);
            String actualResultTestCase1 = store.getStateName();
            if (actualResultTestCase1 == EXPECTED_TEST_CASE_RESULT_1)
            {
                System.out.println("Passed in testGetStateName(): "
                        + "found the name of the state the store resides in to be " + actualResultTestCase1 + ".");
            } else
            {
                System.err.println(
                        "Failed in testGetStateName(): found the name of the state the store resides in to incorrectly be "
                                + actualResultTestCase1 + " when it should have been " + EXPECTED_TEST_CASE_RESULT_1
                                + ".");
            }
        } catch (Exception receivedExc)
        {
            System.err.println("Failed in testGetStateName(): "
                    + "Trying to call getStateName(0 on a StarbucksStore resulted in an Exception.\n");
            receivedExc.printStackTrace();
        }
    }

    /**
     * Tests if whether stores voted Yes to unionize.
     */
    private void testGetVoteResult()
    {
        System.out.println("\nIn testGetVoteResult(): testing select stores on whether they voted yes to unionize.");
        StarbucksStore storeToTest;
        int storeNum;

        // Tests the store's result whether to unionize.
        final boolean TEST_CASE_RESULT_1 = true;
        storeNum = 0;
        try
        {
            storeToTest = theStarbucksCorporation.getStoreNumber(storeNum);
            if (storeToTest.getVoteResult() == TEST_CASE_RESULT_1)
            {
                System.out.println("Passed in testGetVoteResult(): for " + storeToTest.getStoreName()
                        + " found vote to be " + storeToTest.getVoteResult() + ".");
            } else
            {
                System.err.println("Failed in testGetVoteResult(): for " + storeToTest.getStoreName()
                        + " found invalid vote to be " + storeToTest.getVoteResult() + " when it should have been "
                        + TEST_CASE_RESULT_1 + ".");
            }
        } catch (Exception receivedExc)
        {
            System.err.println("Failed in testGetRTWstate(): Requested store at index " + storeNum + " is invalid.\n");
            receivedExc.printStackTrace();
        }

        // Tests the store's result whether to unionize.
        final boolean TEST_CASE_RESULT_2 = false;
        storeNum = 1;
        try
        {
            storeToTest = theStarbucksCorporation.getStoreNumber(storeNum);
            if (storeToTest.getVoteResult() == TEST_CASE_RESULT_2)
            {
                System.out.println("Passed in testGetVoteResult(): for " + storeToTest.getStoreName()
                        + " found vote to be " + storeToTest.getVoteResult() + ".");
            } else
            {
                System.err.println("Failed in testGetVoteResult(): for " + storeToTest.getStoreName()
                        + " found invalid vote to be " + storeToTest.getVoteResult() + " when it should have been "
                        + TEST_CASE_RESULT_2 + ".");
            }
        } catch (Exception receivedExc)
        {
            System.err.println("Failed in testGetRTWstate(): Requested store at index " + storeNum + " is invalid.");
            receivedExc.printStackTrace();
        }
    }

    /**
     * Tests StarbucksCorporation's main method by running it.
     */
    private void testStarbucksCorporationMain()
    {
        System.out.println(
                "\nIn testStarbucksCorporationMain(): Tests StarbucksCorporation's main method by running it.");
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        final PrintStream out = System.out;
        final PrintStream err = System.err;
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        // run the main method in StarbucksCorporation
        try
        {
            StarbucksCorporation.main(new String[0]);
        } catch (Exception receivedExc)
        {
            System.err.println(
                    "Failed: Warning! Exceptions are NOT being caught inside the StarbucksCorporation.main method.");
            receivedExc.printStackTrace();
        }
        System.setOut(out);
        System.setErr(err);
        System.out.println("outContent:");
        System.out.println(outContent.toString());
        System.out.println("errContent:");
        if (errContent.size() > 0)
        {
            System.err.println(errContent.toString());
            System.err.println(
                    "Failed: Error! Exceptions are likely NOT being caught inside the StarbucksCorporation.main method.");
        } else
        {
            System.out.println("Passed in testStarbucksCorporationMain():");
        }
    }
}
