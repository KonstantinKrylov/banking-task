package com.sidenis.banking.task.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.*;

@Table
@Entity
@Getter
@Setter
public class Account extends AccountEntity {
    @Column
    @NonNull
    private Double balance;

    @Column
    @NonNull
    private Boolean isActive;

    @NonNull
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof User)) {
            return false;
        }

        Account account = (Account) o;

        return new EqualsBuilder()
                .append(account, account.user)
                .append(account, account.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(user)
                .append(id)
                .toHashCode();
    }
}
