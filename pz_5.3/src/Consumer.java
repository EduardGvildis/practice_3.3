import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Consumer implements Runnable  {
     private PrintServer printServer;
    public Consumer(PrintServer printServer) {
        this.printServer = printServer;
    }

    @Override
    public void run() {
        try {
            Random random = new Random();
            int number =  random.nextInt(3,6);
            printServer.addUserTask(number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
