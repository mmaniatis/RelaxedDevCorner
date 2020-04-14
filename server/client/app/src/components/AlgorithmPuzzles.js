import React, {Component} from 'react'
import { Container} from 'reactstrap';
import AppNavbar from './AppNavBar'

export default class AlgorithmPuzzles extends Component
{
    constructor(){
        super();
        this.state = {};
      }


    render() {
        return <>
            <AppNavbar/>
            <Container fluid>
                <div className="jumbotron">
                    <h1>View & Practice Various Algorithmic Puzzles</h1>
                </div>

                <a href="/ViewPuzzle/MaxDepthTree"> Max Depth Tree</a>
            </Container>
        </>
    }
}