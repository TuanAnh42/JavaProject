package com.xbach.user.services;

import com.xbach.user.dto.request.UserRequest;

public interface DetailService {
    void register(UserRequest request, Long id);
}
