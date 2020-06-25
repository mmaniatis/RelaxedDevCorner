import React, { Component, useState } from 'react';
import './css/App.css';
import AppNavbar from './AppNavBar';
import { Container, Button} from 'reactstrap';
import Modal from 'react-bootstrap/Modal'
import ModalHeader from 'react-bootstrap/ModalHeader'
import ModalDialog from 'react-bootstrap/ModalDialog'
import ModalTitle from 'react-bootstrap/ModalTitle'
import ModalBody from 'react-bootstrap/ModalBody'
import ModalFooter from 'react-bootstrap/ModalFooter'
import Cookies from 'universal-cookie';

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
import { post } from 'jquery';

export default class ViewPost extends Component {

    constructor(props){
        super(props);
        this.state = {post: [], comments: [], show: false, setShow: false}
    }
    
     wait(ms)
    {
        var d = new Date();
        var d2 = null;
        do { d2 = new Date(); }
        while(d2-d < ms);
    }
    _handleKeyDown = (event) => {
        var ENTER_KEY = 13;
        switch( event.keyCode ) {
            case ENTER_KEY:
                this.submitComment();
                
                break;
            default: 
                break;
        }
    }
    componentDidMount()
    {
        document.addEventListener("keydown", this._handleKeyDown);
        if (this.props.match.params){
            const slug = this.props.match.params.slug;
            const category = this.props.match.params.category;
            fetch(process.env.REACT_APP_API_URL+ '/GetPost?category=' + category + '&slug=' +slug, {
                method: 'GET',
                cache: 'no-cache', 
                headers: {
                  'Content-Type': 'application/json'
                },
                redirect: 'follow', 
                referrerPolicy: 'no-referrer'
              }).then(response => response.json())
              .then(data =>  this.setState({post: data}));
        }
    }

    submitComment = () => {
        var comment = document.getElementById('commentTextArea');
        if(comment != undefined) {
            if (comment.value != null) {
                var post = this.state.post;
                const cookies = new Cookies();
                const userName = cookies.get("givenName");
                debugger;
                var comment = {
                    "body": comment.value,
                    "author": userName,
                    "replies": []
                };
                fetch(process.env.REACT_APP_API_URL+ '/AddComment?' + 'body=' + comment.body + '&author=' + comment.author + '&slug=' + post.slug + '&category=' + post.category , {
                    method: 'GET',
                    cache: 'no-cache', 
                    headers: {
                      'Content-Type': 'application/json'
                    },
                    redirect: 'follow', 
                    referrerPolicy: 'no-referrer',
                    async: false
                  }).then(response => response.json());
                  this.wait(1000);
                  window.location.reload()
            }
        }
    }
    render(){
        const {post} = this.state;
        var {show} = true;
        var {comments} = [];
        if (post.comments != undefined) {
            comments = post.comments.map((comment) => 
                <div className ="comment">
                    <span id="commentBody">{comment.body}</span> <br />
                    <span id="commentAuthor">{comment.author}</span>
                    
                    {comment.replies.map((reply) => 
                        <div className ="reply">
                            <span id="replyBody">{reply.body}</span> <br />
                            <span id="replyAuthor">{reply.author}</span> 
                            
                        </div>)}

                </div>);
        };
        const handleClose = () => {
            this.setState({show: false});
        }
        const handleShow = () => {
            this.setState({show: true});
        }
        const cookies = new Cookies();
        const disableComment = cookies.get("IsAuthenticated") === "True" ? false : true;
        return (<div className="ViewPostContainer"> 
                <div>
                <AppNavbar/>
                </div>
                <div className="shareButtons">
                    <TwitterShareButton
                        url={window.location.href}
                        title={"Check out this post on CodeCorner, " + post.title}
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
                <div className="jumbotron">
                    <h1>{post.title}</h1>
                    <p>Written by: {post.author}</p>
                </div>
                <div className="article">
                        <div className="PostBody">
                            <p id="FormattedText" dangerouslySetInnerHTML={{__html: post.body}}></p>
                        </div>


                </div>
                <hr />


                <div className ="commentSection">
                
                <Button id="commentButton" variant="primary" onClick={handleShow} disabled={disableComment}>
                    {disableComment ? "Please sign in to write a comment" : "Write a comment"}
                </Button>

                <Modal show={this.state.show} onHide={handleClose}
                size="lg"
                aria-labelledby="contained-modal-title-vcenter"
                centered>
                    <Modal.Header closeButton>

                    <Modal.Title>
                        
                    </Modal.Title>
                    </Modal.Header>
                    <Modal.Body>
                        <textarea id="commentTextArea"> </textarea>
                    </Modal.Body>
                    <Modal.Footer>
                    <Button variant="secondary" onClick={handleClose}>
                        Close
                    </Button>
                    <Button variant="secondary" onClick={this.submitComment}>
                        Send it!
                    </Button>
                    </Modal.Footer>
                </Modal>
                    <div>
                        <ul>{comments}</ul>
                    </div>

                </div>

            </div>
        );
    }
}