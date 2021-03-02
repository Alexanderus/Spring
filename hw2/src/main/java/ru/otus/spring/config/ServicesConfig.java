package ru.otus.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.otus.spring.dao.Exam;
import ru.otus.spring.service.TestingService;
import ru.otus.spring.service.TestingServiceImp;

@Import(DaoConfig.class)
@Configuration
public class ServicesConfig {

    @Bean
    public TestingService testingService(Exam exam,
                                         @Value("${greetingPhrase}") final String greetingPhrase,
                                         @Value("${neededAnswers}") final int neededAnswers) {
        return new TestingServiceImp(exam, greetingPhrase, neededAnswers);
    }
}
