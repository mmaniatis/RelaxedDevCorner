import React, { Component } from 'react';
import { Collapse, Nav, Navbar, NavbarBrand, NavbarToggler, NavItem, NavLink, ButtonGroup, Button} from 'reactstrap';
import { Link } from 'react-router-dom';
import { GoogleLogin, GoogleLogout, useGoogleLogin } from 'react-google-login';
import ReactDOM from 'react-dom';
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

    // const { signIn, loaded } = useGoogleLogin({
    //   onSuccess,
    //   clientId,
    //   cookiePolicy,
    //   loginHint,
    //   hostedDomain,
    //   autoLoad,
    //   isSignedIn,
    //   fetchBasicProfile,
    //   redirectUri,
    //   discoveryDocs,
    //   onFailure,
    //   uxMode,
    //   scope,
    //   accessType,
    //   responseType,
    //   jsSrc,
    //   onRequest,
    //   prompt})

    const Success = (response) => {
      this.setState({isSignedIn : true});
      alert(response.tokenId);
      console.log(response);
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

  


  render() {


    return <Navbar color="dark" dark expand="md">
      <NavbarBrand tag={Link} to="/">Home</NavbarBrand>
      <NavbarToggler onClick={this.toggle}/>
      <Collapse isOpen={this.state.isOpen} navbar>
        <Nav className="ml-auto" navbar>
          <NavItem>
            <NavLink href="/CreatePost">Create Blog Post</NavLink>
          </NavItem>
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