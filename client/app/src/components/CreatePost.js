import React, { Component } from 'react';
import { Link } from 'react-router-dom';

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
        const cdDate = new Date();
        var postObject = JSON.stringify({category: category, title: title, slug:slug,
            body:body, author:author, cdDate:cdDate})
        return fetch('/CreatePost', {
            method: 'POST',
            body: postObject,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => {
            if (response.status >= 200 && response.status < 300)
            {
                this.window.location("/");
            }
            else
            {
                console.log(response);
            }
        }).catch(err => console.log(err));
        
    }

    componentDidMount() {

    }


    render(){
        return (
        <div id = "CreatePostForm">

            <form onSubmit={this.createPost}>
                <label>
                    Category: 
                    <input name = "Category" type="text" value={this.state.Category} onChange={this.handleChange}></input>
                </label>
                <br/>
                <label>
                    Title: 
                    <input name = "Title" type="text" value={this.state.Title} onChange={this.handleChange}></input>
                </label>
                <br/>
                <label>
                    Slug: 
                    <input name = "Slug" type="text" value={this.state.Slug} onChange={this.handleChange}></input>
                </label>
                <br/>
                <label>
                    Body: 
                    <input name = "Body" type="text" value={this.state.Body} onChange={this.handleChange}></input>
                </label>
                <input type="submit" value="Submit"></input>
            </form>
        </div>
        );
    }
}