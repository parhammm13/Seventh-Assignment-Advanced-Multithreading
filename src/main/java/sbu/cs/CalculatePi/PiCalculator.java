package sbu.cs.CalculatePi;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PiCalculator {
    public static int calculateN(int n){
        n =  n - 2;
        int a = 2 ;
        int r = 2 ;
        int result = a + (r *n );
        return result;
    }
    public static BigDecimal sum ;

    public static synchronized void addTouSum(BigDecimal value){
        sum = sum.add(value);
    }



    /**
     * Calculate pi and represent it as a BigDecimal object with the given floating point number (digits after . )
     * There are several algorithms designed for calculating pi, it's up to you to decide which one to implement.
     Experiment with different algorithms to find accurate results.

     * You must design a multithreaded program to calculate pi. Creating a thread pool is recommended.
     * Create as many classes and threads as you need.
     * Your code must pass all of the test cases provided in the test folder.

     * @param floatingPoint the exact number of digits after the floating point
     * @return pi in string format (the string representation of the BigDecimal object)
     */

    public String calculate(int floatingPoint)
    {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        sum = new BigDecimal("3");
        for(int i = 2 ; i < 1000000 ;  i++) {
            Denominator Task = new Denominator(i, floatingPoint);
            threadPool.execute(Task);
        }

        threadPool.shutdown();      // always call before awaitTermination

        try {
            threadPool.awaitTermination(10000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sum = sum.multiply(new BigDecimal(1), new MathContext(1001));
       sum = sum.multiply(new BigDecimal(1), new MathContext(floatingPoint + 1, RoundingMode.FLOOR));
        // TODO
//        String Sum = String.valueOf(sum);
//        String result = Sum.substring(0,( floatingPoint + 2 ) );
        return sum.toString();
    }

    public static void main(String[] args) {
    }
}
