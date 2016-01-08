package fib;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Creates two blocking queues. One for raw values (s1) and one for calculated
 * values (s2). Fill s1 with values.
 *
 * @author Tobias Jacobsen
 */
public class SharedData {

    private BlockingQueue<Long> s1;
    private BlockingQueue<Long> s2;
    private final int NUMBER_COUNT = 11;

    public SharedData() {
        s1 = new ArrayBlockingQueue(NUMBER_COUNT);
        s2 = new ArrayBlockingQueue(NUMBER_COUNT);
        s1.add(4L);
        s1.add(5L);
        s1.add(8L);
        s1.add(12L);
        s1.add(21L);
        s1.add(22L);
        s1.add(34L);
        s1.add(35L);
        s1.add(36L);
        s1.add(37L);
        s1.add(42L);
    }

    public BlockingQueue getS1() {
        return s1;
    }

    public BlockingQueue getS2() {
        return s2;
    }

    public int getNUMBER_COUNT() {
        return NUMBER_COUNT;
    }
}
