package com.DevCorner.DevCorner.controller;

import com.DevCorner.DevCorner.models.BinarySearchTree;
import com.DevCorner.DevCorner.models.TwoSumInput;
import com.DevCorner.DevCorner.repository.AlgorithmRepository;
import com.DevCorner.DevCorner.repository.IAlgorithmRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@SpringBootApplication
@RequestMapping("/api/Algorithm")
public class AlgorithmController {

    @Autowired
    private IAlgorithmRepository algoRepo;

    @PostMapping("/MaxDepthBinaryTree") //Returns the max depth in a given binary tree.
    public int MaxDepthBinaryTree(@RequestBody BinarySearchTree tree){
        return algoRepo.MaxDepthBinaryTree(tree);
    }

    @PostMapping("/TwoSum") //Returns the indices of the two numbers that add up to the target number.
    public int[] TwoSum(@RequestBody TwoSumInput tsi) {
        return algoRepo.TwoSum(tsi.intArray, tsi.target);
    }
}
