import React, { Component } from 'react';
import './css/App.css';

import AppNavbar from './AppNavBar';
import PostList from './PostList';
import { Container} from 'reactstrap';

class Home extends Component {
  render() {
    return (
      <div className ="HomeContainer">
          <div className="NavBar">
            <AppNavbar/>
          </div>

          <div className="PostContainer">
            <PostList/>
          </div>
        </div>
      
    );
  }
}

export default Home;