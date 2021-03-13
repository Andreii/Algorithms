package algorithms;

public class Karatsuba {
    public static void main(String[] args) {
        System.out.printf("Sum is %.0f", karatsuba(9999, 9999, 4));
    }

    private static double karatsuba(int number1, int number2, int length) {
        if(length == 1) {
            return number1 * number2;
        } else {
            int half = length/2;
            int halfDivider = (int) Math.pow(10, half);
            // a,b = first and second half of number1
            // c,d = first and second half of number2
            // p = a + b,  q = c + d
            // recursive ac = a * c, bd = b * d, pq = p * q
            // adbc = pq - ac - bd
            // result = 10^2 * ac + 10^n/2 * adbc + bd
            int a = number1 / halfDivider;
            int b = number1 % halfDivider;
            int c = number2 / halfDivider;
            int d = number2 % halfDivider;
            int p = a + b;
            int q = c + d;
            double ac = karatsuba(a, c, half);
            double bd = karatsuba(b, d, half);
            double pq = karatsuba(p, q, half);
            double adbc = pq - ac - bd;
            return Math.pow(10, length) * ac + Math.pow(10, half) * adbc + bd;
        }
    }
}
