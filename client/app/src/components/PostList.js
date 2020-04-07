import React, { Component } from 'react';
import '../App.css';
import { Container, Modal, Button, Alert} from 'reactstrap';

class PostList extends Component{
    constructor(props){
        super(props);
        this.state = {posts: [], isLoading:true, showModal:false};

        // this.ViewPost = this.ViewPost.bind(this);
    }

    componentDidMount() {
        this.setState({isLoading: true});

        fetch('/GetPosts')
        .then(response => response.json())
        .then(data => this.setState({posts: data, isLoading: false}));
    }

    // ViewPost()
    // {
    //   this.setState({showModal: true});
    // }

    //Open particular post..
    render() {
        const {posts, isLoading} = this.state;
        
        const GetPostList = posts.map(post => {
          var keyHash = post.title + post.author + post.cdDate;
          return <> 
                <button className="Card" key={keyHash} onClick={this.ViewPost}>
                  <h3 className="PostCardText" id="Title">{post.title}</h3>
                  <span className="PostCardText" id="Author">Written by: {post.author}</span>
                </button>
              
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
