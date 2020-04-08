import React, { Component } from 'react';
import '../App.css';
import AppNavbar from './AppNavBar';
import { Container} from 'reactstrap';

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
            fetch('/GetPost?category=' + category + '&slug=' +slug, {
                method: 'GET',
                mode: 'cors', 
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
                <Container fluid>
                    <div className="jumbotron">
                        <h1>{post.title}</h1>
                    </div>  
                    <div className ="Post">

                        <div className="PostBody">
                            <h3>{post.body}</h3>
                        </div>
                        
                        <div className ="PostFooter">
                            <p>Written by: {post.author}</p>
                        </div>
                    </div>
                </Container>

                </div>
        );
    }
}