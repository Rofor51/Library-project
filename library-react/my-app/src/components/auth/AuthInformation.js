import React, { useState, useEffect} from "react";
import { Link } from 'react-router-dom';
import { useOktaAuth } from '@okta/okta-react';
import styled from 'styled-components'

const Li = styled.li`
    color: white;
    text-decoration: none;
    padding: 0.5rem 1rem;
    display: inline;
   
`

const Admin = styled.div`
    position: relative;
    right:700px;
    bottom: 25px;
`


const AuthInformation = () => {
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

  const accessToken = authState.accessToken;
  console.log(accessToken)
  const button = authState.isAuthenticated ?
    <button onClick={() => {authService.logout()}}>Logout</button> :
    <button onClick={() => {authService.login()}}>Login</button>;

  return (
    <div> 
      {button}
      {userInfo && (
        <div className="admin-links">
          {userInfo.groups.includes("Admin") && (
            <Admin >
              <Li><Link className="nav-links" to="/edit/new">Add new books</Link></Li>
              <Li><Link className="nav-links" to="/order">View orders</Link></Li>
            </Admin>
        )}
        </div>
      )}
    </div>
  );
};
export default AuthInformation;