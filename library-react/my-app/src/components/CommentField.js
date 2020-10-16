import React from 'react'
import '../css/commentfield.css'
import {withRouter} from 'react-router-dom';
class CommentField extends React.Component {
    constructor(props) {
        super(props)
        this.state = { username: '',test:'' }
        this.handleSubmit = this.handleSubmit.bind(this)
      }

    async handleSubmit(event) {
        event.preventDefault();
        const inputs = event.target.getElementsByTagName('input')
        console.log(inputs.username.value)
        fetch('/review/api/v1/reviews', {
            method: 'POST',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                bookId: inputs.bookId.value, 
                username: inputs.username.value, 
                comment:inputs.text.value,
                points: inputs.points.value,
                date: "2020-10-12"
            })
          })
          .then(response => console.log(response))
          .then(window.location.reload())
       
          
      }

    render() {  
    
      return(
     <div>
        <form className="commentForm" onSubmit={this.handleSubmit}>
        <input type="hidden" name="bookId" value={this.props.bookId}/>
        <input type="hidden" name="points" value={this.props.points}/>
        <input type="text" name="username" placeholder="Your name"/>
        <input type="text" name="text" placeholder="Say something..."/>
        <input type="submit" value="Post" />
      </form>
      </div>
         
     
      )
    
    }
     
    
     
    }
    
    export default withRouter(CommentField)