/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.ctci.Arrays_and_Strings;

public class _1_3_URLify_ctci_solution {
    public static void replaceSpaces(char[] str, int trueLength) {
        int numberOfSpace = countOfChar(str, 0, trueLength, ' ');
        int newIndex = trueLength -1 + numberOfSpace * 2;

        if (newIndex + 1 < str.length) str[newIndex + 1] = '\0';
        for (int oldIndex = trueLength - 1; oldIndex >= 0; oldIndex -= 1) {
            if (str[oldIndex] == ' ') {
                str[newIndex] = '0';
                str[newIndex - 1] = '2';
                str[newIndex - 2] = '%';
                newIndex -= 3;
            } else {
                str[newIndex] = str[oldIndex];
                newIndex -= 1;
            }
        }
    }

    public static int countOfChar(char[] str, int start, int end, char target) {
        int result = 0;
        for ( int i = start; i < end; i++) {
            if (str[i] == target) result ++;
        }
        return result;
    }

    public static int findLastCharacter(char[] str) {
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i] != ' ') {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "Mr John Smith    ";
        char[] arr = str.toCharArray();
        int trueLength = findLastCharacter(arr) + 1;
        replaceSpaces(arr, trueLength);
        System.out.println("\"" + new String(arr) + "\"");
    }
}
