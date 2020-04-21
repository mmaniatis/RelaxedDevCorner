package com.DevCorner.DevCorner.repository;
import com.DevCorner.DevCorner.models.BinarySearchTree;
import com.DevCorner.DevCorner.models.TreeNode;
import java.util.*;

public class AlgorithmRepository implements IAlgorithmRepository {

    //given a binary tree, return the maximum depth present in the tree.
    public int MaxDepthBinaryTree(BinarySearchTree tree){
        int depth = traverseAndReturnDepth(tree.root, 0);
        return depth;
    }

    //returns two indices of numbers that sum to the target
    public int[] TwoSum(int[] intArray, Integer target)
    {
        int[] sums = new int[2]; //list we will return
        HashMap<Integer, Integer> hash = new HashMap<>(); //hash table to track the pairings
        for (int i = 0; i < intArray.length; i++)
        {
            if (hash.containsKey(intArray[i])) // if our hash has this number as a key, it means we found the other pair already
            {
                sums = new int[] {hash.get(intArray[i]), i}; //return the pair

                return sums;
            }
            else //no pair has been found yet
            {

                hash.put(target - intArray[i], i); //target - current index, index of this total 
            }
        }
        
        return sums; //return the pair if any
    }

    //Returns the longest substring in a given string.
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        HashSet<Character> set = new HashSet<>();

        for (int i = 0, j = 0; j < s.length();) {
            if (!set.contains(s.charAt(j)))
            {
                set.add(s.charAt(j));
                j++;
                result = Math.max(result,set.size());
            }
            else
            {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return result;
    }

    //Medium of two sorted arrays.

    /* Helper Methods */
    private static int traverseAndReturnDepth(TreeNode root, int depth){
        if (root == null)
            return depth;
        int leftDepth = traverseAndReturnDepth(root.left, depth++);
        int rightDepth = traverseAndReturnDepth(root.right, depth++);
        return Math.max(leftDepth, rightDepth);
    }

}
