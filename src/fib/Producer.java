package fib;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 1. While s1 is not empty, take a value from it and calculate its fibonacci
 * number. 
 * 
 * 2. Put that fibonacci-number in the s2 queue.
 *
 * @author Tobias Jacobsen
 */
public class Producer implements Runnable {

    private final BlockingQueue<Long> s1;
    private final BlockingQueue<Long> s2;

    public Producer(BlockingQueue s1, BlockingQueue s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    // while we have items in the producer queue: (otherwise do nothing)
    // calculate fibonacci-number -> put calculated number in s2-queue
    @Override
    public void run() {
        Long number;
        while ((number = s1.poll()) != null) { // .poll returns null if queue is empty
            try {
                s2.put(fib(number));
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // calculates fibonacci number based on long input 
    // is a recursive method!: http://introcs.cs.princeton.edu/java/23recursion/ 
    private long fib(long n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}
