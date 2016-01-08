package fib;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.RunThis;

/**
 * 1. Creates and starts a number of producer threads, corresponding to number
 * of specified threads.
 *
 * 2. Create and start one consumer thread.
 *
 * 3. Wait for all threads to finish.
 *
 * @author Tobias Jacobsen
 */
public class InitThreads {

    private final List<Thread> threads; //the Thread-object extends Object and implements Runnable
    private final int noOfThreads; // the number of threads we want to utilize
    private final SharedData data; // the raw data we want to calculate

    public InitThreads(int noOfThreads) {
        threads = new ArrayList();
        data = new SharedData();
        this.noOfThreads = noOfThreads;
    }

    public void start() {
        // create producer threads with Producer runnables and put those in a list
        for (int i = 0; i <= noOfThreads; i++) {
            Thread t = new Thread(new Producer(data.getS1(), data.getS2()));
            t.start();
            threads.add(t);
        }

        // create a single consumer thread with a Consumer runnable
        Consumer c1 = new Consumer(data.getS2(), data.getNUMBER_COUNT());
        Thread t5 = new Thread(c1);
        t5.start();
        threads.add(t5);

        // wait for all threads to finish their job
        try {
            for (Thread t : threads) {
                t.join();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(RunThis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
