package org.inf5190.graphql.controller;

import java.util.Arrays;
import java.util.List;
import org.inf5190.graphql.model.Author;
import org.inf5190.graphql.model.Book;
import org.inf5190.graphql.model.User;
import org.inf5190.graphql.repository.AuthorRepository;
import org.inf5190.graphql.repository.BookRepository;
import org.inf5190.graphql.repository.UserRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GraphQLController {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private UserRepository userRepository;

    public GraphQLController(BookRepository bookRepository, AuthorRepository authorRepository,
            UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.userRepository = userRepository;
    }

    @QueryMapping
    public Book bookById(@Argument String id) {
        return this.bookRepository.getById(id);
    }

    @QueryMapping
    public Author authorById(@Argument String id) {
        return this.authorRepository.getById(id);
    }

    @QueryMapping
    public User userById(@Argument String id) {
        return this.userRepository.getById(id);
    }

    @SchemaMapping
    public Author author(Book book) {
        return this.authorRepository.getById(book.authorId());
    }

    @SchemaMapping
    public List<Book> books(Author author) {
        return Arrays.asList(author.bookIds()).stream()
                .map(bookId -> this.bookRepository.getById(bookId)).toList();
    }

    @SchemaMapping
    public List<Book> purchases(User user) {
        return Arrays.asList(user.purchasedBookIds()).stream()
                .map(bookId -> this.bookRepository.getById(bookId)).toList();
    }
}
