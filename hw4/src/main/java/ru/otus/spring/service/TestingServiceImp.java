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

    @Override
    public void registerUser() {
        String personName;
        String personSurname;
        System.out.println(messageSource.getMessage("welcome.message", null, props.getLocale()));
        System.out.println(messageSource.getMessage("nameQuestion.message", null, props.getLocale()));
        personName = new Scanner(System.in).nextLine();
        System.out.println(messageSource.getMessage("surnameQuestion.message", null, props.getLocale()));
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
            System.out.println(messageSource.getMessage("congratulations.message", null, props.getLocale()));
            System.out.println(messageSource.getMessage("examPassed.message", new String[]{person.getName(), Integer.toString(correctAnswers)}, props.getLocale()));
        } else {
            System.out.println(messageSource.getMessage("sorry.message", null, props.getLocale()));
            System.out.println(messageSource.getMessage("failExam.message", new String[]{person.getName(), Integer.toString(correctAnswers)}, props.getLocale()));
        }
    }
}
