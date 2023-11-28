import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        PrintServer printServer = new PrintServer();
        Producer user1 = new Producer(printServer);
        Producer user2 = new Producer(printServer);
        Producer user3 = new Producer(printServer);
        Producer user4 = new Producer(printServer);
        Consumer printer1 = new Consumer(printServer);
        Consumer printer2 = new Consumer(printServer);
        new Thread(user1).start();
        new Thread(user2).start();
        new Thread(user3).start();
        new Thread(user4).start();
        new Thread(printer1).start();
        new Thread(printer2).start();
        BlockingStack blockingStack = new BlockingStack();
        Random random = new Random();
        int number = random.nextInt(1, 101);
        WorkMan workMan = new WorkMan(blockingStack);
        User newUser1 = new User(blockingStack);
        User newUser2 = new User(blockingStack);
        new Thread(workMan).start();
        new Thread(newUser1).start();
        new Thread(newUser2).start();
    }
}