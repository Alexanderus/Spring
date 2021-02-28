package ru.otus.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.otus.spring.dao.*;
import ru.otus.spring.service.QuestionParserService;
import ru.otus.spring.service.QuestionParserServiceImpl;

@Import(QuestionParserServiceImpl.class)
@Configuration
public class DaoConfig {

    @Bean
    public Questions questions(QuestionParserService questionParserServiceImpl) {
        return new Questions(questionParserServiceImpl);
    }

    @Bean
    public Exam exam(Questions questions) {
        return new ExamImpl(questions);
    }
}
