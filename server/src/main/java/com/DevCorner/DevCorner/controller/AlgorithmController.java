package com.DevCorner.DevCorner.controller;

import com.DevCorner.DevCorner.models.BinarySearchTree;
import com.DevCorner.DevCorner.repository.AlgorithmRepository;
import com.DevCorner.DevCorner.repository.IAlgorithmRepository;

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
    private final IAlgorithmRepository algoRepo;

    public AlgorithmController()
    {
        algoRepo = new AlgorithmRepository();
    }

    @PostMapping("/MaxDepthBinaryTree")
    public int MaxDepthBinaryTree(@RequestBody BinarySearchTree tree){
        return algoRepo.MaxDepthBinaryTree(tree);
    }

    @PostMapping("/TwoSum")
    public ArrayList<Integer> TwoSum(@RequestBody ArrayList<Integer> intArray) {
        return algoRepo.TwoSum(intArray);
    }
}
