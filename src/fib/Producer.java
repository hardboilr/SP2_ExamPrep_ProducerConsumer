package fib;

import java.util.Observable;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tobias Jacobsen
 *
 * While s1 is not empty take a value from it and calculate its fibonacci
 * number. put the fibonacci-number in the s2 queue.
 */
public class Producer implements Runnable {

    private BlockingQueue s1;
    private BlockingQueue s2;
    private long n;
    private Consumer consumer;

    public Producer(BlockingQueue s1, BlockingQueue s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public void run() {
        while (!s1.isEmpty()) {
            long input = (Long) s1.poll();
            long output = fib(input);
            try {
                s2.put(output);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private long fib(long n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

}
