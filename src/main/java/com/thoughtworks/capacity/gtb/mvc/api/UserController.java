package com.thoughtworks.capacity.gtb.mvc.api;


import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.exception.UserNameAlreadyExistsException;
import com.thoughtworks.capacity.gtb.mvc.exception.UserNameOrPassWordInvalidException;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/user")
@Validated
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void userRegister(@RequestBody @Valid User user) throws UserNameAlreadyExistsException {
        this.userService.register(user);
    }


    @PostMapping("/login")
    public User userLogin(@RequestBody @Valid User user)
            throws UserNameOrPassWordInvalidException {
        return this.userService.login(user);
    }
}
