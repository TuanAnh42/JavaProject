package com.xbach.user.services;

import com.xbach.user.dto.request.LoginRequest;
import com.xbach.user.dto.request.UserRequest;
import com.xbach.user.dto.response.UserResponse;

public interface UserService {
    UserResponse login(LoginRequest loginRequest);

    void register(UserRequest request);
    UserResponse update(UserRequest request , Long userid);
    void delete(Long id);


}
