import java.util.List;
import java.util.stream.IntStream;

public class Producer implements Runnable {
    private PrintServer printServer;

    public Producer(PrintServer printServer) {
        this.printServer = printServer;
    }
    @Override
    public void run() {
        try {
            while (true) {
                printServer.executePrintTask();
                // Додаткова логіка для друку завдань
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
