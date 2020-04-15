import React, {Component} from 'react'
import AppNavbar from './AppNavBar'


class TreeNode {
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

    buildTreeNode = (event) => {
        const target = event.target;
        const value = target.value;
        this.state.BST.insert(value);
        document.getElementById('TreeInput').value='';
        this.state.BST.print();
    };

    resetTree = () => {
        this.state.BST.reset();
    }

    maxDepthBinaryTree = () => {
        return (<>
                <div className="AlgorithmSectionContainer"> 
                    <div className="inputSection">
                        <input 
                        className ="CreateFormInput" 
                        name = "AlgorithmInput" 
                        type="number" 
                        placeholder="Type in a depth you would like to test:"
                        id="TreeInput"
                        onChange ={this.buildTreeNode}
                        >
                        </input>
                    </div>

                    <p id="outputSection">
                       Tree Output ... 
                    </p>
                </div>  
                </>
        )
    }


    render() {
        return <>
                <AppNavbar/>
                <div className="jumbotron">
                    <h1>{this.state.algorithmName}</h1>
                </div>                  

                <this.maxDepthBinaryTree />
                
                
                <button >
                    Submit
                </button>

                <button onClick={this.resetTree}>
                    Reset
                </button>
                </>
    }
}