package com.sidenis.banking.task.service;

import com.sidenis.banking.task.dto.CheckBalanceDto;
import com.sidenis.banking.task.dto.UserRequestDto;
import com.sidenis.banking.task.exception.NoSuchAccountException;
import com.sidenis.banking.task.model.Account;
import com.sidenis.banking.task.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestService {

    private final AccountRepository accountRepository;
    private final TransactionService transactionService;

    @Autowired
    public RequestService(AccountRepository accountRepository, TransactionService transactionService) {
        this.accountRepository = accountRepository;
        this.transactionService = transactionService;
    }

    public Account checkBalance(CheckBalanceDto dto) throws NoSuchAccountException{
        return getAccountIfExists(dto);
    }

    private Account getAccountIfExists(UserRequestDto dto) throws NoSuchAccountException {
        Account acc = accountRepository.findByUser_FirstNameAndUser_LastNameAndUser_PassportAndId(dto.getUserFirstName(),
                dto.getUserLastName(),
                dto.getUserPassport(),
                dto.getAccountId());

        if (acc == null) {
            throw new NoSuchAccountException("Account doesn't exist!");
        }

        transactionService.createAndSaveTransaction(dto);

        return acc;
    }
}
