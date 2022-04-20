/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.cp4;

import java.util.Scanner;

public class cp4_1_3_4_1 {
    public static void main(String[] args) {
        task2();
    }

    public static void task1() {
        Scanner scanner = new Scanner(System.in);
        double number = scanner.nextDouble();
        System.out.printf("%7.3f\n", number);
    }

    public static void task2() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        String pi_digits = "14159265358979323846264338327950288419716939937510";
        pi_digits = pi_digits.replace(".", "");
        System.out.println("N digits: " + pi_digits.substring(0, number));
    }
}
