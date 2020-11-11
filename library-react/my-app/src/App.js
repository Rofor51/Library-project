import React, { Component } from 'react';
import { BrowserRouter as Router } from 'react-router-dom';
import AppWithRouterAccess from './components/auth/AppWithRouterAccess';
import './App.css'
import { ApolloProvider } from '@apollo/client';
import { ApolloClient, InMemoryCache } from '@apollo/client';
import client from './components/client'
class App extends Component {
  render() {
    return (
      <ApolloProvider client={client}>
      <Router>
        <AppWithRouterAccess/>
      </Router> 
      </ApolloProvider>
    
    );
  }
}

export default App;