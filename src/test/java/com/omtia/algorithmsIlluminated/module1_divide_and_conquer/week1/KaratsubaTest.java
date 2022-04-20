/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.algorithmsIlluminated.module1_divide_and_conquer.week1;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class KaratsubaTest {

    @Test
    public void testKaratsuba() {
        BigInteger nr1 = new BigInteger("3141592653589793238462643383279502884197169399375105820974944592");
        BigInteger nr2 = new BigInteger("2718281828459045235360287471352662497757247093699959574966967627");
        BigInteger result = new BigInteger("8539734222673567065463550869546574495034888535765114961879601127067743044893204848617875072216249073013374895871952806582723184");

        assertEquals(Karatsuba.karatsuba(nr1, nr2), result);
    }
}