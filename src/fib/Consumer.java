package fib;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
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

    private BlockingQueue <Long> s2;
    private long sum;
    private boolean shouldRun;
    private int numberCount;

    
    
    public Consumer(BlockingQueue s2, int numberCount) {
        shouldRun = true;
        this.s2 = s2;
        sum = 0L;
        this.numberCount = numberCount;
    }

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

    public void printSum() {
        System.out.println("Total: " + sum);
        
    }

    public void setShouldRun(boolean value) {
        shouldRun = value;
    }

}
