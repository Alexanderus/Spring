package ru.otus.spring.hw3.service;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import ru.otus.spring.hw3.dao.Exam;
import ru.otus.spring.hw3.dao.Person;
import ru.otus.spring.hw3.dao.PersonImpl;

import java.util.Locale;
import java.util.Scanner;

public class TestingServiceImp implements TestingService {
    private final Exam exam;
    private Person person;
    private int correctAnswers = 0;
    private int neededAnswers = 0;
    private MessageSource messageSource;
    private Locale locale;

    public TestingServiceImp(Exam exam, MessageSource messageSource, int neededAnswers, Locale locale) {
        this.exam = exam;
        this.messageSource = messageSource;
        this.neededAnswers = neededAnswers;
    }

    @Override
    public void registerUser() {
        String personName;
        String personSurname;
        System.out.println(messageSource.getMessage("welcome.message", locale));
        personName = new Scanner(System.in).nextLine();
        System.out.println("What is your surname ?");
        personSurname = new Scanner(System.in).nextLine();
        this.person = new PersonImpl(personName, personSurname);
    }

    @Override
    public void startExam() {
        exam.start();
        correctAnswers = exam.finish();
    }

    @Override
    public void showResults() {
        if (correctAnswers >= neededAnswers) {
            System.out.println(String.format("Congratulations !!! \n%s passed exam ! \n%s correct answers.", person.getName(), correctAnswers));
        } else {
            System.out.println(String.format("Sorry =( \n%s don't pass exam.\n%s correct answers.", person.getName(), correctAnswers));
        }
    }
}
