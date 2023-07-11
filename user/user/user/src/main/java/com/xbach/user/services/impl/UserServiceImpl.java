package com.xbach.user.services.impl;

import com.xbach.user.dto.request.LoginRequest;
import com.xbach.user.dto.request.UserRequest;
import com.xbach.user.dto.response.UserResponse;
import com.xbach.user.exceptions.LoginException;
import com.xbach.user.models.Detail;
import com.xbach.user.models.User;
import com.xbach.user.repositories.UserRepository;
import com.xbach.user.services.DetailService;
import com.xbach.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final DetailService detailService;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, DetailService detailService) {
        this.userRepository = userRepository;
        this.detailService = detailService;
    }

    @Override
    public UserResponse login(LoginRequest loginRequest) {
        User user = userRepository.getUserByUsername(loginRequest.getUsername());
        if(user == null){
            throw new LoginException("Username is not exist");
        }
        if(!user.getPassword().equals(loginRequest.getPassword())){
            throw new LoginException("Password is not match");
        }
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setUsername(user.getUsername());
        return userResponse;
    }
    public User getUserById(Long id){
        User user = userRepository.getUserById(id);
        if (user != null) {
            Detail detail = user.getDetail();

            Long detailId = detail.getId();
            String firstName = detail.getFirstname();
            String lastName = detail.getLastname();

        } else {
            return null;
        }

        return null;
    }

    @Override
    public void register(UserRequest request) {
       User user = new User();
       user.setUsername(request.getUsername());
       user.setPassword(request.getPassword());
        detailService.register( request, user.getId());
       userRepository.save(user);
    }

    @Override
    public UserResponse update(UserRequest request , Long userid) {
        User user = userRepository.findById(userid).orElse(null);
        if(user == null){
            try {
                throw new ChangeSetPersister.NotFoundException();
            } catch (ChangeSetPersister.NotFoundException e) {
                throw new RuntimeException(e);
            }

        }
        user.setUsername(request.getUsername());
        user.setUsername(request.getPassword());
        Detail detail = user.getDetail();
        detail.setFirstname(request.getDetail().getFirstname());
        detail.setLastname(request.getDetail().getLastname());
        detail.setAddress(request.getDetail().getAddress());
        detail.setSex(request.getDetail().getSex());
        detail.setDob(request.getDetail().getDob());
        detail.setPhone(request.getDetail().getPhone());
        userRepository.save(user);


        return null;
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if(user == null){
            try {
                throw new ChangeSetPersister.NotFoundException();
            } catch (ChangeSetPersister.NotFoundException e) {
                throw new RuntimeException(e);
            }

        }
        userRepository.delete(user.getDetail().getUser());
    }


}
