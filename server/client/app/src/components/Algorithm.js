import React, {Component} from 'react'
import AppNavbar from './AppNavBar'
import MaxDepthBinaryTree from './AlogrithmComponents/MaxDepthBinaryTree'


class TreeNode{
    value;
    left;
    right;

    constructor(x){
        this.value = x;
        this.left = null;
        this.right = null;
    }
}
class BinarySearchTree 
{ 
    
    constructor() 
    { 
        this.root = null; 
    } 
  
    insert = (data) => 
    { 
        var newNode = new TreeNode(data); 
        if(this.root === null) 
            this.root = newNode; 
        else
            this.insertTreeNode(this.root, newNode); 
    }

    insertTreeNode(node, newNode) 
    {  
        if(newNode.value < node.value) 
        { 
            if(node.left === null) 
                node.left = newNode; 
            else
                this.insertTreeNode(node.left, newNode);  
        } 
        else
        { 
            if(node.right === null) 
                node.right = newNode; 
            else
                this.insertTreeNode(node.right,newNode); 
        } 
    }
    
    print()
    { 
        document.getElementById('outputSection').textContent=JSON.stringify(this);

    }

    reset()
    {
        this.root = null;
        document.getElementById('outputSection').textContent ='';
    }
} 

export default class AlgorithmPuzzles extends Component
{
    constructor(){
        super();
        this.state = {algorithmName: '', BST: new BinarySearchTree};

      }

    componentDidMount()
    {
        if (this.props.match.params){
            this.setState({
                algorithmName: this.props.match.params.algorithm
            });
        }
    }

    render() {
        return <>
                <AppNavbar/>
                <div className="jumbotron">
                    <h1>{this.state.algorithmName}</h1>
                    <p>Code is written in Java.</p>
                    <p id="solution">Solution will appear here ....</p>
                </div>                  
                <div className = "AlgorithmPageContainer">
                    <MaxDepthBinaryTree />
                 </div>
                
            
                </>
    }
}