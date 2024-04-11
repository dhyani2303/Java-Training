public class Exception1{
    public static void main(String[] args){
        int i=1,j=0;
        int k;
        try{
            k=i/j;
        }
        catch(ArithmeticException e){
            System.out.println("Number cannot be divided by zero");
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            System.out.println("Hello from finally block");        }
    }
}