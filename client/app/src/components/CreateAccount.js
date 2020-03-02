import React, { Component } from 'react';
import '../App.css';
import AppNavbar from './AppNavBar';
import PostList from './PostList';
import { Container } from 'reactstrap';

class CreateAccount extends Component{
    render(){
        return (
        <div>
            <Container fluid>
                <AppNavbar/>
                <div class="jumbotron">
                    
                    <h1>Create an Account</h1>
                
                </div>

                
            </Container>
        </div>
        )};
}
export default CreateAccount