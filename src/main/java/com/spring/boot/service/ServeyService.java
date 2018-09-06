package com.spring.boot.service;

import java.util.List;

import com.spring.boot.model.Question;
import com.spring.boot.model.Survey;

public interface ServeyService {

	List<Question> retrieveQuestions(String surveyId);

	Question retrieveQuestion(String surveyId, String questionId);

	Question addQuestion(String surveyId, Question question);
}
