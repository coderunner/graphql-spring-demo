package org.inf5190.graphql.repository;

import java.util.Arrays;
import java.util.List;
import org.inf5190.graphql.model.Author;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorRepository {

    public static List<Author> authors = Arrays.asList(
            new Author("author-1", "Joshua", "Bloch", new String[] {"book-1", "book-4"}),
            new Author("author-2", "Douglas", "Adams", new String[] {"book-2", "book-5"}),
            new Author("author-3", "Bill", "Bryson", new String[] {"book-3", "book-6"}));

    public Author getById(String id) {
        return authors.stream().filter(author -> author.id().equals(id)).findFirst().orElse(null);
    }

}
