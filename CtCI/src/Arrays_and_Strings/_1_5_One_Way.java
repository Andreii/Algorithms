package Arrays_and_Strings;

public class _1_5_One_Way {
    static boolean oneAway(String one, String two) {

        int lenDiff = Math.max(one.length(), two.length()) - Math.min(one.length(), two.length());
        String longest;
        String shortest;

        if (one.length() > two.length()) {
            longest = one;
            shortest = two;
        } else {
            longest = two;
            shortest = one;
        }

        if (one.length() == two.length()) {
            return oneReplace(one, two);
        } else if ( lenDiff == 1 ) {
            return oneDiff(longest, shortest);
        } else {
            return false;
        }
    }

    static boolean oneReplace(String one, String two) {
        int allowedEdits = 1;
        for (int i = 0; i < one.length(); i++ ) {
            if (one.charAt(i) != two.charAt(i)) allowedEdits --;
            if (allowedEdits < 0) return false;
        }
        return true;
    }

    static boolean oneDiff(String one, String two) {
        int indexA = 0;
        int indexB = 0;
        int allowedEdits = 1;

        // pale, ple
        while(indexB < two.length()) {
            if (one.charAt(indexA) != two.charAt(indexB)) {
                allowedEdits--;
                indexA++;
            } else {
                indexA++;
                indexB++;
            }

            if (allowedEdits < 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(oneAway("pale", "bale"));
        System.out.println(oneAway("pale", "ple"));
        System.out.println(oneAway("paler", "pale"));
        System.out.println(oneAway("baler", "pale"));
        System.out.println(oneAway("palsr", "pale"));
    }
}
