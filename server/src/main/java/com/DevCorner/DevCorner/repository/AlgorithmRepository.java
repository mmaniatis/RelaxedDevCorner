package com.DevCorner.DevCorner.repository;

import com.DevCorner.DevCorner.models.BinarySearchTree;
import com.DevCorner.DevCorner.models.TreeNode;


import java.util.ArrayList;

public class AlgorithmRepository implements IAlgorithmRepository {

    public int MaxDepthBinaryTree(BinarySearchTree tree){
        int depth = traverseAndReturnDepth(tree.root, 0);
        return depth;
    }

    public ArrayList<Integer> TwoSum(ArrayList<Integer> intArray)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();

        


        return result;
    }

    /* Helper Methods */
    private static int traverseAndReturnDepth(TreeNode root, int depth){
        if (root == null)
            return depth;
        int leftDepth = traverseAndReturnDepth(root.left, depth++);
        int rightDepth = traverseAndReturnDepth(root.right, depth++);
        return Math.max(leftDepth, rightDepth);
    }

}
