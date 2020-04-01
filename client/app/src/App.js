import React, { Component } from 'react';
import './App.css';
import Home from './components/Home';
import CreatePost from './components/CreatePost';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';

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
          <Route path='/CreatePost' exact={true} component={CreatePost} />
          <Route path='/CreatePost/:test' exact={true} component={Home} />
        </Switch>
      </Router>
    )
  }
}

export default App;