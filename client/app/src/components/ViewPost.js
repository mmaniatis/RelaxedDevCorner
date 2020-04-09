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
                <Container fluid>
                    <div className="jumbotron">
                        <h1>{post.title}</h1>
                        <p>Written by: {post.author}</p>
               
                    </div>  
                    <div className="article">
                        <div className="PostBody">
                            {post.body}
                        </div>
                    </div>
                </Container>

                </div>
        );
    }
}