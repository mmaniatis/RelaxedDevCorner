import React, { Component } from 'react';
import '../App.css';
import AppNavbar from './AppNavBar';
import PostList from './PostList';
import { Container} from 'reactstrap';

class Home extends Component {
  render() {
    return (
      <div>
        <AppNavbar/>
        <Container fluid>
          <div className="jumbotron">
            <h1>Welcome to the, $TheDevCorner.</h1>
          </div>
            <PostList/>
        </Container>
      </div>
    );
  }
}

export default Home;