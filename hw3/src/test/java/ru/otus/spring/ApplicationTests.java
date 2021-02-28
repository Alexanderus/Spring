package ru.otus.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import ru.otus.spring.service.QuestionsLoaderService;
import ru.otus.spring.service.QuestionsLoaderServiceImpl;

@SpringBootTest(
        classes = {QuestionsLoaderServiceImpl.class}
)
class ApplicationTests {

    @Test
    void contextLoads() {
        Resource resource = new DefaultResourceLoader().getResource("classpath:/questions.csv");
        QuestionsLoaderService questionsLoaderService = new QuestionsLoaderServiceImpl(resource);
        Assertions.assertEquals(5, questionsLoaderService.getRawQuestions().size());
    }

}
