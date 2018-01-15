package ro.ubb.istudent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.ubb.istudent.dto.CourseWeekDto;
import ro.ubb.istudent.service.CourseWeekService;

import java.util.Optional;

@Controller
public class CourseWeekController {

    @Autowired
    private CourseWeekService courseWeekService;

    @RequestMapping(value="/course-week/{id}", method= RequestMethod.GET)
    public ResponseEntity<CourseWeekDto> getCourseWeekById(@PathVariable String id){
        Optional<CourseWeekDto> courseWeekDto = courseWeekService.findCourseWeekById(id);
        return new ResponseEntity(courseWeekDto.get(), HttpStatus.OK);
    }

    @RequestMapping(value="/course-week/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateCourseWeek(@RequestParam String id, @RequestBody CourseWeekDto courseWeekDto){
        courseWeekService.updateCourseWeekById(id, courseWeekDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value="/course-week/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteCourseWeek(@RequestParam String id){
        courseWeekService.deleteCourseWeekById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value="/course-week/save", method = RequestMethod.POST)
    public ResponseEntity saveCourseWeek(@RequestBody CourseWeekDto courseWeekDto){
        return new ResponseEntity(courseWeekService.saveCourseWeek(courseWeekDto), HttpStatus.OK);
    }

}
