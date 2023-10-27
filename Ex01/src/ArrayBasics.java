public class ArrayBasics
{

    public static void main(String[] args)
    {
       
            int [] myAr;
            myAr = new int[3];
            myAr[0] = 3;
            myAr[1] = 4-1;
            int i = 2;
            myAr[i] = 6 * 2;
            System.out.println( myAr[0] );
            System.out.println( myAr[i - 1] );
            System.out.println( myAr[2] );
            int temp = myAr[1] + myAr[2];
            System.out.println(temp);
       
    }

}