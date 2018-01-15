package ro.ubb.istudent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.istudent.dto.AssignmentDto;
import ro.ubb.istudent.service.AssignmentService;

import java.util.Optional;

@RestController
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @RequestMapping(value="/assignment/{id}", method= RequestMethod.GET)
    public ResponseEntity<AssignmentDto> getAssignmentById(@PathVariable String id){
        Optional<AssignmentDto> assignmentDto = assignmentService.findAssignmentById(id);
        return new ResponseEntity<>(assignmentDto.get(), HttpStatus.OK);
    }

    @RequestMapping(value="/assignment/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateAssignment(@RequestParam String id, @RequestBody AssignmentDto assignmentDto){
        assignmentService.updateAssignmentById(id, assignmentDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value="/assignment/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteAssignment(@RequestParam String id){
        assignmentService.deleteAssignmentById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value="/assignment/save", method = RequestMethod.POST)
    public ResponseEntity saveAssignment(@RequestBody AssignmentDto assignmentDto){
        return new ResponseEntity(assignmentService.saveAssignment(assignmentDto), HttpStatus.OK);
    }


}
