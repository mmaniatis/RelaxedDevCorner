import React, { Component } from 'react';
import AppNavbar from './AppNavBar';

export default class CreatePost extends Component 
{
    constructor(props){
        super(props);
        this.state = {Category: '', Title: '', Slug: '', Body: ''}

        this.handleChange = this.handleChange.bind(this);
        this.createPost = this.createPost.bind(this);
    }

    handleChange(event)
    {
        const target = event.target;
        const value = target.value;
        const name = target.name;

        this.setState({
            [name] : value
        });

    }

    createPost (event)
    {   
        const category = this.state.Category;
        const title = this.state.Title;
        const slug = this.state.Slug;
        const body = this.state.Body;
        const author = 'Michael J. Maniatis';
        const cdDate =  new Date();
        var postObject = JSON.stringify({category: category, title: title, slug:slug,
            body:body, author:author, cdDate:cdDate})
        fetch(process.env.REACT_APP_API_URL + "CreatePost", {
            method: 'post',
            body: postObject,
            headers: {
                'Content-Type': 'application/json',
            },
            
        }).then(response => response)
        .then(data => window.location.reload(true))
        .catch(err => alert(err));
        
    }

    componentDidMount() {

    }


    render(){
        return (
            <div>
                <AppNavbar/>
                <div className="jumbotron">
                <h1>Thanks for contributing!</h1>
                </div>
                <div className="container">
                    <div className = "CreatePostForm">

                        <label className="CreateFormLabel">
                            Category: 
                        </label>
                        <input className ="CreateFormInput"name = "Category" type="text" value={this.state.Category} onChange={this.handleChange}></input>
                        <br/>
                        <label className="CreateFormLabel">
                            Title: 
                        </label>

                        <input className ="CreateFormInput" name = "Title" type="text" value={this.state.Title} onChange={this.handleChange}></input>

                        <br/>
                        <label className="CreateFormLabel">
                            Slug: 
                        </label>

                        <input className ="CreateFormInput" name = "Slug" type="text" value={this.state.Slug} onChange={this.handleChange}></input>
                        <br/>
                        <label className="CreateFormLabel">
                            Body: 
                        </label>

                        <textarea className ="CreateFormInput" id="CreateFormBody"
                        name = "Body" type="textarea" value={this.state.Body} onChange={this.handleChange}></textarea>
                        
                        <button onClick={this.createPost}>
                            Submit
                        </button>
                    
                </div>
            </div>
        </div>
        
        );
    }
}