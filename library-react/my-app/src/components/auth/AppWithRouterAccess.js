import React, { Component } from 'react';
import { Route, withRouter } from 'react-router-dom';
import { Security, SecureRoute, LoginCallback } from '@okta/okta-react';
import Home from '../../containers/Home';
import Login from './Login';
import Navbar from '../Navbar';
import BookDetail from '../../containers/BookDetail';
import Cart from '../../containers/Cart';
import BookEdit from '../admin/BookEdit';


export default withRouter(class AppWithRouterAccess extends Component {
  constructor(props) {
    super(props);
    this.onAuthRequired = this.onAuthRequired.bind(this);
  }

  onAuthRequired() {
    this.props.history.push('/login')
  }

  render() {


    return (
    

        <Security issuer='https://dev-510038.okta.com/oauth2/default'
                  clientId='0oaxapeju3uoQGFHX4x6'
                  redirectUri={window.location.origin + '/implicit/callback'}
                  onAuthRequired={this.onAuthRequired} >
          <Navbar /> 
          <Route path='/' exact={true} component={Home} />
          <Route path='/book/:id' exact={true} component={BookDetail} />
          <Route path='/login' render={() => <Login baseUrl='https://dev-510038.okta.com' />} />
          <Route path='/implicit/callback' component={LoginCallback} />
          <Route path='/cart' exact={true} component={Cart} />
          <Route path='/edit/:id' component={BookEdit}/>

        </Security>

    );
  }
});