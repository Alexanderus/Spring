package ru.otus.spring.dao;

public class Person {
    private final String name;
    private final String surName;

    public Person(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surName;
    }
}
