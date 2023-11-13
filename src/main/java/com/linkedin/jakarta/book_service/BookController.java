package com.linkedin.jakarta.book_service;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("book")
public class BookController {

    @Inject
    private BookRepository bookRepository;
    @Path("list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> allBooks(){
        return bookRepository.findAll();
    }


    @Path("add")
    @POST
    public void addBook(Book book){
        bookRepository.save(book);
    }

    @GET
    public List<Book> getBookFromAuthor(@QueryParam("author") String author){
        return bookRepository.findBookByAuthor(author);
    }
}
