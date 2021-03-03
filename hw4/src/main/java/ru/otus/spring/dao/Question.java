package ru.otus.spring.dao;

import java.util.List;

public class Question {
    private final String question;
    private final String correctAnswer;
    private final List<String> answers;

    public Question(String question, String correctAnswer, List<String> answers) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public List<String> getAnswers() {
        return answers;
    }
}
