import React, {Component} from 'react'
import AppNavbar from './AppNavBar'
import MaxDepthBinaryTree from './AlogrithmComponents/MaxDepthBinaryTree'

export default class AlgorithmPuzzles extends Component
{
    constructor(){
        super();
        this.state = {algorithmName: ''};

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