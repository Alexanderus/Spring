package ru.otus.spring.service;

import org.springframework.context.MessageSource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import ru.otus.spring.config.AppProps;
import ru.otus.spring.dao.Exam;
import ru.otus.spring.dao.Person;

import java.util.Scanner;

@Service
public class TestingServiceImp implements TestingService {
    private final Exam exam;
    private Person person;
    private int correctAnswers = 0;
    private MessageSource messageSource;
    private AppProps props;


    public TestingServiceImp(Exam exam, MessageSource messageSource, AppProps props) {
        this.exam = exam;
        this.messageSource = messageSource;
        this.props = props;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void run() {
        registerUser();
        startExam();
        showResults();
    }

    @Override
    public void registerUser() {
        String personName;
        String personSurname;
        System.out.println(messageSource.getMessage("welcome.message", null, props.getLocale()));
        personName = new Scanner(System.in).nextLine();
        System.out.println("What is your surname ?");
        personSurname = new Scanner(System.in).nextLine();
        this.person = new Person(personName, personSurname);
    }

    @Override
    public void startExam() {
        exam.start();
        correctAnswers = exam.finish();
    }

    @Override
    public void showResults() {
        if (correctAnswers >= props.getNeededAnswers()) {
            System.out.println(String.format("Congratulations !!! \n%s passed exam ! \n%s correct answers.", person.getName(), correctAnswers));
        } else {
            System.out.println(String.format("Sorry =( \n%s don't pass exam.\n%s correct answers.", person.getName(), correctAnswers));
        }
    }
}
