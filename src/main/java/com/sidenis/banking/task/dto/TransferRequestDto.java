package com.sidenis.banking.task.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sidenis.banking.task.enums.RequestType;
import com.sidenis.banking.task.model.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TransferRequestDto extends RequestDto {

    public TransferRequestDto() {
        requestType = RequestType.TRANSFER;
        requestTime = LocalDateTime.now();
    }

    @JsonProperty
    private String userFirstName;
    @JsonProperty
    private String userLastNameName;
    @JsonProperty
    private String userPassport;
    @JsonProperty
    private Long fromAccountId;
    @JsonProperty
    private String destinationAccount;
    @JsonProperty
    private Boolean isLocal;
}
