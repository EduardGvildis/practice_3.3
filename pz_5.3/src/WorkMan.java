import java.util.Random;

public class WorkMan implements Runnable{
    private BlockingStack blockingStack;

    public WorkMan(BlockingStack blocking) {
        this.blockingStack = blocking;
    }
    @Override
    public void run() {
        try {
            while (true) {
                blockingStack.pop();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
