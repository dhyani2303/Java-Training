import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLClass
{
    public static void main(String[] args)
    {
        try
        {
            URL url = new URL("https://www.javatpoint.com/InetAddress-class");

            URLConnection urlConnection = url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line = "";

            while((line = reader.readLine()) != null)
            {
                System.out.println(line);
            }
        } catch(MalformedURLException e)
        {
            throw new RuntimeException(e);

        } catch(IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
