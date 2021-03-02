package ru.otus.spring.dao;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionsImpl implements Questions {
    private final QuestionsLoader questionsLoader;

    public QuestionsImpl(QuestionsLoaderImpl questionsLoader) {
        this.questionsLoader = questionsLoader;
    }

    @Override
    public List<Question> getQuestions() {
        return questionsLoader.getRawQuestions().stream().map(x -> {
            List<String> questionsAndAnsAsList = new ArrayList<>(Arrays.asList(x.split(";")));
            String question = null;
            String correctAnswer = null;
            if (questionsAndAnsAsList.size() > 0) {
                question = questionsAndAnsAsList.remove(0);
                correctAnswer = questionsAndAnsAsList.stream().filter(y -> y.startsWith("*")).findFirst().orElse("");

            }
            return new QuestionImpl(question, correctAnswer, questionsAndAnsAsList);
        }).collect(Collectors.toList());
    }
}
