import becker.robots.*;

// STudents: Don't worry about these next import statements
import java.util.Random; // to generate random numbers

public class ICE_05_Race extends Object
{
   public static void main(String[] args)
   {
        City RaceCity = new City(4, 11);
        Random numberGenerator = new Random(); // don't worry about this line

        Thing baton = new Thing(RaceCity, 3, 0);

        // karel is the first racer (at the left)
		  // and always starts directly above the baton
        Robot karel = new Robot(RaceCity, 3, 0, Direction.EAST, 0);
        //karel.setColor(java.awt.Color.DARK_GRAY);

        // bob is the second racer (in the middle)
        Robot bob = new Robot(RaceCity, 2, 2 + numberGenerator.nextInt(3), Direction.EAST, 0);
		  bob.setColor(java.awt.Color.blue);
        // mary is the third racer (at the right)
        Robot mary = new Robot(RaceCity, 3, 5 + numberGenerator.nextInt(3), Direction.EAST, 0);
		  mary.setColor(java.awt.Color.green);

        /* karel should pick up the baton, then move to the intersection that bob is in.
           karel should drop the baton, bob should pick it up, and bob should then move
           to the intersection that mary is in. bob should drop the baton, mary should
           pick it up, and mary should then move 2 intersections east, and drop the baton.  */
		  
		  
		 // karel should pick up the baton
		  while (karel.canPickThing()) {
		  
		      karel.pickThing(baton);
		      System.out.println("Karel Picking");
		  }
		  
		  //then move to the intersection that bob is in
		  
		  while(karel.getAvenue() < bob.getAvenue()) {
		      karel.move();
              System.out.println("Karel Moving");

		  }  
		  int j = karel.countThingsInBackpack();
		  
		  //karel should drop the baton
		  
		  while ( j >0) {
		      karel.putThing(baton);
		      j = j-1;
              System.out.println("Karel putting");

		  }
		  
		  
		  //bob should pick it up
		  while (bob.canPickThing()) {
	          
		      bob.pickThing(baton);
              System.out.println("bob Picking");
          }
		  
		 // and bob should then move to the intersection that mary is in.
		  while(bob.getAvenue() < mary.getAvenue()) {
              bob.move();
              System.out.println("Bob  Moving");

          }   
		  
		 // bob should drop the baton
		   int k1 = bob.countThingsInBackpack();
	      
          while ( k1 >0) {
              bob.putThing(baton);
              k1 = k1-1;
              System.out.println("bob putting");

          }

	     
         // mary should pick it up     
          while (mary.canPickThing()) {
              
              mary.pickThing(baton);
              System.out.println("mary Picking");
          }
	          
	      // mary should then move 2 intersections east    
		  int l= 0;
		  while (l < 2) {
		  
		      mary.move();
		      l  = l +1;
		      System.out.println("mary moving");
		  }

		  //and drop the baton. 
		  
	       int m = mary.countThingsInBackpack();
	          
	       while ( m >0) {
	          mary.putThing(baton);
	          m = m-1;
	          System.out.println("mary putting");

	        }
		  
		  System.out.println(karel.getAvenue());

          System.out.println(bob.getAvenue());
          System.out.println(mary.getAvenue());

   }
}


