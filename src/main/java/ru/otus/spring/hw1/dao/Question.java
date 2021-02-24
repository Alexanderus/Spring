package ru.otus.spring.hw1.dao;

import java.util.List;

public interface Question {
    String getQuestion();
    String getCorrectAnswer();
    List<String> getAnswers();
}
