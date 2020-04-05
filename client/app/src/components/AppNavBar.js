import React, { Component } from 'react';
import { Collapse, Nav, Navbar, NavbarBrand, NavbarToggler, NavItem, NavLink, ButtonGroup, Button} from 'reactstrap';
import { Link } from 'react-router-dom';
import { GoogleLogin, GoogleLogout } from 'react-google-login';
export default class AppNavbar extends Component {
  constructor(props) {
    super(props);
    this.state = {isOpen: false, isSignedIn: false};
    this.toggle = this.toggle.bind(this);
  }

  toggle() {
    this.setState({
      isOpen: !this.state.isOpen
    });
  }

  GetSignInButton() {
    const Success = (response) => {
      return fetch('/Account/Authenticate?idTokenString=' + response.tokenId, {
        method: 'GET',
        headers: {
        }
    }).then(response => {
        if (response.ok)
        {
          this.setState({isSignedIn : true});
        }
        else
        {
          this.setState({isSignedIn : false});
        }
    }).catch(err => console.log(err));
    }

    const Failure = (response) => {
      this.setState({isSignedIn : false});
      console.log(response);
    }

    const logout = (response) => {
      this.setState({isSignedIn : false});
      alert(response);
    }

    if (this.state.isSignedIn === false)
    {
      return <GoogleLogin
        clientId="170017586676-2p1e2cpf0jgt8b1946crn20ipduli4g5.apps.googleusercontent.com"
        buttonText="Login"
        onSuccess={Success}
        onFailure={Failure}
        isSignedIn={true}
        cookiePolicy={'single_host_origin'}
        />
    }
    else
    {
      return <GoogleLogout
      clientId="170017586676-2p1e2cpf0jgt8b1946crn20ipduli4g5.apps.googleusercontent.com"
      buttonText="Logout"
      onLogoutSuccess={logout}>
    </GoogleLogout>
    }
  }

  ShowCreatePost() 
  {
    if (this.state.isSignedIn)
    {
      return (<NavItem>
        <NavLink href="/CreatePost">Create Blog Post</NavLink>
      </NavItem>);
    }
  }


  render() {


    return <Navbar color="dark" dark expand="md">
      <NavbarBrand tag={Link} to="/">Home</NavbarBrand>
      <NavbarToggler onClick={this.toggle}/>
      <Collapse isOpen={this.state.isOpen} navbar>
        <Nav className="ml-auto" navbar>
          {this.ShowCreatePost()};
          <NavItem>
            <NavLink href="https://twitter.com/michaelmaniatis">@mikedev</NavLink>
          </NavItem>
          <NavItem>
            <NavLink href="https://github.com/mikejohnmaniatis">GitHub</NavLink>
          </NavItem>
          <NavItem>
            {this.GetSignInButton()}
          </NavItem>
        </Nav>
      </Collapse>
    </Navbar>;
  }
}