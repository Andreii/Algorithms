package util;

public class IntegerTriple implements Comparable<IntegerTriple> {
    Integer u,v,w;

    IntegerTriple(Integer first, Integer second, Integer third) {
        u = first;
        v = second;
        w = third;
    }

    Integer first() {
        return u;
    }

    Integer second() {
        return v;
    }

    Integer third() {
        return w;
    }

    @Override
    public int compareTo(IntegerTriple o) {
        if(!this.u.equals(o.u)) {
            return this.u - o.u;
        } else if(!this.v.equals(o.v)) {
            return this.v - o.v;
        } else {
            return this.w - o.w;
        }
    }

    public String toString() {
        return "(" + u + "," + v + "," + w + ")";
    }
}
