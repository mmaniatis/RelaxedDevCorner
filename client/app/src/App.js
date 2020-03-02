import React, { Component } from 'react';
import './App.css';
import Home from './components/Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import CreateAccount from './components/CreateAccount';

class App extends Component {
  render() {
    return (
      <Router>
        <Switch>
          <Route path='/' exact={true} component={Home}/>
          <Route path='/CreateAccount' exact={true} component={CreateAccount}/>
        </Switch>
      </Router>
    )
  }
}

export default App;