package com.sidenis.banking.task.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public abstract class ImpersonatedEntity extends Persistable {
    @Column
    @NonNull
    protected String firstName;
    @Column
    @NonNull
    protected String lastName;
    @Column
    @NonNull
    protected String passport;
}
