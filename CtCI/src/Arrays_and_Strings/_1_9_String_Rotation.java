package Arrays_and_Strings;

public class _1_9_String_Rotation {

    public boolean isSubstring(String s1, String s2) {
        return false;
    }

    boolean isRotation (String s1, String s2) {
        if ( s1.length() != s2.length() ) {return false;}
        int n = s1.length();


        // s1
        // waterbottle
        // wa terbottle
        // wat erbottle

        // s2
        // erbottlewat
        // erbottlew at
        // erbottle wat

        for (int i = 1; i < n; i ++) {
            String s1_substring_left = s1.substring(0, i);
            String s1_substring_right = s1.substring(i);

            String s2_substring_left = s2.substring(0, n - 1 - i);
            String s2_substring_right = s2.substring(n - 1 - i);

            if (s1_substring_right.equals(s2_substring_right) && s1_substring_left.equals(s2_substring_right)) {
                return isSubstring(s1, s2);
            }
        }

        return false;
    }

    boolean isRotationCtCI (String s1, String s2) {
        // guard
        if (s1.length() != s2.length() && s1.length() > 0) return false;

        String s1s1 = s1+s1;

        return isSubstring(s1s1, s2);
    }
}
