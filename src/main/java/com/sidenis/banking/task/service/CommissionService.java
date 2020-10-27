package com.sidenis.banking.task.service;

import com.sidenis.banking.task.dto.UserRequestDto;
import com.sidenis.banking.task.enums.CommissionValue;
import com.sidenis.banking.task.model.Account;
import com.sidenis.banking.task.repository.AccountRepository;
import com.sidenis.banking.task.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Tuple;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommissionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public CommissionService(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }


    public Double calculateTrxCommission(UserRequestDto dto) {
        return dto.getIsLocal() ? 0.0 : dto.getTransactionValue() / 100;
    }

    @Transactional
    public void chargeMonthlyCommission() {


        Map<Long, Double> totalMap = new HashMap<>();
        List<Tuple> tuples = transactionRepository.calculateMonthlyTrxValue(LocalDateTime.now().minusMonths(1).toString());
        tuples.forEach(tuple -> totalMap.put(((Number) tuple.get("aid")).longValue(), ((Number) tuple.get("tsum")).doubleValue()));

        List<Account> accList = accountRepository.findAllByIdIn(totalMap.keySet());

        accList.parallelStream().forEach(acc -> {
            Double total = totalMap.get(acc.getId());
            if (total == 0) {
                acc.setBalance(acc.getBalance() - CommissionValue.ZERO.getValue());
            } else if (total > 30000) {
                acc.setBalance(acc.getBalance() - CommissionValue.EXCEED.getValue());
            } else if (total > 0 && total < 30000) {
                acc.setBalance(acc.getBalance() - CommissionValue.MIDDLE.getValue());
            }
        });

        accountRepository.saveAll(accList);
    }

}
