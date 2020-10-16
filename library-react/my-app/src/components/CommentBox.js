import React from 'react'
import { Button } from 'reactstrap';
import '../css/commentbox.css'


class CommentBox extends React.Component {
   
render() {  

  return(
      <div>
           {this.props.cmnts.map(comments => (
                <div className="comment" key={comments.id}>
                    <strong>{comments.username}</strong>
                    <p>{comments.comment}</p>
                    <p>score: {comments.points}/5</p>
                </div>    
           )    
        )}

      </div>
     
 
  )

}
 

 
}

export default CommentBox
 