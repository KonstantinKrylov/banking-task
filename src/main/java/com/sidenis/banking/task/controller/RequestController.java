package com.sidenis.banking.task.controller;

import com.sidenis.banking.task.dto.*;
import com.sidenis.banking.task.exception.NoSuchAccountException;
import com.sidenis.banking.task.exception.NotEnoughBalanceException;
import com.sidenis.banking.task.model.Account;
import com.sidenis.banking.task.model.Transaction;
import com.sidenis.banking.task.repository.TransactionRepository;
import com.sidenis.banking.task.service.RequestService;
import com.sidenis.banking.task.service.TransactionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("banking/request")
public class RequestController {

    private final RequestService requestService;

    @Autowired
    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @ApiOperation(value = "Transfer money")
    @PostMapping("/transfer")
    public ResponseEntity<Object> transferMoney(@RequestBody TransferDto payload) {
        if (!payload.checkNull()) {
            return new ResponseEntity<>("Insufficient data has been provided!", HttpStatus.BAD_REQUEST);
        }
        Account account;
        try {
            account = requestService.transferMoney(payload);
        } catch (NoSuchAccountException | NotEnoughBalanceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(account);
    }

    @ApiOperation(value = "Check balance")
    @PostMapping("/balance")
    public ResponseEntity<Object> checkBalance(@RequestBody CheckBalanceDto payload) {
        if (!payload.checkNull()) {
            return new ResponseEntity<>("Insufficient data has been provided!", HttpStatus.BAD_REQUEST);
        }
        Account account;
        try {
            account = requestService.checkBalance(payload);
        } catch (NoSuchAccountException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(account);
    }

    @ApiOperation(value = "Deposit money")
    @PostMapping("/deposit")
    public ResponseEntity<Object> depositMoney(@RequestBody DepositDto payload) {
        if (!payload.checkNull()) {
            return new ResponseEntity<>("Insufficient data has been provided!", HttpStatus.BAD_REQUEST);
        }
        Account account;
        try {
            account = requestService.depositMoney(payload);
        } catch (NoSuchAccountException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(account);
    }

    @ApiOperation(value = "Withdraw money")
    @PostMapping("/withdraw")
    public ResponseEntity<Object> withdrawMoney(@RequestBody WithdrawDto payload) {
        if (!payload.checkNull()) {
            return new ResponseEntity<>("Insufficient data has been provided!", HttpStatus.BAD_REQUEST);
        }
        Account account;
        try {
            account = requestService.withdrawMoney(payload);
        } catch (NoSuchAccountException | NotEnoughBalanceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(account);
    }

    @ApiOperation(value = "Get transaction history after specific date")
    @PostMapping("/history")
    public ResponseEntity<Object> getHistory(@RequestBody TransactionHistoryDto payload) {
        if (!payload.checkNull()) {
            return new ResponseEntity<>("Insufficient data has been provided!", HttpStatus.BAD_REQUEST);
        }
        List<Transaction> history;
        try {
            history = requestService.getHistory(payload);
        } catch (NoSuchAccountException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(history);
    }

}