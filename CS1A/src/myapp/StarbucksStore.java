package myapp;

// Note: Provided skeleton must be completed so that the test file successfully compiles and runs.
//
// TODO: Define a class of type Starbucks which keeps track of various attributes of a Starbucks
//      store location information and vote information.
public class StarbucksStore
{
    // TODO: Define the following attributes with "private" visibility:
    // "storeName" of type String, which is the name of the store
    // "location" of type String, which is the city location for the store
    // "state" of type String, which is the state the store is in
    // "RTWstate" of type boolean, which specifies whether the store is in a Right
    // Work State
    // "votedYes" of type int, which is the number of "yes" votes
    // "votedNo" of type int, which is the number of "no" votes
    // "result" of type boolean, which specifies whether to there were enough yes
    // votes to enable employees to unionize.

    // TODO: complete method signature to receive an argument for each attribute as
    // required by test class called TestStarBucks.
    // Should construct an object of type StarbuckStore by initializing the instance
    // variables and checks whether the result to unionize is true only if the
    // number of employees who voted Yes is more than the number of employees
    // who voted No.
    public StarbucksStore(/* TODO: complete method signature */)
    {
        // TODO: Initialize attributes

        // TODO: Use conditional statement to validate that the result is only false
        // if the number No votes is greater than or equal to the number of Yes votes,
        // otherwise print a message similar to the sample output.
    }

    // TODO: complete constructor such that it receives one argument of type String
    // for the storeName.
    // Initializes attributes by calling the constructor above using this() method
    // call passing in
    // the store name for the attribute storeName
    // the hard-coded String "unknown" for the location and state attributes
    // false for the RTWstate and result attributes
    // the hard-coded value 0 (i.e. zero) for the votedYes and votedNo attributes
    public StarbucksStore(/* TODO: complete method signature */)
    {
        // TODO: Initialize attribute by calling the constructor above using this()
        // method call passing in
        // the values described in the TODO method description
    }

    // TODO: Define a getter (i.e. accessor) method for storeName attribute
    // to receive zero arguments and to return a value of type String.

    // TODO: Define a getter (i.e. accessor) method for stateName attribute
    // to receive zero arguments and to return a value of type String.

    // TODO: Define a getter (i.e. accessor) method for RTWstate attribute
    // to receive zero arguments and to return a value of type boolean.

    // TODO: Define a getter (i.e. accessor) method for getVoteYes attribute
    // to receive zero arguments and to return a value of type boolean.

    // TODO: Define a getter (i.e. accessor) method for getVoteNo attribute
    // to receive zero arguments and to return a value of type boolean.

    // TODO: Define a getter (i.e. accessor) method for result attribute
    // to receive zero arguments and to return a value of type boolean.

    // TODO: Define a setter (i.e. mutator) method for storeName attribute
    // to receive an argument of type String,
    // and to return nothing.

    // TODO: Define a setter (i.e. mutator) method for location attribute
    // to receive an argument of type String,
    // and to return nothing.

    // TODO: Define a method called printStore which receives zero
    // arguments and does not return anything.
    // Prints to standard out a String representation of the instance including
    // the storeName, the location and the result of voting to unionize.
}
