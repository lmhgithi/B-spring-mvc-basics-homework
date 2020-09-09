package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.Repository.UserRepository;
import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.exception.UserNameAlreadyExistsException;
import com.thoughtworks.capacity.gtb.mvc.exception.UserNameOrPassWordInvalidException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void userRegister(User user) throws UserNameAlreadyExistsException {
        userRepository.add(user);
    }

    public User userLogin(User user) throws UserNameOrPassWordInvalidException {
        Optional<User> userToLogin = userRepository.findByUserName(user.getUserName());
        if (userToLogin.isPresent()) {
            if (userToLogin.get().getPassWord().equals(user.getPassWord())) {
                return userToLogin.get();
            } else {
                throw new UserNameOrPassWordInvalidException();
            }
        } else {
            throw new UserNameOrPassWordInvalidException();
        }
    }
}
