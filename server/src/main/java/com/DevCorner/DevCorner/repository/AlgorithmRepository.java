package com.DevCorner.DevCorner.repository;
import com.DevCorner.DevCorner.models.BinarySearchTree;
import com.DevCorner.DevCorner.models.ListNode;
import com.DevCorner.DevCorner.models.TreeNode;
import java.util.*;

public class AlgorithmRepository implements IAlgorithmRepository {

    //given a binary tree, return the maximum depth present in the tree.
    public int MaxDepthBinaryTree(BinarySearchTree tree){
        return traverseAndReturnDepth(tree.root);
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

    //Reverse String
    public void reverseString(char[] s) {
        for(int i = 0, j = s.length-1; i < j; i++, j--)
        {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        System.out.println(s);
    }

    //Single Number
    public int singleNumber(int[] nums)
    {
        HashSet<Integer> set = new HashSet<>();
        int result = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (!set.contains(nums[i]))
            {
                set.add(nums[i]);
            }
            else
                set.remove(nums[i]);
        }

        for(int x : set)
        {
            result = x;
        }
        return result;
    }

    //Fizz-Buzz
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i < n+1; i++)
        {
            if (i%3 == 0 && i%5 ==0)
                res.add("FizzBuzz");
            else if (i%3==0)
                res.add("Fizz");
            else if (i%5==0)
                res.add("Buzz");
            else
                res.add(String.valueOf(i));
        }
        return res;
    }

    //Reverse Linked List
    public ListNode reverseList(ListNode head) {
        Stack<Integer> reverseStack = new Stack<>();

        if (head == null || head.next ==null)
            return head;

        while (head.next != null)
        {
            reverseStack.add((head.val));
            head=head.next;
        }

        ListNode result = new ListNode (head.val);
        ListNode headResult = result;

        while (reverseStack.size() > 0)
        {
            result.next = new ListNode(reverseStack.pop());
            result = result.next;
        }
        return headResult;
    }

    /* Helper Methods */
    private static int traverseAndReturnDepth(TreeNode root){
        if (root == null)
            return 0;
        int leftDepth = traverseAndReturnDepth(root.left);
        int rightDepth = traverseAndReturnDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }

}
