package ro.ubb.istudent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.ubb.istudent.dto.CourseDto;
import ro.ubb.istudent.service.CourseService;

import java.util.Optional;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "course/{id}", method = RequestMethod.GET)
    public ResponseEntity<CourseDto> getCourseById(@PathVariable String id){
        Optional<CourseDto> courseDto = courseService.findCourseById(id);
        return new ResponseEntity(courseDto.get(), HttpStatus.OK);
    }

    @RequestMapping(value="/course/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateCourse(@RequestParam String id, @RequestBody CourseDto courseDto){
        courseService.updateCourseById(id, courseDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value="/course/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteCourse(@RequestParam String id){
        courseService.deleteCourseById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value="/course/save", method = RequestMethod.POST)
    public ResponseEntity saveCourse(@RequestBody CourseDto courseDto){
        return new ResponseEntity(courseService.saveCourse(courseDto), HttpStatus.OK);
    }
}
