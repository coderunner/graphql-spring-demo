package org.inf5190.graphql.repository;

import java.util.Arrays;
import java.util.List;
import org.inf5190.graphql.model.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    public static List<Book> books =
            Arrays.asList(new Book("book-1", "Effective Java", 416, "author-1"),
                    new Book("book-2", "Le guide du voyageur galactique", 208, "author-2"),
                    new Book("book-3", "Nos voisins du dessous", 436, "author-3"),
                    new Book("book-4", "Java Puzzlers", 416, "author-1"),
                    new Book("book-5", "Le dernier restaurant avant la fin du monde", 208,
                            "author-2"),
                    new Book("book-6", "Promenons-nous dans les bois", 436, "author-3"));

    public Book getById(String id) {
        return books.stream().filter(book -> book.id().equals(id)).findFirst().orElse(null);
    }

}
