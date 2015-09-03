package fib;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.RunThis;

/**
 * @author Tobias Jacobsen
 *
 * Creates a number of producer threads in a loop. Create one consumer thread.
 * Start all threads. When all producer threads are done, then also stop
 * consumer thread and print sum.
 */
public class InitThreads {

    private List<Thread> threads;
    private int noOfThreads;
    private SharedData data;

    public InitThreads(int noOfThreads) {
        threads = new ArrayList();
        data = new SharedData();
        this.noOfThreads = noOfThreads;
    }

    public void start() {
        for (int i = 0; i <= noOfThreads; i++) {
            Thread t = new Thread(new Producer(data.getS1(), data.getS2()));
            t.start();
            threads.add(t);
        }
        Consumer c1 = new Consumer(data.getS2(), data.getNUMBER_COUNT());
        Thread t5 = new Thread(c1);
        t5.start();
        try {
            for (Thread t : threads) {
                t.join();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(RunThis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
