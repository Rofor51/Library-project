import React, { useState, Component,useEffect} from 'react'
import './navbar.css'
import { connect } from 'react-redux'
import { Link } from 'react-router-dom'
import { getNumbers } from '../actions/getAction'
import AuthInformation from './auth/AuthInformation'


  class Navbar extends Component {
    constructor(props) {
        super(props);
        this.state = { userInfo: null};
    
      }


    handleClick = () => {
        this.setState({clicked: !this.state.clicked})
    }

   
    render() {
      
    
        return (
            <nav className="NavBarItems">
               <Link to="/"> <h1 className="navbar-logo">Library<i className="fab fa-react"></i></h1></Link>
                <div className="menu-icon">
                    <i onClick={this.handleClick} className={this.state.clicked ? 'fas fa-times': 'fas fa-bars'}></i>
                </div>
                <ul className={this.state.clicked ? 'nav-menu active' : 'nav-menu'}>
                  <li><Link className="nav-links" to="/">Books</Link></li>
                  <li><Link className="nav-links" to="/cart">Cart<span>({this.props.basketProps.length})</span></Link></li>
                    <AuthInformation />
                </ul>
            </nav>
        )
    }
    
}
const mapStateToProps = state => ({
  basketProps: state.basketState
})


export default connect(mapStateToProps, {getNumbers})(Navbar)
