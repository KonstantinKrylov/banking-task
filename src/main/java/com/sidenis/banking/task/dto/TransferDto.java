package com.sidenis.banking.task.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sidenis.banking.task.enums.RequestType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@JsonAutoDetect(setterVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.NONE)
public class TransferDto extends UserRequestDto {
    public TransferDto() {
        requestType = RequestType.TRANSFER;
        requestTime = LocalDateTime.now();
    }

    @Override
    public boolean checkNull() {
        return super.checkNull() &&
                transactionValue != null &&
                isLocal != null &&
                destinationAccount != null;

    }

    @JsonProperty
    @Override
    public void setTransactionValue(Double transactionValue) {
        super.setTransactionValue(transactionValue);
    }

    @JsonProperty
    @Override
    public void setDestinationAccount(AccountDto destinationAccount) {
        super.setDestinationAccount(destinationAccount);
    }

    @JsonProperty
    @Override
    public void setIsLocal(Boolean isLocal) {
        super.setIsLocal(isLocal);
    }
}
