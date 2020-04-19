package com.DevCorner.DevCorner.repository;

import com.DevCorner.DevCorner.models.BinarySearchTree;
import com.DevCorner.DevCorner.models.TreeNode;


import java.lang.reflect.Array;
import java.util.*;

public class AlgorithmRepository implements IAlgorithmRepository {

    public int MaxDepthBinaryTree(BinarySearchTree tree){
        int depth = traverseAndReturnDepth(tree.root, 0);
        return depth;
    }

    public ArrayList<Integer> TwoSum(ArrayList<Integer> intArray, Integer target)
    {
        ArrayList<Integer> sums = new ArrayList<>(); //arrayList we will return
        HashMap<Integer, Integer> hash = new HashMap<>(); //hash table to track the pairings
        for (int i = 0; i < intArray.size(); i++)
        {
            if (hash.containsKey(intArray.get(i))) // if our hash has this number as a key, it means we found the other pair already
            {
                sums.add(hash.get(intArray.get(i))); //return the pair
                sums.add(i);
                return sums;
            }
            else //no pair has been found yet
            {
                int sumMinusTarget = target - intArray.get(i); //target - current index, add to hash table for future use
                hash.put(sumMinusTarget, i);
            }
        }
        
        return sums; //return the pair if any
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
