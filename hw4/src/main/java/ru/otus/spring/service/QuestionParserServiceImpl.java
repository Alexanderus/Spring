package ru.otus.spring.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.dao.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionParserServiceImpl implements QuestionParserService {
    private final QuestionsLoaderService questionsLoaderService;

    public QuestionParserServiceImpl(QuestionsLoaderServiceImpl questionsLoader) {
        this.questionsLoaderService = questionsLoader;
    }

    @Override
    public List<Question> parseQuestions() {
        return questionsLoaderService.getRawQuestions().stream().map(x -> {
            List<String> questionsAndAnsAsList = new ArrayList<>(Arrays.asList(x.split(";")));
            String question = null;
            String correctAnswer = null;
            if (questionsAndAnsAsList.size() > 0) {
                question = questionsAndAnsAsList.remove(0);
                correctAnswer = questionsAndAnsAsList.stream().filter(y -> y.startsWith("*")).findFirst().orElse("");

            }
            return new Question(question, correctAnswer, questionsAndAnsAsList);
        }).collect(Collectors.toList());
    }
}
