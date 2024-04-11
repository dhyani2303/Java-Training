import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStream
{
    public static void main(String[] args) throws IOException
    {
        byte[] b = "This is dhyani".getBytes();

        ByteArrayInputStream inputStream = new ByteArrayInputStream(b);

        inputStream.read(b);

        File newFile = new File("./file.txt");

        FileOutputStream outputStream = new FileOutputStream(newFile);

        outputStream.write(b);
    }
}
