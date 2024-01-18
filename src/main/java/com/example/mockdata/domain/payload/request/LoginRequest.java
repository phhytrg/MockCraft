package com.example.mockdata.domain.payload.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Data
public class LoginRequest {
    private String username;
    private String password;

}
