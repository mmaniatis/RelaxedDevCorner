package com.DevCorner.DevCorner.repository;

import com.DevCorner.DevCorner.models.BinarySearchTree;
import com.DevCorner.DevCorner.models.TreeNode;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlgorithmRepository implements IAlgorithmRepository {

    public int MaxDepthBinaryTree(BinarySearchTree tree){
        int depth = traverseAndReturnDepth(tree.root, 0);
        return depth;
    }

    public ArrayList<Integer> TwoSum(ArrayList<Integer> intArray, Integer target)
    {
        for (int i = 0; i < intArray.size(); i++)
        {
            for (int j = 0; j < intArray.size(); j++)
            {
                if (intArray.get(i) + intArray.get(j) == target)
                {
                    return new ArrayList<Integer>(Arrays.asList(i, j));
                }
            }
        }
        
        return new ArrayList<Integer>();
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
