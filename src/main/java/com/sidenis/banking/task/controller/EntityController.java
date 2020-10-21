package com.sidenis.banking.task.controller;

import com.sidenis.banking.task.dto.UserDto;
import com.sidenis.banking.task.model.Account;
import com.sidenis.banking.task.model.User;
import com.sidenis.banking.task.repository.AccountRepository;
import com.sidenis.banking.task.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("banking")
public class EntityController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AccountRepository accountRepository;

    @ApiOperation(value = "create new User")
    @PostMapping("/user/create")
    public ResponseEntity<Object> crateUser(@RequestBody UserDto payload) {

        User user = new User();
        Account account = new Account();

        try{
            user.setFirstName(payload.getFirstName());
            user.setLastName(payload.getLastName());
            user.setIsAdmin(payload.getIsAdmin());
            user.setPassport(payload.getPassport());

            account.setBalance(payload.getAccount().getBalance());
            account.setIsActive(payload.getAccount().getIsActive());
            account.setUser(user);
            user.addAccount(account);
        }catch (NullPointerException e){
            e.printStackTrace();
            return new ResponseEntity<>("Insufficient data has been provided!", HttpStatus.BAD_REQUEST);
        }

        userRepository.save(user);

        return ResponseEntity.ok().body(user);

    }
}
