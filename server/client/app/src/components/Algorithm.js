import React, {Component} from 'react'
import AppNavbar from './AppNavBar'
import MaxDepthBinaryTree from './AlogrithmComponents/MaxDepthBinaryTree'
import TwoSum from './AlogrithmComponents/TwoSum';

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

    getAlgorithmComponent()
    {
        switch (this.state.algorithmName){
            case "MaxDepthTree":
                return <MaxDepthBinaryTree />;
            case "TwoSum":
                return <TwoSum />
        }
    }

    render() {
        return <>
                <AppNavbar/>
                <div className="jumbotron">
                    <h1>{this.state.algorithmName}</h1>
                    <p id="description">Code is written in Java.</p>
                    <p id="solution">Solution will appear here ....</p>
                </div>                  
                <div className = "AlgorithmPageContainer">
                    {this.getAlgorithmComponent()}
                 </div>
                
            
                </>
    }
}