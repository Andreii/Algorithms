package Arrays_and_Strings;

import java.util.LinkedHashMap;
import java.util.Map;

public class _1_6_String_Compression {
    public static String compress(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count++;
            if(i + 1 >= s.length() || s.charAt(i) != s.charAt(i+1)) {
                sb.append(s.charAt(i));
                sb.append(count);
                count = 0;
            }
        }

        return sb.toString().length() < s.length() ? sb.toString() : s;
    }
    public static void main(String[] args) {
        System.out.println(compress("aabcccccaaa"));
    }
}
