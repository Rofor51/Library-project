import React from 'react'
import '../css/commentbox.css'
import { gql, useQuery } from '@apollo/client';

const GET_REVIEWS = gql`
query GetReviews($bookId: Int!,$page: Int!) {
  reviews(bookId: $bookId,page: $page) {
    id 
    username
    points
    comment
  }
}
`;

const CommentBox = (props) =>  {
  const id = props.id;
  console.log(id)
  const { loading, error, data } = useQuery(GET_REVIEWS,{
    variables: { 
      bookId:id,
      page: 0
    },
  });
  
  if (loading) return 'Loading...';
  if (error) return `Error! ${error.message}`;
    return (
      <div>
      {data.reviews.map(comments => (
           <div className="comment" key={comments.id}>
                    <strong>{comments.username}</strong>
                    <p>{comments.comment}</p>
                    <p>score: {comments.points}/5</p>
                </div>   
          
      )    
   )}

 </div>
    
      )};

export default CommentBox
 