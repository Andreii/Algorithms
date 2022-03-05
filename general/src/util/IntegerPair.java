package util;

public class IntegerPair implements Comparable<IntegerPair> {
    Integer u,v;

    IntegerPair(Integer first) {
        u = first;
        v = 0;
    }

    public IntegerPair(Integer first, Integer second) {
        u = first;
        v = second;
    }

    @Override
    public int compareTo(IntegerPair o) {
        if(!this.u.equals(o.u)) {
            return this.u - o.u;
        } else {
            return this.v - o.v;
        }
    }

    Integer first() {
        return u;
    }
    Integer second() {
        return v;
    }

    public String toString() {
        return "( " + u + "," + v + ")";
    }
}
