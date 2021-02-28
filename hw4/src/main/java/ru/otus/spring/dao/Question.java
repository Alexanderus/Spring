package ru.otus.spring.dao;

import java.util.List;

public interface Question {
    String getQuestion();
    String getCorrectAnswer();
    List<String> getAnswers();
}
