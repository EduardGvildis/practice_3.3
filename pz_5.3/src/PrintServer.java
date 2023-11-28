import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintServer {
    private static final int MAX_QUEUE_SIZE = 10;
    private Queue<Integer> print = new LinkedList<>();
    PrintServer(){}
    public synchronized void addUserTask(int number) throws InterruptedException {
        while (print.size() >= MAX_QUEUE_SIZE) {
            wait();
        }
        print.add(number);
        System.out.println("User added task: " + number);
        notifyAll();
    }

    public synchronized void executePrintTask() throws InterruptedException {
        while (print.isEmpty()) {
            wait();
        }
        int number = print.poll();
        System.out.println("Printer completed task: " + number);
        notifyAll();
    }
}
