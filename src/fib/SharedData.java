package fib;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Tobias Jacobsen
 *
 * Creates two blocking queues. One for raw values (s1) and one for calculated
 * values (s2). Fill s1 with values.
 *
 */
public class SharedData {

    private BlockingQueue s1;
    private BlockingQueue s2;

    public SharedData() {
        s1 = new ArrayBlockingQueue(11);
        s2 = new ArrayBlockingQueue(11);
        try {

            /*
             Fibonacino is: 3
             Fibonacino is: 5
             Fibonacino is: 21
             Fibonacino is: 144
             Fibonacino is: 17711
             Fibonacino is: 10946
             Fibonacino is: 5702887
             Fibonacino is: 9227465
             Fibonacino is: 14930352
             Fibonacino is: 24157817
             Fibonacino is: 267914296
             Sum is: 321961647
             ###It took: 3.053541 seconds using 1 threads.###
             ###It took: 3.138015 seconds using 4 threads.###
            
             */
            s1.put(4L);
            s1.put(5L);
            s1.put(8L);
            s1.put(12L);
            s1.put(21L);
            s1.put(22L);
            s1.put(34L);
            s1.put(35L);
            s1.put(36L);
            s1.put(37L);
            s1.put(42L);

            /*
             Fibonacino is: 701408733
             Fibonacino is: 1134903170
             Fibonacino is: 1836311903
             Fibonacino is: 2971215073
             Sum is: 6643838879
             ###It took: 48.411506 seconds using 1 threads.###
             ###It took: 43.086148 seconds using 4 threads.###
            
             */
//            s1.put(44L);
//            s1.put(45L);
//            s1.put(46L);
//            s1.put(47L);
        } catch (InterruptedException ex) {
            Logger.getLogger(SharedData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public BlockingQueue getS1() {
        return s1;
    }

    public BlockingQueue getS2() {
        return s2;
    }

}
