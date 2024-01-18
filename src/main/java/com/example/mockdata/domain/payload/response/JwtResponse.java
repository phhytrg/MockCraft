package com.example.mockdata.domain.payload.response;

import com.example.mockdata.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class JwtResponse {
    private String token;
    private String id;
    private String username;
    private String name;
    private List<String> roles;
}
