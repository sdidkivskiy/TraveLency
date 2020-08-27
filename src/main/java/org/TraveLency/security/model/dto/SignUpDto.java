package org.TraveLency.security.model.dto;

import lombok.Data;

@Data
public class SignUpDto {

    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

}
