package com.sidenis.banking.task.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table
@Getter
@Setter
public class User extends ImpersonatedEntity {

    @Column
    @NonNull
    private Boolean isAdmin;

    @NonNull
    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Account> accounts = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof User)) {
            return false;
        }

        User user = (User) o;

        return new EqualsBuilder()
                .append(firstName, user.firstName)
                .append(lastName, user.lastName)
                .append(passport, user.passport)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(firstName)
                .append(lastName)
                .append(passport)
                .toHashCode();
    }


    public void addAccount(Account account) {
        accounts.add(account);
        account.setUser(this);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
        account.setUser(null);
    }


}