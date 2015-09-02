package fib;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Tobias Jacobsen
 *
 * While shouldRun is true take a value from s2 and add it to an array until s2
 * is empty. printSum calculates the sum of all values from the array and print
 * it.
 *
 */
public class Consumer implements Runnable {

    private BlockingQueue s2;
    private List<Long> list;
    private boolean shouldRun;

    public Consumer(BlockingQueue s2) {
        shouldRun = true;
        this.s2 = s2;
        list = new ArrayList();
    }

    @Override
    public void run() {
        while (shouldRun) {
            if (!s2.isEmpty()) {
                System.out.println("Fibonacino is: " + s2.peek());
                try {
                    list.add((Long) s2.take());
                } catch (InterruptedException ex) {
                    Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void printSum() {
        long sum = 0;
        for (Long n : list) {
            sum = sum + n;
        }
        System.out.println("Sum is: " + sum);
    }

    public void setShouldRun(boolean value) {
        shouldRun = value;
    }

}
