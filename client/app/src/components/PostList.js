import React, { Component } from 'react';
import '../App.css';
import { Container, Button} from 'reactstrap';
import Link from "react-dom";

class PostList extends Component{
    constructor(props){
        super(props);
        this.state = {posts: [], isLoading:true}

    }

    componentDidMount() {
        this.setState({isLoading: true});
        fetch('/GetPosts')
        .then(response => response.json())
        .then(data => this.setState({posts: data, isLoading: false}));
    }



    //Open particular post..
    render() {
        const {posts, isLoading} = this.state;
        
        const GetPostList = posts.map(post => {
          var keyHash = post.title + post.author + post.cdDate;
          return <> 
                  <a href="/ViewPost/Category/Test/Mike">
                  <Button className="Card" key={keyHash}>
                    <h3 className="PostCardText" id="Title">{post.title}</h3>
                    <span className="PostCardText" id="Author">Written by: {post.author}</span>
                  </Button>
                  </a>
                </>
        });

        if (isLoading) {
          return <p>Loading...</p>;
        }

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
