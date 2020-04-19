package com.DevCorner.DevCorner.repository;

import com.DevCorner.DevCorner.models.BinarySearchTree;

import java.util.ArrayList;

public interface IAlgorithmRepository {
    int MaxDepthBinaryTree(BinarySearchTree tree);
    ArrayList<Integer> TwoSum(ArrayList<Integer> intArray , Integer target);

}
