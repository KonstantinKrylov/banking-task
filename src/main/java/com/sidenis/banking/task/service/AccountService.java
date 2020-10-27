package com.sidenis.banking.task.service;

import com.sidenis.banking.task.dto.AccountDto;
import com.sidenis.banking.task.dto.UserRequestDto;
import com.sidenis.banking.task.exception.NoSuchAccountException;
import com.sidenis.banking.task.exception.NotEnoughBalanceException;
import com.sidenis.banking.task.model.Account;
import com.sidenis.banking.task.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account getAccountIfExists(UserRequestDto dto) throws NoSuchAccountException {
        Account acc = accountRepository.findByUser_FirstNameAndUser_LastNameAndUser_PassportAndId(dto.getUserFirstName(),
                dto.getUserLastName(),
                dto.getUserPassport(),
                dto.getAccountId());

        if (acc == null) {
            throw new NoSuchAccountException("Account doesn't exist!");
        }

        return acc;
    }

    public Account getAccountIfExists(AccountDto dto) throws NoSuchAccountException {
        Account acc = accountRepository.findByUser_FirstNameAndUser_LastNameAndUser_PassportAndId(dto.getUserFirstName(),
                dto.getUserLastName(),
                dto.getUserPassport(),
                dto.getAccountId());

        if (acc == null) {
            throw new NoSuchAccountException("Account doesn't exist!");
        }

        return acc;
    }

    public void checkIfEnoughBalance(UserRequestDto dto, Account account) throws NotEnoughBalanceException {
        if (account.getBalance() < dto.getTransactionValue()) {
            throw new NotEnoughBalanceException("Not enough balance for withdrawal or transfer operation!");
        }
    }
}
