import React, { Component, Fragment } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import './bookedit.css'
import 'bootstrap/dist/css/bootstrap.min.css';
class BookEdit extends Component {
 
  emptyItem = {
    bookId: '',
    title: '',
    pages: '',
    year: '',
    authors: [{name:"", lastName:"" }],
    imageLink: '',
    inStore: true,
  };

  constructor(props) {
    super(props);
    this.state = {
      item: this.emptyItem,
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }
/* TODO
  async componentDidMount() {
    if (this.props.match.params.id !== 'new') {
      try {
        const group = await (await fetch(`/catalog/api/v1/books/${this.props.match.params.id}`)).json();
        this.setState({item: group});
      } catch (error) {
        this.props.history.push('/');
      }
    }
  }
  */

   handleInputChange = (e, index) => {
    const { name, value } = e.target;
    const list = [...this.state.item.authors];
    list[index][name] = value;
    this.setState({list});
  };

   handleAddClick = () => {
    let item = {...this.state.item};
    item.authors.push({ firstName: "", lastName: "" })
    this.setState({item});
  };

   handleRemoveClick = index => {
    let item = {...this.state.item};
    item.authors.splice(index, 1);
    this.setState({item});
  };

  handleChange(event) {
    const target = event.target;
    const value = target.value;
    const name = target.name;
    let item = {...this.state.item};
    item[name] = value;  
    this.setState({item});
  }

  async handleSubmit(event) {
    event.preventDefault();
    const {item} = this.state;
    await fetch('/book/api/v1/books' + (item.bookId ? '/' + item.bookId : '') , {
      method: (item.id) ? 'PUT' : 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(item),
    });
    this.props.history.push('/');
  }

  render() {
    
    const {item} = this.state;
    const title = <h2 className="book-header">{item.id ? 'Edit Book' : 'Add New Book'}</h2>;
    return <div className="edit-container">
      <Container>
        {title}
        <Form onSubmit={this.handleSubmit}>
          <FormGroup>
            <Label for="title">Title</Label>
            <Input type="text" name="title" id="title" value={item.title || ''}
                   onChange={this.handleChange} autoComplete="title"/>
          </FormGroup>
          <FormGroup>
            <Label for="pages">Pages</Label>
            <Input type="text" name="pages" id="pages" value={item.pages || ''}
                   onChange={this.handleChange} autoComplete="pages"/>
          </FormGroup>
          <FormGroup>
            <Label for="year">Year</Label>
            <Input type="text" name="year" id="year" value={item.year || ''}
                   onChange={this.handleChange} autoComplete="year"/>
          </FormGroup>
          {item.authors.map((x, i) => {
        return (
          <div className="row">
          <FormGroup className="col-md-4 mb-3">
          <Label for="name">Author first name</Label>
          <Input name="name" type="text" placeholder="Enter First Name" id="name"  onChange={e => this.handleInputChange(e, i)} value={x.firstName}
                 onChange={e =>  this.handleInputChange(e, i)}autoComplete="address-level1"/>
        </FormGroup>
         <FormGroup className="col-md-5 mb-3">
         <Label for="lastName">Author last name</Label>
         <Input type="text" name="lastName" placeholder="Enter Last Name" value={x.lastName}
               onChange={e =>  this.handleInputChange(e, i)} autoComplete="address-level1"/>
       </FormGroup>
       <div className="btn-box">
              {item.authors.length !== 1 && <Button
                className="mr10"
                onClick={() =>  this.handleRemoveClick(i)}>Remove</Button>}
              {item.authors.length - 1 === i && <Button className="mr10" color="primary" onClick={this.handleAddClick}>Add author</Button>}
            </div>
          </div>
        );
      })}
     
            <FormGroup>
              <Label for="imageLink">Imagelink</Label>
              <Input type="text" name="imageLink" id="imageLink" value={item.imageLink || ''}
                     onChange={this.handleChange} autoComplete="imageLink"/>
            </FormGroup>
   
          <FormGroup>
            <Button color="primary" type="submit">Save</Button>{' '}
            <Button color="secondary" tag={Link} to="/">Cancel</Button>
          </FormGroup>
     
        </Form>
      </Container>
    </div>
  }
}

export default (withRouter(BookEdit));