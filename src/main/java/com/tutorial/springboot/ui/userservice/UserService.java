package com.tutorial.springboot.ui.userservice;

import com.tutorial.springboot.ui.model.UserDetailRequestModel;
import com.tutorial.springboot.ui.model.UserRes;

public interface UserService {

    UserRes createUser(UserDetailRequestModel userDetailRequestModel);

}
