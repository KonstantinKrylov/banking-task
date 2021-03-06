package com.sidenis.banking.task.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public abstract class ImpersonatedEntity extends Persistable {
    @Column
    protected String firstName;
    @Column
    protected String lastName;
    @Column
    protected String passport;
}
