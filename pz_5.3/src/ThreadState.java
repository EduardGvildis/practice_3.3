public class ThreadState {
    public static void main(String[] args) {
        BlockingStack<Integer> blockingStack = new BlockingStack<>();
        Thread produce = new Thread(()->{
            try {
                Thread.sleep(100);
                for (int i = 1; i <= 10; i++) {
                    blockingStack.push(i);
                    Thread.sleep(100); // TIMED_WAITING
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread consumer1 = new Thread(()->{
            try {
                Thread.sleep(200); //TIMED_WAITING
                for (int i = 0; i < 6; i++) {
                    blockingStack.pop();
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread consumer2 = new Thread(()->{
            try {
                Thread.sleep(200); // TIMED_WAITING
                for (int i = 0; i < 6; i++) {
                    blockingStack.pop();
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        new Thread(produce).start(); //NEW
        new Thread(consumer1).start(); //NEW
        new Thread(consumer2).start(); //NEW
        while (produce.isAlive() || consumer1.isAlive() || consumer2.isAlive()){ // TERMINATED
            System.out.println("Producer State: " + produce.getState());
            System.out.println("Consumer1 State: " + consumer1.getState());
            System.out.println("Consumer2 State: " + consumer2.getState());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
