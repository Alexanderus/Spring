package ru.otus.spring.hw1.dao;

public class PersonImpl implements Person {
    private final String name;

    public PersonImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
