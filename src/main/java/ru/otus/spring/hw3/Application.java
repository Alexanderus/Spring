package ru.otus.spring.hw3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import ru.otus.spring.hw3.service.TestingService;

@SpringBootApplication
@PropertySource("apps.yaml")
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        TestingService testingService = ctx.getBean(TestingService.class);
        testingService.registerUser();
        testingService.startExam();
        testingService.showResults();
    }
}
