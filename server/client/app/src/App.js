import React, { Component } from 'react';
import Home from './components/Home';
import ViewPost from './components/ViewPost';
import CreatePost from './components/CreatePost';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Cookies from 'universal-cookie';

class App extends Component {
  constructor(){
    super();
    this.state = {};
  }
  returnAdminRoutes()
  {
    const cookies = new Cookies();
    if (cookies.get("IsAdmin") == "True" && cookies.get("IsAuthenticated") == "True")
        return <Route path='/CreatePost' exact={true} component={CreatePost} /> 
  }
  render() {
    return (
      <Router>
        <Switch>
          <Route path='/' exact={true} component={Home}/>
          <Route path='/ViewPost/:category/:slug' exact={true} component={ViewPost}/>
          {this.returnAdminRoutes()}
        </Switch>
      </Router>
    )
  }
}

export default App;