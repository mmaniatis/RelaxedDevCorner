import React, { Component } from 'react';
import './App.css';
import Home from './components/Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import CreateAccount from './components/CreateAccount';

class App extends Component {
  constructor(){
    super();
    this.state = { isAuthenticated: false, user: null, token: ''};
  }

  onSuccess = (response) => {
    const token = response.headers.get('x-auth-token');
    response.json().then(user => {
      if (token) {
        this.setState({isAuthenticated: true, user: user, token: token});
      }
    });
  };
  
  onFailed = (error) => {
    alert(error);
  };

  
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