package com.thoughtworks.capacity.gtb.mvc.Repository;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.exception.UserNameAlreadyExistsException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    static List<User> users = new ArrayList<User>(){
        {
            add(new User(1, "xiaoming", "12345", "a@c"));
            add(new User(2, "dahei", "12345", "b@c"));
        }
    };
    static Integer userId = 3;

    public void add(User user) {
        user.setId(userId);
        userId += 1;
        users.add(user);
    }

    public Optional<User> findByUserName(String userName) {
        return users.stream().
                filter(user -> user.getUserName().equals(userName)).
                findFirst();
    }
}
