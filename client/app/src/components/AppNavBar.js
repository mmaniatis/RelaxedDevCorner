import React, { Component } from 'react';
import { Collapse, Nav, Navbar, NavbarBrand, NavbarToggler, NavItem, NavLink, ButtonGroup, Button} from 'reactstrap';
import { Link } from 'react-router-dom';

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
    if (this.state.isSignedIn === false)
    {
      return <ButtonGroup>
                <Button color="primary" size="sm">Sign in with Google</Button>
            </ButtonGroup>
    }
    else
    {
      return  <ButtonGroup>
                <Button color="primary" size="sm" disabled="true">Your signed in !</Button>
              </ButtonGroup>
    }
  }
  render() {

    return <Navbar color="dark" dark expand="md">
      <NavbarBrand tag={Link} to="/">Home</NavbarBrand>
      <NavbarToggler onClick={this.toggle}/>
      <Collapse isOpen={this.state.isOpen} navbar>
        <Nav className="ml-auto" navbar>

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