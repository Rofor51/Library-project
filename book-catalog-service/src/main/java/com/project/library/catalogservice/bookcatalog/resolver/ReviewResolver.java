package com.project.library.catalogservice.bookcatalog.resolver;

import com.project.library.catalogservice.bookcatalog.feignclient.ReviewClient;
import com.project.library.catalogservice.bookcatalog.models.BookDetail;
import com.project.library.catalogservice.bookcatalog.models.Reviews;
import graphql.execution.DataFetcherResult;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class ReviewResolver implements GraphQLQueryResolver {
    private final ReviewClient reviewClient;

    public DataFetcherResult<List<Reviews>> reviews(Long bookdId, Integer page) {
        log.info("Fetching reviews" + bookdId);
        return DataFetcherResult.<List<Reviews>>newResult().data(reviewClient.getReviews(bookdId,page)).build();
    }


}
