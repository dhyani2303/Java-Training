import java.awt.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main
{
    public static void main(String[] args)
    {
        Map<String, Integer> map = new HashMap<>();


        String ipAddress;

        try
        {
            //File outputfile = new File("output.txt");
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter the number of packets ");

            int packetCount = Integer.parseInt(consoleReader.readLine());

            System.out.println("Enter the ip address");

            ipAddress = consoleReader.readLine();

            map.put(ipAddress, packetCount);

            Timer timer = new Timer();

            timer.scheduleAtFixedRate(new TimerTask()
            {
                @Override
                public void run()
                {
                    Main.CheckDeviceStatus(map);

                }
            }, 1000, 60000);
        } catch(IOException e)
        {
            throw new RuntimeException(e);
        } catch(NumberFormatException e)
        {
            System.out.println(e.toString());
        }


    }

    public static void CheckDeviceStatus(Map<String, Integer> map)
    {
        ProcessBuilder processBuilder = null;

        for(Map.Entry<String, Integer> e : map.entrySet())
        {
            processBuilder = new ProcessBuilder("fping", "-c", String.valueOf(e.getValue()), e.getKey());

            processBuilder.redirectErrorStream(true);

        }


        Process p = null;

        FileWriter writer = null;

        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formattedDateTime = now.format(formatter);

        try
        {
            writer = new FileWriter("/home/dhyani/IdeaProjects/JavaProgram/logfile.txt", true);

            p = processBuilder.start();

            InputStream inputStream = p.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));


            String line;

            int count = 0;

            while((line = reader.readLine()) != null)
            {
                // System.out.println("Output : " + line);

                if(line.contains(" 0% loss"))
                {
                    count++;
                }
            }


            if(count == 3)
            {
                System.out.println("Device is up");
            }
            else
            {
                writer.write("Device is down " + formattedDateTime + "\n");

                writer.flush();

                System.out.println("Device is down");
            }

            reader.close();

            p.waitFor();

        } catch(IOException | InterruptedException e)
        {
            throw new RuntimeException(e);
        } finally
        {
            try

            {
                if(writer != null)
                    writer.close(); // Close the FileWriter to save changes
            } catch(IOException e)
            {
                throw new RuntimeException(e);
            }
        }


    }
}