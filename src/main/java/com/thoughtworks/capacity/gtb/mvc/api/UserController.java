package com.thoughtworks.capacity.gtb.mvc.api;


import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.exception.UserNameAlreadyExistsException;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/user")
@Validated
public class UserController {

    UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity userRegister(@RequestBody @Valid User user) throws UserNameAlreadyExistsException {
        this.userService.userRegister(user);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @PostMapping("/login")
    public ResponseEntity<User> userLogin(@RequestBody @Valid User user) {
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.userLogin(user));
    }
}
