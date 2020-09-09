package com.thoughtworks.capacity.gtb.mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
public class User {

    Integer id;

    @NotNull
    @Pattern(regexp = "[0-9A-Za-z_]*")
    @Length(min = 3, max = 10)
    String userName;

    @NotNull
    @Length(min = 5, max = 12)
    String passWord;

    @Email
    String email;

}
