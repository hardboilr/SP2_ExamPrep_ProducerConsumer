#General part

>When and why will we use Threads in our programs?

Multithreading in Java means running multiple lines of code simultainously. Multi-threading enables the programmer to better utilize systems with multiple CPU cores, which can improve the performance of the application. Modern CPU designs favour cores over clock frequency. This CPU-design makes the CPU more energy-efficient while maintaining processing power. 
In practice, when creating swing-applications, the GUI will appear to freeze up when running longer proccesses on a single thread. When we introduce multiple threads, it is possible to always have one thread dedicated to user input while other threads can take care of the other relevant processes. 
Multithreading can also be utilized when creating network applications that have to service several users simultainously. 

>Explain about the Race Condition Problem

A "race condition" happens when multiple threads, in an uncontrolled manner, change a shared resource - they race to the shared resource. This can result in data inconsistencies. A "race condition" is one element of various concurrency problems in Java.

The solution is simply to ensure that the particular resource is only accessed by a single thread at one time. In Java this is typically done with synchronization. A method can be synchronized, ex. public synchronized void methodName() {} or inside a method with synchronized block, ex. synchronized (lockObject) {} or just synchronized (this) {}, although the latter has some pitfalls ( google it! :-) ). 
Primitive types can also be handled using Volatile when declaring the variable, ex. private volatile boolean isFinished. A volatile variable is written directly to memory thus bypassing the cache, which means that all threads see the same value for the variable at all times. 
Finally the Java.util.concurrent library expand on these basic principles further and provides more granular control and is possibly faster than synchronized (source: http://www.ibm.com/developerworks/library/j-jtp10264/).

>Explain about the Producer/Consumer-problem and how to solve it in modern Java Programs

The problem describes two processes, the producer and the consumer, who share a common, fixed-size buffer used as a queue. The producer's job is to generate a piece of data, put it into the buffer and start again. At the same time, the consumer is consuming the data (i.e., removing it from the buffer) one piece at a time. The problem is to make sure that the producer won't try to add data into the buffer if it's full and that the consumer won't try to remove data from an empty buffer.
An inadequate solution could result in a deadlock where both processes are waiting to be awakened. The problem can also be generalized to have multiple producers and consumers.
(source: https://en.wikipedia.org/wiki/Producer%E2%80%93consumer_problem)


>Execute the method with 1, 2, 3, and 4 as argument. Calculate the time it takes for each execution and explain (as good as you can) the result.

1 thread: It took: 2.35483 seconds using 1 threads
2 threads: It took: 3.095628 seconds using 2 threads.
3 threads: It took: 3.036024 seconds using 3 threads.
4 threads: It took: 3.025414 seconds using 4 threads.

The original sequence of numbers is as follows: 4, 5, 8, 12, 21, 22, 34, 35, 36, 37, 42. 

Calculating fibonacci numbers is O(2^n) - (source: http://stackoverflow.com/questions/360748/computational-complexity-of-fibonacci-sequence), which means that time grows expontially with a linear increase in n. From the outset the performance gain when using more than one thread should then be relatively modest, which is also evident from looking at the numbers above. The first half of the dataset is calculated relatively quickly whereas the last part takes significantly longer time. The last two or three numbers takes the longest time to calculate, so here we could expect to gain a little performance compared to using a single thread. 
In fact it seems to be faster using a single thread for the calculation. I suspect there is too much overhead when creating the threads that the payoff is lost. When minimizing the impact of the overhead, by increasing the computation time using fewer and larger input values, the application favours 4 threads over 1 thread.