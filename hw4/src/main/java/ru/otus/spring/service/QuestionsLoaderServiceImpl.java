package ru.otus.spring.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionsLoaderServiceImpl implements QuestionsLoaderService {
    private Resource questionsResource;

    public QuestionsLoaderServiceImpl(@Value("classpath:/questions.csv") final Resource questionsResource) {
        this.questionsResource = questionsResource;
    }

    @Override
    public List<String> getRawQuestions() {
        List<String> rawQuestions = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(questionsResource.getInputStream()));
            while (bufferedReader.ready()) {
                rawQuestions.add(bufferedReader.readLine());
            }
        } catch (IOException exception) {
            System.out.println("Ошибка при чтении файла с вопросами.");
            exception.printStackTrace();
        }
        return rawQuestions;
    }
}
