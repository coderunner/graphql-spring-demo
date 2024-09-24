package org.inf5190.graphql.repository;

import java.util.Arrays;
import java.util.List;
import org.inf5190.graphql.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    public static List<User> users =
            Arrays.asList(new User("user-1", "Albert", new String[] {"book-1", "book-2"}),
                    new User("user-2", "Jeanne", new String[] {"book-2"}),
                    new User("user-3", "Sophie", new String[] {"book-1", "book-2", "book-3"}));

    public User getById(String id) {
        return users.stream().filter(user -> user.id().equals(id)).findFirst().orElse(null);
    }

}
