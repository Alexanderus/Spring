package ru.otus.spring.hw1.dao;

import java.util.List;

public class QuestionImpl implements Question {
    private final String question;
    private final String correctAnswer;
    private final List<String> answers;

    public QuestionImpl(String question, String correctAnswer, List<String> answers) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.answers = answers;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    public List<String> getAnswers() {
        return answers;
    }
}
