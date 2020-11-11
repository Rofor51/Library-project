import { useOktaAuth } from "@okta/okta-react";
import React from "react";
import CommentField from './CommentField';

const Review = (props) => {
  const { authState} = useOktaAuth();
  
  return (
    <div>
      {authState.isAuthenticated && (
        <div>
          <CommentField bookId={props.bookId} />
        </div>
      )}
    </div>
  );
};

export default Review;