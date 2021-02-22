package ru.otus.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.hw1.service.TestingService;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring-context.xml");
        TestingService testingService = context.getBean(TestingService.class);
        testingService.registerUser();
        testingService.startExam();
        testingService.showResults();
        context.close();
    }
}
