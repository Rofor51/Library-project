import React from 'react';
import CommentBox from '../components/CommentBox';
import '../css/bookdetail.css'
import Review from '../components/Review';
import { connect } from 'react-redux'
import { addBasket } from '../actions/addAction'
import { gql, useQuery } from '@apollo/client';

const GET_BOOK_DETAIL = gql`
query GetBookDetail($bookId: Int!) {
  bookDetail(bookId: $bookId) {
    bookId
    title
    imageLink  
    authors {
      id
      name
    }
  }
}
`;


const BookDetails = (props) => {
  const bookId = props.match.params.id;
  const { loading, error, data } = useQuery(GET_BOOK_DETAIL,{
    variables: { bookId },
  });

  
  if (loading) return 'Loading...';
  if (error) return `Error! ${error.message}`;

        return (
            <div>
              <Review bookId={data.bookDetail.bookId}/>
                <div className="container">
               <div className="left-column">
               <img src={data.bookDetail.imageLink}></img>
               <button onClick={() => props.addBasket({'id':data.bookDetail.bookId, 'name':data.bookDetail.title,'img':data.bookDetail.imageLink})}>Borrow</button>
               </div>
               <div className="right-column">
               <div className="product-description">
                  <h1>{data.bookDetail.title}</h1>
                  <br></br>
                  <p>Description here</p>
                    
             </div>
             <div className="bookDetailsNew__authorsList">
                        <span>
                          <p>Förtfattare:</p>
                            {data.bookDetail.authors.map(authors => (
                                <a href="#" key={authors.id}>{authors.name}</a>
                            ))}     
                        </span>
                    </div>
                  
             </div> 
              
        </div>
        <CommentBox id={bookId}></CommentBox>     
            </div>
           
            
        )


    }
    export default connect(null, {addBasket})(BookDetails)
    
   