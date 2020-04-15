import React, {Component} from 'react'
import AppNavbar from './AppNavBar'

class TreeNode {
    value;
    left;
    right;

    TreeNode(x){
        this.value = x;
    }
}

export default class AlgorithmPuzzles extends Component
{
    constructor(){
        super();
        this.state = {algorithmName: '', TreeNode: new TreeNode(null)};

      }



    componentDidMount()
    {
        if (this.props.match.params){
            this.setState({
                algorithmName: this.props.match.params.algorithm
            });
        }
    }

    insertTreeNode = (treeNode, val) => 
    {
        if (treeNode.value == null)
        {
            treeNode.value = new TreeNode(val);
        }   
        else if (val < treeNode.value)
        {
            this.insertTreeNode(treeNode.left, val);
        }
        else if (val >= treeNode.value)
        {
            this.insertTreeNode(treeNode.right, val);
        }
    };

    buildTreeNode = (event) => {
        // debugger;
        const target = event.target;
        const value = target.value;

        this.insertTreeNode(this.state.TreeNode, value);
        
        console.log(this.state.TreeNode);
        console.log(this.state.TreeNode.left);
        console.log(this.state.TreeNode.right);
    };

    maxDepthBinaryTree = () => {
        return (<>
                <div className="AlgorithmSectionContainer"> 
                    <div className="inputSection">
                        <input 
                        className ="CreateFormInput" 
                        name = "AlgorithmInput" 
                        type="text" 
                        placeholder="Type in a depth you would like to test:"
                        onChange ={this.buildTreeNode}
                        >
                        </input>
                        
                    </div>
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
                </>
    }
}