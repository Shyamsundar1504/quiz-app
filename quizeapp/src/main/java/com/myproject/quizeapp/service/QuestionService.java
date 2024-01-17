package com.myproject.quizeapp.service;

import com.myproject.quizeapp.dao.QuestionDao;
import com.myproject.quizeapp.entity.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
   QuestionDao questionDao;
    public ResponseEntity< List<Questions>> getAllQuestions(){
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
    }


    public ResponseEntity<List<Questions>> getAllQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
    }

    public ResponseEntity<String> addQuestions(Questions questions) {
        try {
            questionDao.save(questions);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new String(), HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteQuestions(Integer id) {
        try{
        questionDao.deleteById(id);
        return new ResponseEntity<>("delete successfully",HttpStatus.OK);
        }catch (Exception e) {
        e.printStackTrace();
        }
        return new ResponseEntity<>(new String(),HttpStatus.OK);
    }

    public ResponseEntity<String> updateQuestions(Questions questions,Integer id)
    {
        try {
            questionDao.save(questions);
            return new ResponseEntity<>("update successfully", HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new String(), HttpStatus.CREATED);
    }
}
