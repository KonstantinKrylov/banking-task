package com.sidenis.banking.task.model;

import javax.persistence.*;

@MappedSuperclass
public abstract class Persistable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
}
