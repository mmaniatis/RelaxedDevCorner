import React, { Component } from 'react';
import './css/App.css';
import { Container, Button} from 'reactstrap';
import ReactPaginate from 'react-paginate';

class PostList extends Component{
    constructor(props){
        super(props);
        this.state = {
          posts: [], 
          isLoading:true,
          offset: 0,
          perPage: 5,
          currentPage: 0,
          pageCount: null
        }

    }

    receivedData()
    {
      fetch(process.env.REACT_APP_API_URL + 'GetPosts', {
        method: 'get',
        headers: {
        },
      })
      .then(response => response.json())
      .then(data => {
            console.log(data.length);
            const slice = data.slice(this.state.offset, this.state.offset + this.state.perPage);
            const postData = slice.map((post,index) => 
            
            <div key={index} className="PostCard" onClick={ () => this.viewPost(post.category, post.slug) }>
              <h3 className="PostCardText" id="Title">{post.title}</h3>
              <span className="CardFooter">Written by: {post.author} | {post.cdDate} </span>
              <br />
            </div>

            )

            this.setState({
                pageCount: Math.ceil(data.length / this.state.perPage),
                postData,
                isLoading: false
            })
        
          });
    }

    handlePageClick = (e) => {
      const selectedPage = e.selected;
      const offset = selectedPage * this.state.perPage;

      this.setState({
          currentPage: selectedPage,
          offset: offset
      }, () => {
          this.receivedData()
      });

  };

    componentDidMount() {
        this.setState({isLoading: true});
        this.receivedData()
    }


    viewPost = (category, slug) => {
      window.location.href ="/ViewPost/" + category + "/" + slug + "/";
    }

    //Open particular post..
    render() {
        const {isLoading} = this.state;

        if (isLoading) {
          return <p>Loading...</p>;
        }

        return (<>
                {this.state.postData}
                    <ReactPaginate
                          previousLabel={"prev"}
                          nextLabel={"next"}
                          breakLabel={"..."}
                          breakClassName={"break-me"}
                          pageCount={this.state.pageCount}
                          marginPagesDisplayed={2}
                          pageRangeDisplayed={5}
                          onPageChange={this.handlePageClick}
                          containerClassName={"pagination"}
                          subContainerClassName={"pages pagination"}
                          activeClassName={"active"}
                          
                      />
              </>
        );
    }
}
export default PostList;
