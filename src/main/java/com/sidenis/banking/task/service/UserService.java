package com.sidenis.banking.task.service;

import com.sidenis.banking.task.dto.UserDto;
import com.sidenis.banking.task.model.Account;
import com.sidenis.banking.task.model.User;
import com.sidenis.banking.task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User createAndSaveUser(UserDto dto) {

        User user = new User();
        Account account = new Account();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setIsAdmin(dto.getIsAdmin());
        user.setPassport(dto.getPassport());

        account.setBalance(dto.getAccount().getBalance());
        account.setIsActive(dto.getAccount().getIsActive());
        account.setUser(user);
        user.addAccount(account);

        return userRepository.save(user);

    }
}