package com.sidenis.banking.task.model;

import lombok.Getter;

import javax.persistence.*;

@Getter
@MappedSuperclass
public abstract class Persistable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
}
