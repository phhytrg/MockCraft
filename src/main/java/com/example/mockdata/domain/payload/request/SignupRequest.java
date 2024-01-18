package com.example.mockdata.domain.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
public class SignupRequest {
    String username;
    String password;
    String name;
    Set<String> roles;
}
