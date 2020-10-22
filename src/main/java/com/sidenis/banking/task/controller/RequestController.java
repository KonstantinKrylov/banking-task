package com.sidenis.banking.task.controller;

import com.sidenis.banking.task.dto.CheckBalanceDto;
import com.sidenis.banking.task.dto.TransferRequestDto;
import com.sidenis.banking.task.exception.NoSuchAccountException;
import com.sidenis.banking.task.model.Account;
import com.sidenis.banking.task.model.User;
import com.sidenis.banking.task.repository.AccountRepository;
import com.sidenis.banking.task.repository.UserRepository;
import com.sidenis.banking.task.service.RequestService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@Controller
@RequestMapping("banking/request")
public class RequestController {


    private final RequestService requestService;

    @Autowired
    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @ApiOperation(value = "transfer money")
    @PostMapping("/transfer")
    public ResponseEntity<Object> transferMoney(@RequestBody TransferRequestDto payload) {
        System.out.println();
        return null;
    }

    @ApiOperation(value = "check balance")
    @PostMapping("/balance")
    public ResponseEntity<Object> checkBalance(@RequestBody CheckBalanceDto payload) {
        if (!payload.checkNull()) {
            return new ResponseEntity<>("Insufficient data has been provided!", HttpStatus.BAD_REQUEST);
        }
        Account account = null;
        try {
            account = requestService.checkBalance(payload);
        } catch (NoSuchAccountException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(account);
    }
}