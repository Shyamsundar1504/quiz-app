package com.myproject.quizeapp.controller;

import com.myproject.quizeapp.dao.QuestionDao;
import com.myproject.quizeapp.entity.Questions;
import com.myproject.quizeapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;


    @GetMapping("allQuestions")
    public ResponseEntity<List<Questions>> getAllQuestions(){

        return  questionService.getAllQuestions();
    }


    @GetMapping("category/{category}")
    public ResponseEntity<List<Questions>> getAllQuestionsByCategory(@PathVariable String category){
        return questionService.getAllQuestionsByCategory(category);
    }


    @PostMapping("add")
    public ResponseEntity<String> addQuestions(@RequestBody Questions questions)
    {
        return questionService.addQuestions(questions);

    }


@DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteQuestions(@PathVariable Integer id) {
    return questionService.deleteQuestions(id);
    }


    @PutMapping("update")
    public ResponseEntity<String> updateQuestions(@RequestBody Questions questions ){
        return questionService.updateQuestions(questions, questions.getId());
    }
}
