import React, { Component } from 'react';
import Home from './components/Home';
import AlgorithmPuzzles from './components/AlgorithmPuzzles';
import Algorithm from './components/Algorithm'
import ViewPost from './components/ViewPost';
import GetCategory from './components/GetCategory';
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
          <Route path='/Algorithms' exact={true} component={AlgorithmPuzzles} />
          <Route path='/ViewPuzzle/:algorithm' exact={true} component={Algorithm}/>
          <Route path='/GetCategory/:category' exact={true} component={GetCategory}/>
          {this.returnAdminRoutes()}
        </Switch>
      </Router>
    )
  }
}

export default App;