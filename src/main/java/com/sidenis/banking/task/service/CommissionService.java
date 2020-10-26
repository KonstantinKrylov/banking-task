package com.sidenis.banking.task.service;

import com.sidenis.banking.task.dto.UserRequestDto;
import org.springframework.stereotype.Service;

@Service
public class CommissionService {
    public Double calculateTrxCommission(UserRequestDto dto){
        return dto.getIsLocal() ? 0.0 : dto.getTransactionValue() / 100;
    }
}
