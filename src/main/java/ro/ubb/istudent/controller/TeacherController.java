package ro.ubb.istudent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.ubb.istudent.dto.TeacherDto;
import ro.ubb.istudent.service.TeacherService;

import java.util.Optional;

@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value="/teacher/{id}", method= RequestMethod.GET)
    public ResponseEntity<TeacherDto> getTeacherById(@PathVariable String id){
        Optional<TeacherDto> teacherDto = teacherService.findTeacherById(id);
        return new ResponseEntity(teacherDto.get(), HttpStatus.OK);
    }

    @RequestMapping(value="/teacher/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateTeacher(@RequestParam String id, @RequestBody TeacherDto teacherDto){
        teacherService.updateTeacherById(id, teacherDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value="/teacher/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteTeacher(@RequestParam String id){
        teacherService.deleteTeacherById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value="/teacher/save", method = RequestMethod.POST)
    public ResponseEntity saveTeacher(@RequestBody TeacherDto teacherDto){
        return new ResponseEntity(teacherService.saveTeacher(teacherDto), HttpStatus.OK);
    }
}
