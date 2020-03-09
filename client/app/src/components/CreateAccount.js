import React, { Component } from 'react';
import '../App.css';
import AppNavbar from './AppNavBar';
import PostList from './PostList';
import { Container, ButtonGroup, Button } from 'reactstrap';

class CreateAccount extends Component{
    render(){
        return (
        <div>
            <Container fluid>
                <AppNavbar/>
                <div class="jumbotron">
                    
                    <ButtonGroup>
                        <Button color="primary" size="lg">Create an Account</Button>
                    </ButtonGroup>
                
                </div>


            </Container>
        </div>
        )};
}
export default CreateAccount