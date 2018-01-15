package ro.ubb.istudent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.ubb.istudent.dto.QuestionDto;
import ro.ubb.istudent.service.QuestionService;

import java.util.Optional;
@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @RequestMapping(value="/question/{id}", method= RequestMethod.GET)
    public ResponseEntity<QuestionDto> getQuestionById(@PathVariable String id){
        Optional<QuestionDto> questionDto = questionService.findQuestionById(id);
        return new ResponseEntity(questionDto.get(), HttpStatus.OK);
    }

    @RequestMapping(value="/question/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateQuestion(@RequestParam String id, @RequestBody QuestionDto questionDto){
        questionService.updateQuestionById(id, questionDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value="/question/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteQuestion(@RequestParam String id){
        questionService.deleteQuestionById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value="/question/save", method = RequestMethod.POST)
    public ResponseEntity saveQuestion(@RequestBody QuestionDto questionDto){
        return new ResponseEntity(questionService.saveQuestion(questionDto), HttpStatus.OK);
    }
}
