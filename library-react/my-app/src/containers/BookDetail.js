import React, {npm,  Component } from 'react';
import CommentBox from '../components/CommentBox';
import '../css/bookdetail.css'
import Review from '../components/Review';
import { connect } from 'react-redux'
import { addBasket } from '../actions/addAction'


class BookDetails extends Component {
    constructor(props) {
        super(props);
        this.state = {data: [], isLoading: true, current: 0,complete: false,userInfo: null };   
        
    }
    componentDidMount() {
        this.setState({isLoading: true});

        try {
            fetch(`/catalog/api/v1/books/${this.props.match.params.id}`)
            .then(response => response.json())
            .then(dataSet => this.setState({data: dataSet, isLoading: false}))
            .catch(() => this.props.history.push('/')); 
          } catch (error) {
            this.props.history.push('/');
          }
      }

    render () {
    const {data,isLoading} = this.state;
    if(isLoading) {
      return <p>Loading.....</p>
     
    }
  
        return (
            <div>
              <Review/>
                <div className="container">
               <div className="left-column">
               <img src={data.imageLink}></img>
               <button onClick={() => this.props.addBasket({'id':data.bookId, 'name':data.title,'img':data.imageLink})}>Borrow</button>
               </div>
               <div className="right-column">
               <div className="product-description">
                  <h1>{data.title}</h1>
                  <br></br>
                  <p>Description here</p>
                    
             </div>
             <div className="bookDetailsNew__authorsList">
                        <span>
                          <p>Förtfattare:</p>
                            {data.authors.map(authors => (
                                <a href="#" key={authors.id}>{authors.name}</a>
                            ))}     
                        </span>
                    </div>
             </div>
             
        </div>
        <CommentBox cmnts={data.reviews}></CommentBox> 
            </div>
           
            
        )
    }

    }
    export default connect(null, {addBasket})(BookDetails)
    
   