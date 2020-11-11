import { useOktaAuth } from "@okta/okta-react";
import React, { useState, useEffect, Fragment } from "react";
import { connect } from 'react-redux'
import { clearProduct } from '../actions/RemoveProduct'
import '../css/cart.css'
import { Button } from "reactstrap";

const Cart = ({basketProps,clearProduct}) => {
  const { authState, authService } = useOktaAuth();
  const [userInfo, setUserInfo] = useState(null);
  let productsInCart = [];

  useEffect(() => {
    if (!authState.isAuthenticated) {
      
      setUserInfo(null);
    } else {
      authService.getUser().then(info => {
        setUserInfo(info);
      });
    }
  }, [authState, authService]); // Update if authState changes



  const handleSubmit = (product) => {
      let getProducts = [];
      getProducts = product.map(item => item.id)
    fetch('/order/api/v1/order-service', {
        method: 'POST',
        headers: {
          Authorization: `Bearer ${authState.accessToken}`,
          'Accept': 'application/json',
          'Content-Type': 'application/json',
       },
        body: JSON.stringify({
            userName: userInfo.email, 
            bookId: getProducts, 
        })
      })
      .then(response => console.log(response))
   
   
      
  }
  
  productsInCart = basketProps.map(item=> {
    return (
        <Fragment key={item.id}>
        <div className="product"><ion-icon onClick={() => clearProduct(item.name)} name="close-circle"></ion-icon><img src={item.img} />
        <span className="sm-hide">{item.name}</span>
        </div>
        </Fragment>
    )
    
  });

return (
    <div className="products-container">
        <div className="product-header">
            <h5 className="product-title">PRODUCT</h5>
        </div>
        <div className="products">
        {productsInCart}
        </div>
        {authState.isAuthenticated ? (
        <div>
           <Button onClick={() => handleSubmit(basketProps)}>Checkout</Button>
        </div>
      ) : (
        <p>Please login to check out!</p>
      )}
    </div>
);
        }

const mapStateToProps = state => ({
    basketProps: state.basketState
});

export default connect(mapStateToProps, {clearProduct})(Cart);