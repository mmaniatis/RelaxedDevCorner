import React, { Component } from 'react';
import '../App.css';
import AppNavbar from './AppNavBar';
import PostList from './PostList';
import { Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';

class Home extends Component {
  render() {
    return (
      <div>
        <AppNavbar/>
        <Container fluid>
          {PostList}
        </Container>
      </div>
    );
  }
}

export default Home;