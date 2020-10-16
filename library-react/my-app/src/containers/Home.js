import React, {Component } from 'react';
import {Link} from 'react-router-dom';
import '../css/home.css'
import { Button } from 'reactstrap';
import ReactStars from "react-rating-stars-component";

class Home extends Component {
    
  constructor(props) {
    super(props);
    this.state = {data: [], isLoading: true, current: 0,complete: false};   
}
componentDidMount() {
  this.setState({isLoading: true});

  fetch(`catalog/api/v1/books/all`)
    .then(response => response.json())
    .then(dataSet => this.setState({data: dataSet, isLoading: false}))
    .catch(() => this.props.history.push('/'));
 
}
 
  render() { 
    const {data,isLoading} = this.state;
    if(isLoading) {
      return <p>Loading.....</p>
     
    }
    console.log(this.state.userInfo)
    return (
      <div className="app">
      <div id="product">
        {data.map(books => (
          <div className="card" key={books.bookId}>
          <img src={books.imageLink}></img>
            <div className="content">
              <h4>
                {books.title}
              </h4>
              <ReactStars count={5} size={30} value={books.averageScore} activeColor="#ffd700"/>
              <Link to={"book/" + books.bookId}><Button>Details</Button></Link>
            </div>
          </div>
        ))}
      
        </div>
        </div>
    
      )};
      }
    
    export default Home
