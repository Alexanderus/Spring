package ru.otus.spring.hw3.dao;

import java.util.List;

public interface Question {
    String getQuestion();
    String getCorrectAnswer();
    List<String> getAnswers();
}
