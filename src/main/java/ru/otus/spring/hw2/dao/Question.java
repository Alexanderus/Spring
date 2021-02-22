package ru.otus.spring.hw2.dao;

import java.util.List;

public interface Question {
    String getQuestion();
    String getCorrectAnswer();
    List<String> getAnswers();
}
