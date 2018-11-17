package com.tutorial.springboot.ui.userservice;

import com.tutorial.springboot.ui.model.UserDetailRequestModel;
import com.tutorial.springboot.ui.model.UserRes;
import com.tutorial.springboot.ui.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImp implements UserService {

    Map<String, UserRes> users;
    Utils utils;

    public UserServiceImp() {
    }

    @Autowired
    public UserServiceImp(Utils utils) {
        this.utils = utils;
    }

    @Override
    public UserRes createUser(UserDetailRequestModel userDetailRequestModel) {

        UserRes result = new UserRes();
        result.setFirstName(userDetailRequestModel.getFirstName());
        result.setLasttName(userDetailRequestModel.getLastName());
        result.setEmailAddress(userDetailRequestModel.getEmailAddress());

        String userId = utils.generateUserId();
        result.setUserId(userId);

        if (users == null) users = new HashMap<>();
        users.put(userId, result);

        return result;
    }
}
