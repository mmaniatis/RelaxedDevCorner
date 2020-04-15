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
        window.addEventListener('keypress', function (e) {
            if (e.keyCode === 13 && document.getElementById('TreeInput').value !== '') {
                document.getElementById('buildTree').click();
            }
        }, false);
    }

    buildTreeNode = (event) => {
        const value = document.getElementById('TreeInput').value;
        if (value !== '')
        {
            this.state.BST.insert(value);
            document.getElementById('TreeInput').value='';
            this.state.BST.print();
        }

    };

    getMaxDepth = () => {
        fetch(process.env.REACT_APP_API_URL + "Algorithm/MaxDepthBinaryTree", {
            method: 'post',
            body: JSON.stringify(this.state.BST),
            headers: {
                'Content-Type': 'application/json',
            },
            
        }).then(response => response.json())
        .then(responseJSON => 
            
            document.getElementById('solution').textContent = 'Max Depth of the given binary tree is, ' + responseJSON
        
        )
        .catch(err => alert(err));
    }

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
                            placeholder="Type in a number to insert to tree and press enter or Insert Tree Node:"
                            id="TreeInput"
                            // onChange ={this.buildTreeNode}
                            >
                            </input>
                            <button id ="buildTree" onClick={this.buildTreeNode}>
                            Insert Into Tree
                            </button>
                        </div>
                        
                        <button onClick={this.getMaxDepth}>
                            Submit
                        </button>

                        <button onClick={this.resetTree}>
                            Reset
                        </button>
                        <p id="outputSection">
                        Tree Output ... 
                        </p>
                        
                    </div>  


                    <div className="CodeSection" style={{ whiteSpace: 'pre-wrap' }}>
                        <code className="UserCode">
{`
    public static int MaxDepthBinaryTree (@RequestBody BinarySearchTree tree) 
    {  
        int depth = traverse(tree.root, 0);
        return depth;

    }

    public static int traverse(TreeNode root, int depth) 
    {
        if (root == null)
            return depth;
        int leftDepth = traverse(root.left, depth++);
        int rightDepth = traverse(root.right, depth++);
        return Math.max(leftDepth, rightDepth);
    }`}
                        </code>
                    </div>         
                </>
        )
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
                    <this.maxDepthBinaryTree />
                 </div>
                
            
                </>
    }
}