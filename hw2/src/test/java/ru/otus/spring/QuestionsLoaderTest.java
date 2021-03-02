package ru.otus.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import ru.otus.spring.dao.QuestionsLoader;
import ru.otus.spring.dao.QuestionsLoaderImpl;

@DisplayName("Загрузчик текста тестов.")
public class QuestionsLoaderTest {

    @DisplayName("Проверка загрузки текста тестов.")
    @Test
    public void checkQuestionsLoaderTest() {
        System.out.println("TEST3");
        Resource resource = new DefaultResourceLoader().getResource("classpath:/questions.csv");
        QuestionsLoader questionsLoader = new QuestionsLoaderImpl(resource);
        Assertions.assertEquals(5, questionsLoader.getRawQuestions().size());
    }
}
