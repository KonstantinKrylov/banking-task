package com.sidenis.banking.task.controller;

import com.sidenis.banking.task.dto.UserDto;
import com.sidenis.banking.task.model.Account;
import com.sidenis.banking.task.model.User;
import com.sidenis.banking.task.service.AccountService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("banking/account")
public class AccountController {


    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @ApiOperation(value = "create new User")
    @PostMapping("/user/create")
    public ResponseEntity<Object> createUser(@RequestBody UserDto payload) {

        User user = new User();

        try {
            user = accountService.createUser(payload);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Insufficient data has been provided! " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok().body(user);
    }
}
