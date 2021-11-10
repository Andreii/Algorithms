package algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

//This file describes an instance of the problem. It has the following format:
//
//[number_of_symbols]
//
//[weight of symbol #1]
//
//[weight of symbol #2]
//
//...
//
//For example, the third line of the file is "6852892," indicating that the weight of the second symbol of the alphabet
// is 6852892.  (We're using weights instead of frequencies, like in the "A More Complex Example" video.)
//
//Your task in this problem is to run the Huffman coding algorithm from lecture on this data set.
// What is the maximum length of a codeword in the resulting Huffman code?
//
//ADVICE: If you're not getting the correct answer, try debugging your algorithm using some small test cases.
// And then post them to the discussion forum!

public class Huffman {

    static class Node {
        int weight, count;
        public Node(int weight, int count) {
            this.weight = weight;
            this.count = count;
        }
    }
    public static void main(String[] args) {
        try {

            Scanner scanner = new Scanner(new File("general/resources/huffman.txt"));

            int count = Integer.parseInt(scanner.nextLine());
            List<Node> weights = new ArrayList<>();

            while(scanner.hasNext()) {
                int weight = Integer.parseInt(scanner.nextLine());
                weights.add(new Node(weight, 0));
            }

            PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
                @Override
                public int compare(Node left, Node right) {
                    return left.weight - right.weight;
                }
            });

            queue.addAll(weights);

            while(queue.size() >= 2) {
                Node item1 = queue.remove();
                Node item2 = queue.remove();

                Node newItem = new Node(
                        item1.weight + item2.weight,
                        Math.max(item1.count, item2.count) + 1 // max bit
//                        Math.min(item1.count, item2.count) + 1 -> min bit
                );

                queue.add(newItem);
            }

            System.out.println(queue.poll().count);

        } catch (FileNotFoundException e) { }
    }
}
