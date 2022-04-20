/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.ctci.Linked_List;

import java.util.HashMap;

public class _2_1_Remove_Dups {
    // Remove Dups: Write code to remove duplicates from an unsorted linked list.
    static class Node {
        Node next;
        int data;
        public Node(int data) {
            this.data = data;
        }
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    static class LinkedList {
        public static Node removeNode(Node root, int d) {
            if (root == null) return null;
            Node n = root;

            if(n.data == d) return root.next;

            while(n.next != null) {
                if(n.next.data == d) {
                    n.next = n.next.next;
                    return root;
                }
                n = n.next;
            }

            return root;
        }
        public static void appendNode(Node root, Node newNode) {
            Node n = root;

            while(n.next != null) {
                n = n.next;
            }

            n.next = newNode;
        }
        public static void printNodes(Node node) {
            System.out.print("Node :");
            Node n = node;
            while(n != null) {
                System.out.printf("[%d],", n.data);
                n = n.next;
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        // init
        Node linkedList = new Node(3);
        LinkedList.appendNode(linkedList, new Node(5));
        LinkedList.appendNode(linkedList, new Node(2));
        LinkedList.appendNode(linkedList, new Node(4));
        LinkedList.appendNode(linkedList, new Node(7));
        LinkedList.appendNode(linkedList, new Node(-2));
        LinkedList.appendNode(linkedList, new Node(4));
        LinkedList.appendNode(linkedList, new Node(6));
        LinkedList.appendNode(linkedList, new Node(5));

        LinkedList.printNodes(linkedList);

        HashMap<Integer, Boolean> duplicates = new HashMap<>();
        Node previous = null;
        Node n = linkedList;
        while(n != null) {
            if(duplicates.containsKey(n.data)) {
                previous.next = n.next;
            } else {
                duplicates.put(n.data, true);
                previous = n;
            }

            n = n.next;
        }

        LinkedList.printNodes(linkedList);
    }
}
