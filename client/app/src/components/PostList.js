import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavBar';
import { Link } from 'react-router-dom';

class PostList extends Component{
    constructor(props){
        super(props);
        this.state = {posts: [], isLoading:true};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        this.setState({isLoading: true});

        fetch('api/GetPosts')
        .then(response => response.json())
        .then(data => this.setState({posts: data, isLoading: false}));
    }

    render() {
        const {posts, isLoading} = this.state;
    
        if (isLoading) {
          return <p>Loading...</p>;
        }
    
        const postList = posts.map(post => {
            return <tr key={post.id}>
            <td style={{whiteSpace: 'nowrap'}}>{post.title}</td>
            <td>{post.slug}</td>
            <td>
              <ButtonGroup>
                <Button size="sm" color="primary" tag={Link} to={"/post/" + post.id}>View</Button>
              </ButtonGroup>
            </td>
          </tr>
        });
    
        return (
          <div>
            <AppNavbar/>
            <Container fluid>
              <div className="float-right">
                <Button color="blue" tag={Link} to="#">PlaceHolder</Button>
              </div>
              <h3>$TheDevCorner</h3>
              <Table className="mt-4">
                <thead>
                <tr>
                  <th width="20%">Name</th>
                  <th width="20%">Location</th>
                  <th>Events</th>
                  <th width="10%">Actions</th>
                </tr>
                </thead>
                <tbody>
                {postList}
                </tbody>
              </Table>
            </Container>
          </div>
        );
    }
}
export default PostList;
