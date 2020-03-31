import React, { Component } from 'react';
import '../App.css';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import { Link } from 'react-router-dom';

class PostList extends Component{
    constructor(props){
        super(props);
        this.state = {posts: [], isLoading:true};

    }

    componentDidMount() {
        this.setState({isLoading: true});

        fetch('/GetPosts')
        .then(response => response.json())
        .then(data => this.setState({posts: data, isLoading: false}));
    }

    render() {
        const {posts, isLoading} = this.state;
    
        if (isLoading) {
          return <p>Loading...</p>;
        }
    
        const GetPostList = posts.map(post => {
            return <div className="Card" id="PostCard" key={post.id}>
                <button className="PostCardText" id="Button">
                  <h3 className="PostCardText" id="Title">{post.title}</h3>
                  <h4 className="PostCardText" id="Author">{post.author}</h4>
                  <h4 className="PostCardText" id="Date">{post.cdDate}</h4>
                </button>
              </div>

          });
        return (
          <div>

            <Container fluid>
              <h1>{GetPostList}</h1>
            </Container>
          </div>
        );
    }
}
export default PostList;
