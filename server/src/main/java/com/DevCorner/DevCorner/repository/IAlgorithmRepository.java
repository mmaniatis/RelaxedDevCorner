package com.DevCorner.DevCorner.repository;

import com.DevCorner.DevCorner.models.BinarySearchTree;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

public interface IAlgorithmRepository {
    int MaxDepthBinaryTree(BinarySearchTree tree);
    int[] TwoSum(int[] intArray , Integer target);
    int lengthOfLongestSubstring(String s);

}
