package com.sidenis.banking.task.service;

import com.sidenis.banking.task.dto.UserRequestDto;
import com.sidenis.banking.task.model.Transaction;
import com.sidenis.banking.task.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public Transaction createAndSaveTransaction(UserRequestDto dto) {
        Transaction transaction = getTransaction(dto);

        return transactionRepository.save(transaction);
    }

    private Transaction getTransaction(UserRequestDto dto) {
        Transaction transaction = null;

        switch (dto.getRequestType()) {
            case BALANCE:
                transaction = returnBalanceTransaction(dto);
                break;
            case TRANSFER:
                transaction = returnTransferTransaction(dto);
                break;
            case WITHDRAW:
                transaction = returnWithdrawTransaction(dto);
                break;
            case DEPOSIT:
                transaction = returnDepositTransaction(dto);
                break;
        }

        return transaction;
    }

    private Transaction returnBalanceTransaction(UserRequestDto dto) {
        Transaction transaction = new Transaction();
        transaction.setAccountId(dto.getAccountId());
        transaction.setIsLocal(true);
        transaction.setRequestType(dto.getRequestType());
        transaction.setUserPassport(dto.getUserPassport());
        return transaction;
    }

    private Transaction returnTransferTransaction(UserRequestDto dto) {
        return null;
    }

    private Transaction returnWithdrawTransaction(UserRequestDto dto) {
        return null;
    }

    private Transaction returnDepositTransaction(UserRequestDto dto) {
        return null;
    }
}

