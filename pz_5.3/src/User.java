import java.util.Random;

public class User implements Runnable{
    private BlockingStack blockingStack;
    public User(BlockingStack blockingStack) {
        this.blockingStack = blockingStack;
    }

    @Override
    public void run() {
        try {
            Random random = new Random();
            int number =  random.nextInt(1,101);
            blockingStack.push(number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
