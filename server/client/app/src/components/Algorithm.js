import React, {Component} from 'react'
import AppNavbar from './AppNavBar'

export default class AlgorithmPuzzles extends Component
{
    constructor(){
        super();
        this.state = {algorithmName: ''};
      }

    componentDidMount()
    {
        if (this.props.match.params){
            debugger;
            this.setState({
                algorithmName: this.props.match.params.algorithm
            });
        }
    }

    maxDepthBinaryTree = () => {

        // const ;

        return (<>
                <div className="AlgorithmSectionContainer"> 
                    <div className="inputSection">
                        <input 
                        className ="CreateFormInput" 
                        name = "AlgorithmInput" 
                        type="text" 
                        placeholder="Type in a depth you would like to test:"
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
                <div class="jumbotron">
                    <h1>{this.state.algorithmName}</h1>
                </div>                  

                <this.maxDepthBinaryTree />
                
                
                <button >
                    Submit
                </button>
                </>
    }
}