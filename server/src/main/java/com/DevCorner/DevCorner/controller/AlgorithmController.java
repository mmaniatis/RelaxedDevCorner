package com.DevCorner.DevCorner.controller;

import com.DevCorner.DevCorner.models.TreeNode;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@RequestMapping("/api/Algorithm")
public class AlgorithmController {

    @PostMapping("/MaxDepthBinaryTree")
    public static int MaxDepthBinaryTree(@RequestBody TreeNode root){
        int depth = traverse(root, 0);
        return depth;
    }

    public static int traverse(TreeNode root, int depth){
        if (root == null)
            return depth;
        int leftDepth = traverse(root.left, depth++);
        int rightDepth = traverse(root.right, depth++);
        return Math.max(leftDepth, rightDepth);
    }
}
