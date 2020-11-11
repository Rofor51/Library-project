import React, {Component } from 'react';
import {Link} from 'react-router-dom';
import '../css/home.css'
import { Button } from 'reactstrap';
import ReactStars from "react-rating-stars-component";
import { gql, useQuery } from '@apollo/client';

const GET_BOOKS = gql`
query GetBooks {
  bookCatalog {
    bookId
    title
    averageScore
    imageLink  
  }
}
`;

const Home = () =>  {
  const { loading, error, data } = useQuery(GET_BOOKS);
  
  if (loading) return 'Loading...';
  if (error) return `Error! ${error.message}`;
  console.log(data)
    return (
    
      <div className="app">
      <div id="product">
        {data.bookCatalog.map(books => (
          <div className="card" key={books.bookId}>
          <img src={books.imageLink}></img>
            <div className="content">
              <h4>
                {books.title}
              </h4>
              <ReactStars edit={false} count={5} size={30} value={books.averageScore} activeColor="#ffd700"/>
              <Link to={"book/" + books.bookId}><Button>Details</Button></Link>
            </div>
          </div>
        ))}
      
        </div>
        </div>
    
      )};
      
    
    export default Home
