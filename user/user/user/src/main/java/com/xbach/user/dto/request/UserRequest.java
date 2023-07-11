package com.xbach.user.dto.request;

import com.xbach.user.models.Detail;
import lombok.Data;

@Data
public class UserRequest {

    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String address;
    private int sex;
    private String dob;
    private String phone;
    private long user_id;
    private Detail detail;
}
