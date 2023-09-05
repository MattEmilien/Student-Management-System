package me.student.system.controller;

import me.student.system.exception.NoSuchUserException;
import me.student.system.model.Student;
import me.student.system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentRepository repository;


    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Student student) {
        repository.save(student);
    }

    @GetMapping("/grades")
    public double[] getStudentGrades(@RequestParam(value = "name") Student student) {
       return repository.getById(student.getId()).getGrades();
    }

    @DeleteMapping("/")
    public void remove(@RequestParam(value = "name") Student student) {
        repository.delete(student);
    }



    @GetMapping("/")
    public List<Student> getAllStudents() {
        return repository.findAll();
    }


    @GetMapping("/get")
    public Student getStudent(@RequestParam("ID") int id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchUserException("Student with ID " + id + " not found"));
    }


}
