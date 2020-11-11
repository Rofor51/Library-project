import '../css/commentfield.css'
import {withRouter} from 'react-router-dom';
import { useOktaAuth } from "@okta/okta-react";
import React, { useState, useEffect } from "react";
const CommentField = (props) => {
        const [text, setText] = useState("");
        const [points, setPoints] = useState("");
        const { authState, authService } = useOktaAuth();
        const [userInfo, setUserInfo] = useState(null);

        useEffect(() => {
          if (!authState.isAuthenticated) {
            
            setUserInfo(null);
          } else {
            authService.getUser().then(info => {
              setUserInfo(info);
            });
          }
        }, [authState, authService]); // Update if authState changes   
  

      const handleSubmit = (event) => {
        event.preventDefault();
        const inputs = event.target.getElementsByTagName('input')
        fetch('/review/api/v1/reviews', {
            method: 'POST',
            headers: {
              Authorization: `Bearer ${authState.accessToken}`,
              'Accept': 'application/json',
              'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                bookId: inputs.bookId.value, 
                username: userInfo.name, 
                comment:inputs.text.value,
                points: inputs.points.value,
                date: new Date()
            })
          })
          .then(response => console.log(response))
          .then(window.location.reload())
       
          
      }
      return(
     <div>
        <form className="commentForm" onSubmit={handleSubmit}>
        <input type="hidden" name="bookId" value={props.bookId}/>
        <input type="number" name="points" min="0" max="5" onChange={e => setPoints(e.target.value)}/>
        <input type="text" name="text" placeholder="Say something..." onChange={e => setText(e.target.value)}/>
        <input type="submit" value="Post" />
      </form>
      </div>
         
     
      )

     
    
     
    }
    
    export default withRouter(CommentField)