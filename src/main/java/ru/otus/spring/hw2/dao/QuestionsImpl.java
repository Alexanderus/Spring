package ru.otus.spring.hw2.dao;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class QuestionsImpl implements Questions, ApplicationContextAware {
    private ApplicationContext context;
    private String questionsCSVPath;

    public QuestionsImpl(@Value("${questionsCSVPath}") final String questionsCSVPath) {
        this.questionsCSVPath = questionsCSVPath;
    }

    @Override
    public List<Question> getQuestions() {
        BufferedReader bufferedReader;
        List<Question> questions = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(context.getResource(questionsCSVPath).getInputStream()));
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                List<String> questionsAndAnsAsList = new ArrayList<>(Arrays.asList(line.split(";")));
                if (questionsAndAnsAsList.size() > 0) {
                    String question = questionsAndAnsAsList.remove(0);
                    String correctAnswer = questionsAndAnsAsList.stream().filter(x -> x.startsWith("*")).findFirst().orElse("");
                    questions.add(new QuestionImpl(question, correctAnswer, questionsAndAnsAsList));
                }
            }
        } catch (IOException exception) {
            System.out.println("Ошибка при чтении файла с вопросами.");
            exception.printStackTrace();
        }
        return questions;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
