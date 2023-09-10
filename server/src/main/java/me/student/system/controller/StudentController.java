package me.student.system.controller;

import me.student.system.exception.NoSuchUserException;
import me.student.system.model.Student;
import me.student.system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Student student) {
        service.save(student);
    }

    @GetMapping("/grades")
    public double[] getStudentGrades(@RequestParam(value = "name") Student student) {
       return service.findByID(student.getId()).getGrades();
    }

    @DeleteMapping("/")
    public void remove(@RequestParam(value = "name") Student student) {
        service.delete(student);
    }



    @GetMapping("/")
    public List<Student> getAllStudents() {
        return new ResponseEntity<>()
    }


    @GetMapping("/get")
    public Student getStudent(@RequestParam("ID") int id) {
        return service.findById(id)
                .orElseThrow(() -> new NoSuchUserException("Student with ID " + id + " not found"));
    }


}
