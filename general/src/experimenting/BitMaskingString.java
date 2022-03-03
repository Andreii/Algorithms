package experimenting;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BitMaskingString {
    public static void main(String[] args) {
        System.out.printf("Palindromes found: %s\n", findPalindromes("leetcodecom"));

    }

    //
    // Run time: 2^n
    //
    public static List<String> findPalindromes(String input) {
        int n = input.length();
        List<String> palindromes = new ArrayList<>();

        for(int i = 1; i < (1 << n); i++) {
            String substr = "";
            for(int j = 0; j < n; j++) {
                if((i & 1 << j) > 0) {
                    substr += input.charAt(j);
                }
            }
            if(isPalindrome(substr)) palindromes.add(substr);
        }

        return palindromes;
    }

    public static boolean isPalindrome(String input) {
        StringBuilder sb = new StringBuilder(input);
        sb.reverse();
        return sb.toString().equals(input);
    }
}
