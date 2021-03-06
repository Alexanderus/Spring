package ru.otus.spring.dao;


import ru.otus.spring.service.QuestionParserService;

import java.util.List;

public class Questions {
    private QuestionParserService questionParserService;

    public Questions(QuestionParserService questionParserServiceImpl) {
        this.questionParserService = questionParserServiceImpl;
    }

    public List<Question> getQuestions() {
        return questionParserService.parseQuestions();
    }

}
