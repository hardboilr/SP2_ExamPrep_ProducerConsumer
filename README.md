#Notes

>Execute the method with 1, 2, 3, and 4 as argument. Calculate the time it takes for each execution and explain (as good as you can) the result.

1 thread: It took: 2.35483 seconds using 1 threads
2 threads: It took: 3.095628 seconds using 2 threads.
3 threads: It took: 3.036024 seconds using 3 threads.
4 threads: It took: 3.025414 seconds using 4 threads.

The original sequence of numbers is as follows: 4, 5, 8, 12, 21, 22, 34, 35, 36, 37, 42. 

Calculating fibonacci numbers is O(2^n) - (source: http://stackoverflow.com/questions/360748/computational-complexity-of-fibonacci-sequence), which means that time grows expontially with a linear increase in n. From the outset the performance gain when using more than one thread should then be relatively modest, which is also evident from looking at the numbers above. The first half of the dataset is calculated relatively quickly whereas the last part takes significantly longer time. The last two or three numbers takes the longest time to calculate, so here we could expect to gain a little performance compared to using a single thread. 
In fact it seems to be faster using a single thread for the calculation. I suspect there is too much overhead when creating the threads that the payoff is lost. When minimizing the impact of the overhead, by increasing the computation time using fewer and larger input values, the application favours 4 threads over 1 thread.