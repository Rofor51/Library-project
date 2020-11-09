package com.project.library.catalogservice.bookcatalog.resolver;

import com.project.library.catalogservice.bookcatalog.feignclient.BookClient;
import com.project.library.catalogservice.bookcatalog.feignclient.ReviewClient;
import com.project.library.catalogservice.bookcatalog.models.BookCatalog;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BookCatalogResolver implements GraphQLQueryResolver {
    private final BookClient bookClient;
    private final ReviewClient reviewClient;

    public List<BookCatalog> bookCatalog(){
        List<BookCatalog> bookCatalog = bookClient.getAllBooks().stream().collect(Collectors.toList());
        bookCatalog.forEach(k -> k.setAverageScore(reviewClient.getAverageScore(k.getBookId())));
        return bookCatalog;
    }
}
