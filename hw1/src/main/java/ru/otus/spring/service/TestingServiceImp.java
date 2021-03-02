package ru.otus.spring.service;

import ru.otus.spring.dao.Exam;

import java.util.Scanner;

public class TestingServiceImp implements TestingService {
    private final Exam exam;
    private final String greetingQuestion;
    private String personName;
    private int correctAnswers = 0;

    public TestingServiceImp(Exam exam, String greetingQuestion) {
        this.exam = exam;
        this.greetingQuestion = greetingQuestion;
    }

    @Override
    public void registerUser() {
        System.out.println(greetingQuestion);
        personName = new Scanner(System.in).nextLine();
    }

    @Override
    public void startExam() {
        exam.start();
        correctAnswers = exam.finish();
    }

    @Override
    public void showResults() {
        System.out.println(String.format("Person %s made %s correct answers.", personName, correctAnswers));
    }
}
