package com.project.library.catalogservice.bookcatalog.assembler;

import com.project.library.catalogservice.bookcatalog.models.BookCatalog;
import com.project.library.catalogservice.bookcatalog.service.BookService;
import com.project.library.catalogservice.bookcatalog.web.BookController;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class BookCatalogAssembler implements RepresentationModelProcessor<BookCatalog> {



    @Override
    public BookCatalog process(BookCatalog model) {


        Link lnk = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder.methodOn(BookController.class)
                        .getBookWithReviews(model.getBookId(),0)).withSelfRel();



        model.add(lnk);

        return model;
    }

}
