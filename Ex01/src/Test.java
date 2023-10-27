
public class Test
{
    public static void main(String[] args)
    {
        Test a  = new Test();
        int clientVal = 100;
        clientVal  = a.update(clientVal);
        System.out.println(clientVal);
    }
    
    public int update(int userIn)
    {
        ++userIn;
        return userIn;
    
 }
    
    
}
