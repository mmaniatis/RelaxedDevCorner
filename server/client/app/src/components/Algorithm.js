import React, {Component} from 'react'
import { Container} from 'reactstrap';
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


    render() {
        return <>
                <AppNavbar/>
                <div class="jumbotron">
                    <h1>{this.state.algorithmName}</h1>
                </div>
                </>
    }
}