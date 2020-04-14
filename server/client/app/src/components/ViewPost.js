import React, { Component } from 'react';
import './css/App.css';
import AppNavbar from './AppNavBar';
import { Container} from 'reactstrap';
import {
    EmailShareButton,
    FacebookShareButton,
    RedditShareButton,
    TwitterShareButton,
    TwitterIcon,
    FacebookIcon,
    RedditIcon,
    EmailIcon
  } from "react-share";

export default class ViewPost extends Component {

    constructor(props){
        super(props);
        this.state = {post: []}
    }
    componentDidMount()
    {
        if (this.props.match.params){
            const slug = this.props.match.params.slug;
            const category = this.props.match.params.category;
            fetch(process.env.REACT_APP_API_URL+ '/GetPost?category=' + category + '&slug=' +slug, {
                method: 'GET',
                cache: 'no-cache', 
                // credentials: 'same-origin', 
                headers: {
                  'Content-Type': 'application/json'
                },
                redirect: 'follow', 
                referrerPolicy: 'no-referrer'
               
              }).then(response => response.json())
              .then(data =>  this.setState({post: data}));
                
        }

    }

    render(){
        const {post} = this.state;
        return (<div> 
                <AppNavbar/>
                <div className="shareButtons">
                    <TwitterShareButton
                        url={window.location.href}
                        title={"Check out this post on CodeCorner, " +post.title}
                    >
                    <TwitterIcon
                    size={32}
                    round />
                    </TwitterShareButton>

                    <FacebookShareButton
                        url={window.location.href}
                        title={post.title}
                    >
                    <FacebookIcon
                    size={32}
                    round />
                    </FacebookShareButton>
                    <EmailShareButton
                        url={window.location.href}
                        title={post.title}
                    >
                    <EmailIcon
                    size={32}
                    round />
                    </EmailShareButton>

                    <RedditShareButton
                        url={window.location.href}
                        title={post.title}
                    >
                    <RedditIcon
                    size={32}
                    round />
                    </RedditShareButton>
                </div>
                <Container fluid>
                    <div className="jumbotron">
                        <h1>{post.title}</h1>
                        <p>Written by: {post.author}</p>
                    </div>  
                    <div className="article">
                        <div className="PostBody">
                            <p>{post.body}</p>
                        </div>
                    </div>
                </Container>
                {/* Sharing to social medias here... */}

                </div>
        );
    }
}