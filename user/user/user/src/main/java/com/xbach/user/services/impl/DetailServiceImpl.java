package com.xbach.user.services.impl;

import com.xbach.user.dto.request.UserRequest;
import com.xbach.user.models.Detail;

import com.xbach.user.repositories.DetailRepository;
import com.xbach.user.services.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailServiceImpl implements DetailService {
    private final DetailRepository detailRepository;

    @Autowired
    public DetailServiceImpl(DetailRepository detailRepository) {
        this.detailRepository = detailRepository;
    }

    @Override
    public void register(UserRequest request, Long userId) {
        Detail detail = new Detail();

        detail.setFirstname(request.getFirstname());
        detail.setLastname(request.getLastname());
        detail.setAddress(request.getAddress());
        detail.setSex(request.getSex());
        detail.setDob(request.getDob());
        detail.setPhone(request.getPhone());
        detail.setUserId(userId);
        detailRepository.save(detail);
    }
}
