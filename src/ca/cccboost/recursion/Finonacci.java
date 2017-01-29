/*
 * Copyright (C) 2017 Tao Lu (Tao.CCC.Coach <at> gmail.com) - All Rights Reserved
 *
 * Unauthorized copying of this file is strictly prohibited.
 *
 */

package ca.cccboost.recursion;

import java.util.Arrays;
import java.util.Calendar;

/**
 * Class ca.cccboost.recursion.Finonacci
 *
 * Fib(n) = Fib(n - 1) + Fib(n - 2)
 *
 * @author <a href="mailto:Tao.CCC.Coach@gmail.com">Tao Lu</a>
 */
public class Finonacci {

    private static int MAX = 1000;

    public static void main(String[] args) {
        int[] numbers = { 5, 10, 50, 100, 500};
        final long startTime = System.currentTimeMillis();

//        for (int j = 0; j < 1000; j++) {
        for (int i : numbers) {
            System.out.println("Fib(" + i + ") = " + fib4(i));
        }
//        }

        final long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        System.out.println("Elapsed time: " + elapsed + "ms");
    }

    public static long fib1(int n) {
        // initial state
        if (n == 1 || n == 2) {
            return 1;
        }
        // recursive
        return fib1(n - 1) + fib1( n - 2);
    }

    static long[] memo = new long[MAX];
    static {
        Arrays.fill(memo, 0L);
    }

    public static long fib2(int n) {
        // base
        if (n == 1 || n == 2) {
            return 1;
        }

        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = fib2(n - 1) + fib2(n - 2);
        return memo[n];
    }


    public static long fib3(int n) {
        // bottom up
        memo[1] = memo[2] = 1;
        for (int i = 3; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    public static long fib4(int n) {
        long[] pair = fibonacciPair(n);
        return pair[0];
    }
    private static long[] fibonacciPair(int n) {
        if (n <= 1) {
            long[] answer = { n, 0 };
            return answer;
        }
        long[] temp = fibonacciPair(n - 1);
        long[] answer = { temp[0] + temp[1], temp[0] };
        return answer;
    }
}
