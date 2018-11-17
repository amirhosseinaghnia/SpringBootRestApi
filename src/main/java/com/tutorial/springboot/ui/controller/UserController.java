package com.tutorial.springboot.ui.controller;

import com.tutorial.springboot.ui.exceptions.UserServiceException;
import com.tutorial.springboot.ui.model.UpdateUserDetailRequestModel;
import com.tutorial.springboot.ui.model.UserDetailRequestModel;
import com.tutorial.springboot.ui.model.UserRes;
import com.tutorial.springboot.ui.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    Map<String, UserRes> users;

    @Autowired
    UserService userService;

    @GetMapping()
    public String getUsers(@RequestParam (value = "page", defaultValue = "1") int page,
                           @RequestParam (value = "limit", defaultValue = "50") int limit,
                           @RequestParam (value = "sort", required = false) String sort) {
        return "call form getUsers with page: " + page + " and limit of: " + limit + " sort: " + sort;
    }

    @GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRes> getUser(@PathVariable String userId) {

//        String userName = null;
//        int length = userName.length();

//        if (true) throw new UserServiceException("UserServiceException thrown");

        if (users.containsKey(userId)) {
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRes> createUser(@Valid @RequestBody UserDetailRequestModel userDetailRequestModel) {

        UserRes result = userService.createUser(userDetailRequestModel);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping(path = "/{userId}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRes> updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailRequestModel
            updateUserDetailRequestModel) {


        UserRes res = users.get(userId);
        res.setFirstName(updateUserDetailRequestModel.getFirstName());
        res.setLasttName(updateUserDetailRequestModel.getLastName());

        users.put(userId, res);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {

        users.remove(id);
        return ResponseEntity.noContent().build();
    }

}
