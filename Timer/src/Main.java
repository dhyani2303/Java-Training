import java.time.Instant;
import java.util.Timer;
import java.util.TimerTask;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class MyTask extends TimerTask
{
    @Override
    public void run()
    {
        System.out.println("Task is executing" + Instant.now());
    }
}

public class Main
{
    public static void main(String[] args) throws InterruptedException
    {

        Timer timer = new Timer();


        for(int i = 0; i < 10; i++)
        {
            TimerTask timerTask = new MyTask();
            timer.schedule(timerTask, 0, 2000);

        }

        Thread.sleep(12000);
        timer.cancel();


    }
}