package ru.otus.spring.hw2.service;

import ru.otus.spring.hw2.dao.Exam;
import ru.otus.spring.hw2.dao.Person;
import ru.otus.spring.hw2.dao.PersonImpl;

import java.util.Scanner;

public class TestingServiceImp implements TestingService {
    private final Exam exam;
    private final String greetingPhrase;
    private Person person;
    private int correctAnswers = 0;
    private int neededAnswers = 0;

    public TestingServiceImp(Exam exam, String greetingPhrase, int neededAnswers) {
        this.exam = exam;
        this.greetingPhrase = greetingPhrase;
        this.neededAnswers = neededAnswers;
    }

    @Override
    public void registerUser() {
        String personName;
        String personSurname;
        System.out.println(greetingPhrase);
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
