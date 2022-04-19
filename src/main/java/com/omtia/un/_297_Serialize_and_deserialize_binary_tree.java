package com.omtia.un;

import com.omtia.utils.TreeNode;

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
    public static void dfsSerialize(TreeNode root, List<String> out) {
        if(root == null) {
            out.add("x");
        } else {
            out.add(root.val + "");
            dfsSerialize(root.left, out);
            dfsSerialize(root.right, out);
        }
    }

    public static String serialize(TreeNode root) {
        List<String> out = new ArrayList<>();
        dfsSerialize(root, out);
        return String.join(",", out);
    }

    public static TreeNode dfsDeserialize(LinkedList<String> in) {
        String val = in.poll();
        if(val != null && val.equals("x")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = dfsDeserialize(in);
        root.right = dfsDeserialize(in);
        return root;
    }

    public static TreeNode deserialize(String root) {
        LinkedList<String> in = new LinkedList<>();
        String[] strings_arr = root.split(",");
        for(String s : strings_arr) {
            in.add(s);
        }
        return dfsDeserialize(in);
    }
}
