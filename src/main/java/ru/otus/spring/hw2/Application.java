package ru.otus.spring.hw2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.otus.spring.hw2.service.TestingService;

@ComponentScan
@Configuration
@PropertySource("classpath:/app.properties")
public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Application.class);
        TestingService testingService = context.getBean(TestingService.class);
        testingService.registerUser();
        testingService.startExam();
        testingService.showResults();
        context.close();
    }
}
