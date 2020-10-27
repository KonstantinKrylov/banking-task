package com.sidenis.banking.task.controller;

import com.sidenis.banking.task.dto.UserDto;
import com.sidenis.banking.task.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("banking/account")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "create new User")
    @PostMapping("/user/create")
    public ResponseEntity<Object> createUser(@RequestBody UserDto payload) {

        if (!payload.checkNull()) {
            return new ResponseEntity<>("Insufficient data has been provided!", HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok().body(userService.createAndSaveUser(payload));
    }
}
