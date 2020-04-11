import React, { Component } from 'react';
import './css/App.css';

import AppNavbar from './AppNavBar';
import PostList from './PostList';
import { Container} from 'reactstrap';

class Home extends Component {
  render() {
    return (<>
      <div>
          <div>
            <AppNavbar/>
          </div>
          
          <div className="jumbotron">
              <h1>Welcome to the, $TheDevCorner.</h1>
          </div>
              <PostList/>
        </div>
      </>
    );
  }
}

export default Home;