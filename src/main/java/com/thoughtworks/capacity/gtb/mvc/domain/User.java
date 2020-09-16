package com.thoughtworks.capacity.gtb.mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class User {

    Integer id;

    @NotNull
    @Pattern(regexp = "[0-9A-Za-z_]*")
    @Size(min = 3, max = 10)
    String userName;

    @NotNull
    @Size(min = 5, max = 12)
    String passWord;

    @Email
    String email;

}
