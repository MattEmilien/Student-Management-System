package me.student.system.controller;

import me.student.system.exception.NoSuchUserException;
import me.student.system.model.Student;
import me.student.system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
@Validated
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@Valid @RequestBody Student student) {
        service.save(student);
    }

    @GetMapping("/grades")
    @ResponseStatus(HttpStatus.OK)
    public double[] getStudentGrades(@RequestParam(value = "id") Integer id) {
       return service.getGrades(id);
    }

    @DeleteMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public void remove(@RequestParam(value = "id") Integer id) {
        service.remove(id);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getAllStudents() {
       return service.findAll();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student getStudent(@RequestParam("ID") int id) {
        return service.findByID(id);
    }


}
