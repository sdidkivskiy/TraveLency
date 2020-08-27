package org.TraveLency.security.model.dto;

import lombok.Data;

@Data
public class SignInDto {
    private String loginOrEmail;
    private String password;
}
