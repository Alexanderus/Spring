package ru.otus.spring.hw3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.otus.spring.hw3.dao.*;

@Import(QuestionsImpl.class)
@Configuration
public class DaoConfig {

    @Bean
    public Exam exam(Questions questions) {
        return new ExamImpl(questions);
    }
}
