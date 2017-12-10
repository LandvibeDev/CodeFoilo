package com.landvibe.codefolio.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserInfoRequest {
    private String username;
    private String name;
    private String job;
}
