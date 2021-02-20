package algorithms;

public class Bitwise {
    public static void main(String[] args) {
        int number = 2;

        printBinary(number);

        // shift left
        number = number << 1;
        printBinary(number);

        // set bit on
        number |= 1<<3;
        number |= 1<<4;
        number |= 1<<6;
        printBinary(number);

        // check if bit is on
        int check = number & (1<<2);
        printBinary(check);
        check = number & (1<<5);
        printBinary(check);

        // toggle bit
        number ^= 1<<6;
        printBinary(number);

        // clear bit
        // create mask
        number &= ~(1<<2);
        printBinary(number);

        // least significant bit
        number &= ~(number) + 1;
        printBinary(number);
    }

    /**
     *
     * @param number
     */
    private static void printBinary(int number) {
        System.out.println(String.format("%16s", Integer.toBinaryString(number)).replace(' ', '0')
                + " " + number);
    }
}
