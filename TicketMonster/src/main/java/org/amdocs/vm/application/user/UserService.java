package org.amdocs.vm.application.user;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UserService {

    private final static List<User> USERS = Arrays.asList(
            new User("1", "usr1", "middle1", "lastName1"),
            new User("2", "usr2", "middle2", "lastName2"));

    public Optional<User> getUserById(final String id){
        return USERS.stream().filter(user -> user.getId().equals(id)).findFirst();
    }
}
