package com.sidenis.banking.task.controller;

import com.sidenis.banking.task.dto.TransferRequestDto;
import com.sidenis.banking.task.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("banking/request")
public class RequestController {

    @Autowired
    UserRepository userRepository;

    @ApiOperation(value = "transfer money")
    @PostMapping("/transfer")
    public ResponseEntity<Object> transferMoney(@RequestBody TransferRequestDto payload) {
        System.out.println();
        return null;
    }
}
