package main;

import fib.InitThreads;

/**
 * Creates and starts 4 threads.
 *
 * Measures time between start and finish, and prints result.
 *
 * @author Tobias Jacobsen
 */
public class RunThis {

    public static void main(String[] args) {
        int noOfThreads = 4;

        long startTime = System.nanoTime();
        InitThreads init = new InitThreads(noOfThreads);
        init.start();
        long estimatedTime = System.nanoTime() - startTime;

        double result = (double) estimatedTime / 1000000000.0;
        System.out.println("It took: " + result + " seconds using " + noOfThreads + " threads.");
    }
}
