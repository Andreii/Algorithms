/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.algorithmsIlluminated.module1_divide_and_conquer.week1;

import java.math.BigInteger;

/**
 * Question 1
 * In this programming assignment you will implement one or more of the integer multiplication algorithms described in
 * lecture.
 *
 * To get the most out of this assignment, your program should restrict itself to multiplying only pairs of single-digit
 * numbers.  You can implement the grade-school algorithm if you want, but to get the most out of the assignment you'll
 * want to implement recursive integer multiplication and/or Karatsuba's algorithm.
 *
 * So: what's the product of the following two 64-digit numbers?
 *
 * 3141592653589793238462643383279502884197169399375105820974944592
 *
 * 2718281828459045235360287471352662497757247093699959574966967627
 *
 * [TIP: before submitting, first test the correctness of your program on some small test cases of your own devising.
 * Then post your best test cases to the discussion forums to help your fellow students!]
 *
 * [Food for thought: the number of digits in each input number is a power of 2.  Does this make your life easier?
 * Does it depend on which algorithm you're implementing?]
 *
 * The numeric answer should be typed in the space below.  So if your answer is 1198233847, then just type 1198233847
 * in the space provided without any space / commas / any other punctuation marks.
 *
 * (We do not require you to submit your code, so feel free to use any programming language you want --- just type the
 * final numeric answer in the following space.)
 */
public class Karatsuba {
    public static BigInteger karatsuba(BigInteger number1, BigInteger number2) {
        int length = Math.min(number1.toString().length(), number2.toString().length());
        int half = (int) Math.floor(length/2);

        if(length <= 2) {
            return number1.multiply(number2);
        } else {
            // a,b = first and second half of number1
            // c,d = first and second half of number2
            // p = a + b,  q = c + d
            // recursive ac = a * c, bd = b * d, pq = p * q
            // adbc = pq - ac - bd
            // result = 10^2 * ac + 10^n/2 * adbc + bd
            BigInteger a = new BigInteger(number1.toString().substring(0,number1.toString().length() - half));
            BigInteger b = new BigInteger(number1.toString().substring(number1.toString().length() - half));

            BigInteger c = new BigInteger(number2.toString().substring(0,number2.toString().length() - half));
            BigInteger d = new BigInteger(number2.toString().substring(number2.toString().length() - half));

            BigInteger ac = karatsuba(a, c);
            BigInteger bd = karatsuba(b, d);
            BigInteger pq = karatsuba(a.add(b), c.add(d));
            BigInteger adbc = pq.subtract(ac).subtract(bd);

            return (ac.multiply(new BigInteger("10").pow(half*2))).add(adbc.multiply(new BigInteger("10").pow(half))).add(bd);
        }
    }
}
