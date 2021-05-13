package algorithms;

import java.math.BigInteger;

public class Karatsuba {
    public static void main(String[] args) {

        BigInteger nr1 = new BigInteger("3141592653589793238462643383279502884197169399375105820974944592");
        BigInteger nr2 = new BigInteger("2718281828459045235360287471352662497757247093699959574966967627");


        System.out.printf("Result is %s", karatsuba(nr1,nr2).toString());
    }

    private static BigInteger karatsuba(BigInteger number1, BigInteger number2) {
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
