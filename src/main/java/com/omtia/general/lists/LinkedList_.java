/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.general.lists;

import java.util.LinkedList;

public class LinkedList_ {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        // add to end
        // add
        // offer
        // addLast
        list.offer(3);
        list.add(4);
        list.offer(5);
        list.add(6);
        list.addLast(7);

        // add to start
        // push
        list.addFirst(0);
        list.push(1);
        list.push(2);

        // remove from end
        list.removeLast();
        list.pollLast();

        // remove from start
        list.removeFirst(); // exception
        list.remove(); // exception
        list.pop(); // exception
        list.poll(); // NO exception

        // peek
        // check first
        list.peek();
        list.peekFirst();
        // check last
        list.peekLast();

        System.out.println("List with offer: ");
        for(Integer e : list) {
            System.out.print(e + ",");
        }
    }
}
