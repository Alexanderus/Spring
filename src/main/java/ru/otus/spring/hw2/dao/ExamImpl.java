package ru.otus.spring.hw2.dao;


import java.util.Scanner;

public class ExamImpl implements Exam {
    private final Questions questions;
    private int correctAnswers;


    public ExamImpl(Questions questions) {
        this.questions = questions;
    }

    @Override
    public void start() {
        questions.getQuestions().forEach(x -> {
            System.out.println(x.getQuestion());
            for (int i = 0; i < x.getAnswers().size(); i++) {
                System.out.println(i + 1 + ". " + x.getAnswers().get(i).replace("*", ""));
            }
            System.out.println("Enter correct answer: ");
            String numberOfAnswer = new Scanner(System.in).nextLine();
            if (x.getCorrectAnswer().contains(x.getAnswers().get(Integer.parseInt(numberOfAnswer ) - 1))) {
                correctAnswers++;
            }
        });
    }

    @Override
    public int finish() {
        return this.correctAnswers;
    }
}
