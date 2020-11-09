package com.project.library.catalogservice.bookcatalog.resolver;

import com.project.library.catalogservice.bookcatalog.models.Author;
import com.project.library.catalogservice.bookcatalog.models.BookDetail;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@Slf4j
public class AuthorResolver implements GraphQLResolver<BookDetail> {
    public Set<Author> authors(BookDetail bookDetail) {
        log.info("Retrieving authors" + bookDetail.getBookId());
        return bookDetail.getAuthors();
    }
}
