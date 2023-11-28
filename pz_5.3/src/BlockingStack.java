import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingStack <T>{
    Stack<T> stack;
    Lock locker;
    Condition isFull;
    Condition isEmpty;
    static final int CAPACITY = 4;
    int size;
    public BlockingStack() {
        this.stack = new Stack<>();
        this.locker = new ReentrantLock();
        this.isFull = locker.newCondition();
        this.isEmpty = locker.newCondition();
        this.size = 0;
    }
    public void push(T t) throws InterruptedException {
        locker.lock();
        try {
            while (size == CAPACITY) {
                System.out.println("Stack add await " + t);
                isFull.await(); //TIMED WAITED
            }
            stack.add(t);
            size++;
            System.out.println("Stack add number " + t);
            isEmpty.signalAll();
        } finally {
            locker.unlock(); // BLOCKING
        }
    }

    public T pop() throws InterruptedException {
        locker.lock();
        try {
            while (size == 0) {
                System.out.println("Stack remove await");
                isEmpty.await(); // TIMED WAITED
            }
            T t = stack.pop();
            size--;
            System.out.println("Stack remove " + t);
            isFull.signalAll();
            return t;
        } finally {
            locker.unlock(); //BLOCKING
        }
    }
}
