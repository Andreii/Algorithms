package solutions;

import utils.TreeNode;

import java.util.*;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be
 * stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the
 * same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
 * serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized
 * to a string and this string can be deserialized to the original tree structure.
 *
 * Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily
 * need to follow this format, so please be creative and come up with different approaches yourself.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,null,null,4,5]
 * Output: [1,2,3,null,null,4,5]
 * Example 2:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -1000 <= Node.val <= 1000
 */
public class _297_Serialize_and_deserialize_binary_tree {
    public static void dfsSerialize(TreeNode root, List<String> s) {
        if(root == null) {
            s.add("x");
            return;
        }

        s.add(String.valueOf(root.val));

        dfsSerialize(root.left, s);
        dfsSerialize(root.right, s);
    }

    public static String serialize(TreeNode root) {
        List<String> nodeList = new ArrayList<>();
        dfsSerialize(root, nodeList);
        return String.join(",", nodeList);
    }

    public static TreeNode deserialize(String root) {
        // create an iterator that returns a token each time we call `next`
        return deserializeDFS(Arrays.stream(root.split(",")).iterator());
    }

    private static TreeNode deserializeDFS(Iterator<String> nodes) {
        String val = nodes.next();
        if (val.equals("x")) return null;
        TreeNode cur = new TreeNode(Integer.parseInt(val));
        cur.left = deserializeDFS(nodes);
        cur.right = deserializeDFS(nodes);
        return cur;
    }
}
