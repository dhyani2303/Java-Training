package FileSystem;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class File1 
{
    public static void main(String[] args)
    {
        try
        {
            //Creating a file
       File myFile = new File("File.txt");

       myFile.createNewFile();
       //  writing to a file
       FileWriter fileWriter = new FileWriter("File.txt");
       
       fileWriter.write("Hello");

       fileWriter.append("Today is friday");

    fileWriter.close();


       //Reading a file
    //    File myFile = new File("File.txt");
       Scanner sc = new Scanner(myFile);
       while(sc.hasNextLine()){
        String s = sc.nextLine();
        System.out.println(s);
       }

       sc.close();

       // Delete a file
      // File myFile = new File("File.txt");
      if(myFile.delete())
      {
        System.out.println("I have deletd "+ myFile.getName());

      }
      else
      {
        System.out.println("An error occured while deletinga file");
      }



        }
        catch(IOException e)
        {
             System.out.println(e);
        }

    }
    
}
