package ro.ubb.istudent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.ubb.istudent.dto.LectureDto;
import ro.ubb.istudent.service.LectureService;

import java.util.Optional;

@Controller
public class LectureController {

    @Autowired
    private LectureService lectureService;

    @RequestMapping(value="/lecture/{id}", method= RequestMethod.GET)
    public ResponseEntity<LectureDto> getLectureById(@PathVariable String id){
        Optional<LectureDto> lectureDto = lectureService.findLectureById(id);
        return new ResponseEntity(lectureDto.get(), HttpStatus.OK);
    }

    @RequestMapping(value="/lecture/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateLecture(@RequestParam String id, @RequestBody LectureDto lectureDto){
        lectureService.updateLectureById(id, lectureDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value="/lecture/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteLecture(@RequestParam String id){
        lectureService.deleteLectureById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value="/lecture/save", method = RequestMethod.POST)
    public ResponseEntity saveLecture(@RequestBody LectureDto lectureDto){
        return new ResponseEntity(lectureService.saveLecture(lectureDto), HttpStatus.OK);
    }
}
