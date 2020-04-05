import React, { Component } from 'react';
import './App.css';
import Home from './components/Home';
import CreatePost from './components/CreatePost';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';

class App extends Component {
  constructor(){
    super();
    this.state = {};
  }
  render() {
    return (
      <Router>
        <Switch>
          <Route path='/' exact={true} component={Home}/>
          <Route path='/CreatePost' exact={true} component={CreatePost} />
        </Switch>
      </Router>
    )
  }
}

export default App;