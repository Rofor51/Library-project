import { useOktaAuth } from "@okta/okta-react";
import React from "react";
import CommentField from './CommentField';

const Review = () => {
  const { authState} = useOktaAuth();

  return (
    <div>
      {authState.isAuthenticated && (
        <div>
          <CommentField />
        </div>
      )}
    </div>
  );
};

export default Review;