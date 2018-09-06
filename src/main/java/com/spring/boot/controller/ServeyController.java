package com.spring.boot.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.boot.model.Question;
import com.spring.boot.service.ServeyService;

@RestController
public class ServeyController {
	@Autowired
	ServeyService service;
	@GetMapping("/surveys/{surveyId}/questions")
	public List<Question> retriveQuetions(@PathVariable String surveyId){
		return service.retrieveQuestions(surveyId);
	}
	
	@GetMapping(path = "/surveys/{surveyId}/questions/{questionId}")
    public Question retrieveQuestion(@PathVariable String surveyId,
            @PathVariable String questionId) {
        return service.retrieveQuestion(surveyId, questionId);
    }

	@PostMapping("/surveys/{surveyId}/questions")
    ResponseEntity<?> add(@PathVariable String surveyId,
            @RequestBody Question question) {
        Question createdTodo = service.addQuestion(surveyId, question);
        if (createdTodo == null) {
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdTodo.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
