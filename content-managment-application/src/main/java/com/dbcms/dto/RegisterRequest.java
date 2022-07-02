package com.dbcms.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

@Getter
@Setter
public class RegisterRequest {
    private String username;
    private String password;
    private String email;
}
