package algorithms;

import java.math.BigInteger;

public class Karatsuba {
    public static void main(String[] args) {

        BigInteger nr1 = new BigInteger("3141592653589793238462643383279502884197169399375105820974944592");
        BigInteger nr2 = new BigInteger("2718281828459045235360287471352662497757247093699959574966967627");

        System.out.printf("Result is %d", karatsuba(nr1,nr2, 64));
    }

    private static BigInteger karatsuba(BigInteger number1, BigInteger number2, int length) {
        if(length == 1) {
            return number1.multiply(number2);
        } else {
            int half = length / 2;
            // a,b = first and second half of number1
            // c,d = first and second half of number2
            // p = a + b,  q = c + d
            // recursive ac = a * c, bd = b * d, pq = p * q
            // adbc = pq - ac - bd
            // result = 10^2 * ac + 10^n/2 * adbc + bd
            BigInteger a = new BigInteger(number1.toString().substring(0,half));
            BigInteger b = new BigInteger((number1.toString().substring(half)).equals("") ? "0" : number1.toString().substring(half) );
            BigInteger c = new BigInteger(number2.toString().substring(0,half));
            BigInteger d = new BigInteger((number2.toString().substring(half)).equals("") ? "0" : number2.toString().substring(half) );
            BigInteger ac = karatsuba(a, c, half);
            BigInteger bd = karatsuba(b, d, half);
            BigInteger pq = karatsuba(a.add(b), c.add(d), half);
            BigInteger adbc = pq.subtract(ac).subtract(bd);

            return new BigInteger(String.valueOf((int)Math.pow(10, length)))
                    .multiply(ac)
                    .add(new BigInteger(String.valueOf((int)Math.pow(10, half))).multiply(adbc))
                    .add(bd);
        }
    }
}
