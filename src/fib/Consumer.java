package fib;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 1. Take a value from s2, add value to sum and print the value.
 *
 * 2. When all values have been summed, print the total sum.
 *
 * @author Tobias Jacobsen
 */
public class Consumer implements Runnable {

    private final BlockingQueue<Long> s2;
    private long sum;
    private final int numberCount;

    public Consumer(BlockingQueue s2, int numberCount) {
        this.s2 = s2;
        sum = 0L;
        this.numberCount = numberCount;
    }

    // keep count of how many times we sum a value, so that we only sum values 
    // corresponding to the number of values in quoue
    @Override
    public void run() {
        int count = 0;
        while (count < numberCount) {
            try {
                long n = s2.take();
                sum += n;
                count++;
                System.out.println("Fibonacci: " + n);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NullPointerException e) {
                break;
            }
        }
        printSum();
    }

    private void printSum() {
        System.out.println("Total: " + sum);
    }
}
