import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStream
{
    public static void main(String[] args) throws IOException
    {
        FileReader fr = new FileReader("./file.txt");
        FileWriter fw = new FileWriter("./files.txt");
        int i;
        while((i = fr.read()) != -1)
        {
            fw.write((char) i);

        }
        fr.close();
        fw.close();
    }
}
