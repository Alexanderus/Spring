package ru.otus.spring.hw3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import ru.otus.spring.hw3.dao.QuestionsLoader;
import ru.otus.spring.hw3.dao.QuestionsLoaderImpl;

@SpringBootTest(classes = {QuestionsLoaderImpl.class})
class ApplicationTests {

	@Test
	void contextLoads() {
		Resource resource = new DefaultResourceLoader().getResource("classpath:/questions.csv");
		QuestionsLoader questionsLoader = new QuestionsLoaderImpl(resource);
		Assertions.assertEquals(5, questionsLoader.getRawQuestions().size());
	}

}
