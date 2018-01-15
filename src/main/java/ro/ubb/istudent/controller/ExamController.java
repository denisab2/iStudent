package ro.ubb.istudent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.ubb.istudent.dto.ExamDto;
import ro.ubb.istudent.service.ExamService;

import java.util.Optional;

@Controller
public class ExamController {

    @Autowired
    private ExamService examService;

    @RequestMapping(value="/exam/{id}", method= RequestMethod.GET)
    public ResponseEntity<ExamDto> getExamById(@PathVariable String id){
        Optional<ExamDto> examDto = examService.findExamById(id);
        return new ResponseEntity(examDto.get(), HttpStatus.OK);
    }

    @RequestMapping(value="/exam/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateExam(@RequestParam String id, @RequestBody ExamDto examDto){
        examService.updateExamById(id, examDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value="/exam/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteExam(@RequestParam String id){
        examService.deleteExamById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value="/exam/save", method = RequestMethod.POST)
    public ResponseEntity saveExam(@RequestBody ExamDto examDto){
        return new ResponseEntity(examService.saveExam(examDto), HttpStatus.OK);
    }

}
