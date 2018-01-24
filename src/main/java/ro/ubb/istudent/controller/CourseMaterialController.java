package ro.ubb.istudent.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.ubb.istudent.dto.CourseMaterialDto;
import ro.ubb.istudent.service.CourseMaterialService;

import javax.print.DocFlavor;
import java.util.Optional;

@Controller
public class CourseMaterialController {

    @Autowired
    private CourseMaterialService courseMaterialService;

    @RequestMapping(value = "course-material/{id}", method = RequestMethod.GET)
    public ResponseEntity<CourseMaterialDto> getCourseMaterialById(@PathVariable String id){
        Optional<CourseMaterialDto> courseMaterialDto = courseMaterialService.findCourseMaterialById(id);
        return new ResponseEntity<>(courseMaterialDto.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "course-material/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateCourseMaterial(@RequestParam String id, @RequestBody CourseMaterialDto courseMaterialDto){
        courseMaterialService.updateCourseMaterialById(id, courseMaterialDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value =  "course-material/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteCourseMaterial(@RequestParam String id){
        courseMaterialService.deleteCourseMaterialById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "course-material/save", method = RequestMethod.POST)
    public ResponseEntity saveCourseMaterial(@RequestBody CourseMaterialDto courseMaterialDto){
        return new ResponseEntity(courseMaterialService.saveCourseMaterial(courseMaterialDto), HttpStatus.OK);
    }
}

