package ru.otus.spring.hw2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import ru.otus.spring.hw2.dao.QuestionsLoader;
import ru.otus.spring.hw2.dao.QuestionsLoaderImpl;

@DisplayName("Загрузчик текста тестов.")
public class QuestionsLoaderTest {

    @DisplayName("Проверка загрузки текста тестов.")
    @Test
    public void checkQuestionsLoaderTest() {
        Resource resource = new DefaultResourceLoader().getResource("classpath:/questions.csv");
        QuestionsLoader questionsLoader = new QuestionsLoaderImpl(resource);
        Assertions.assertEquals(5, questionsLoader.getRawQuestions().size());
    }
}
