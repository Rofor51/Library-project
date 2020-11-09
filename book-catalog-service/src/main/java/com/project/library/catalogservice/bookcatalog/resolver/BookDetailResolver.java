package com.project.library.catalogservice.bookcatalog.resolver;

import com.project.library.catalogservice.bookcatalog.feignclient.BookClient;
import com.project.library.catalogservice.bookcatalog.models.BookDetail;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookDetailResolver implements GraphQLQueryResolver {
    private final BookClient bookClient;


    public BookDetail bookDetail(Long id){
        return bookClient.getBook(id).get();
    }
}
