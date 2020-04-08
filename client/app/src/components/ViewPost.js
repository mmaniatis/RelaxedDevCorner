import React, { Component } from 'react';
import '../App.css';
import AppNavbar from './AppNavBar';
// import { Container, Button} from 'reactstrap';

export default class ViewPost extends Component {

    constructor(props){
        super(props);
        this.state = {title: 'Test', author: 'Test'}
        
    }

    postData(url = '/api/GetPosts', data = {}) {
        const response = await fetch(url, {
          method: 'GET',
          mode: 'cors', 
          cache: 'no-cache', 
          credentials: 'same-origin', 
          headers: {
            'Content-Type': 'application/json'
          },
          redirect: 'follow', 
          referrerPolicy: 'no-referrer', 
          body: JSON.stringify(data) 
        });
        return response.json();
      }

    componentDidMount()
    {
        if (this.props.match.params){
            const title = this.props.match.params.title;
            const author = this.props.match.params.author;
            const category = this.props.match.params.category;
            this.setState({title, author})
            
            
        }
    }

    render(){
        const {title, author} = this.state;
        return (<> 
                <AppNavbar/>

                <h1>{title}</h1>
                    

            <p>Written by: {author}</p>
        </>
        );
    }
}