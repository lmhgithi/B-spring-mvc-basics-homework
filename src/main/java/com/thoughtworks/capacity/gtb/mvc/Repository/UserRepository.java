package com.thoughtworks.capacity.gtb.mvc.Repository;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.exception.UserNameAlreadyExistsException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    static List<User> users = new ArrayList<>();
    static Integer userId = 1;

    public void add(User user) throws UserNameAlreadyExistsException {
        if (findUserByName(user.getUserName())){
            throw new UserNameAlreadyExistsException();
        }

            user.setId(userId);
        userId += 1;
        users.add(user);
    }

    private boolean findUserByName(String userName) {
        return users.stream().anyMatch(user -> user.getUserName().equals(userName));
    }
}
