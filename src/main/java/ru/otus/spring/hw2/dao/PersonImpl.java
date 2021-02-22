package ru.otus.spring.hw2.dao;

public class PersonImpl implements Person {
    private final String name;
    private final String surName;

    public PersonImpl(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getSurname() {
        return this.surName;
    }
}
