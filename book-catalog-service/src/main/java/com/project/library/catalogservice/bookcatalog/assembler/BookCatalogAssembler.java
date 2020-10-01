package com.project.library.catalogservice.bookcatalog.assembler;

import com.project.library.catalogservice.bookcatalog.models.AuthorDto;
import com.project.library.catalogservice.bookcatalog.models.BookCatalog;
import com.project.library.catalogservice.bookcatalog.models.BookDto;
import com.project.library.catalogservice.bookcatalog.web.BookController;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class BookCatalogAssembler implements RepresentationModelAssembler<BookDto, BookCatalog> {
    @Override
    public BookCatalog toModel(BookDto entity) {
        Set<AuthorDto> authId = entity.getAuthors().stream().map(k -> new AuthorDto(k.getId(), k.getName())).collect(Collectors.toSet());
        BookCatalog bookDto = new BookCatalog(entity.getBookId(), entity.getTitle(), entity.getPages(), entity.getYear(), authId);

        Link lnk = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder.methodOn(BookController.class)
                        .getBook(entity.getBookId()))
                .withSelfRel();

        bookDto.add(lnk);

        return bookDto;
    }

}
