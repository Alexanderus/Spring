package ru.otus.spring.service;

import ru.otus.spring.dao.Question;

import java.util.List;

public interface QuestionParserService {
    List<Question> parseQuestions();
}
