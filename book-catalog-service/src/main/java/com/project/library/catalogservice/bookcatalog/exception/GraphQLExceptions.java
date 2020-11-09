package com.project.library.catalogservice.bookcatalog.exception;

import graphql.GraphQLException;
import graphql.kickstart.spring.error.ThrowableGraphQLError;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GraphQLExceptions {
    @ExceptionHandler(GraphQLException.class)
    public ThrowableGraphQLError graphQLError(GraphQLException e) {
        return new ThrowableGraphQLError(e);
    }
}
