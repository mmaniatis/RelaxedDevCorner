import React, { Component } from 'react';
import '../App.css';
import { Container } from 'reactstrap';

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

    //Open particular post..
    //..

    render() {
        const {posts, isLoading} = this.state;
    
        if (isLoading) {
          return <p>Loading...</p>;
        }
    
        const GetPostList = posts.map(post => {
            return <button className="Card"  key={post.id}>
                    <h3 className="PostCardText" id="Title">{post.title}</h3>
                    <span className="PostCardText" id="Author">Written by: {post.author}</span>
                  </button>

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
