package me.student.system.controller;

import me.student.system.dto.StudentDTO;
import me.student.system.exception.NoSuchUserException;
import me.student.system.model.Student;
import me.student.system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin
@Validated
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Student student) {
        service.add(student);
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


    /*
    Example Request string -> GET /students/?page=1&size=10&sort=lastName,firstName
      *  /students/ is the base URL for the findAll() endpoint.
      *  page=1 specifies that you want to retrieve the first page of results.
      *  size=10 specifies that you want to retrieve 10 students per page.
      *  sort=lastName,firstName indicates that you want to sort the results by first or last name
 */
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public Page<StudentDTO> findAll(
      @RequestParam(name = "page", defaultValue = "0") int page,
      @RequestParam(name = "size", defaultValue = "10") int size,
      @RequestParam(name = "sort", defaultValue = "id") String sort) {

        PageRequest pageable = PageRequest.of(page, size, Sort.by(sort));
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student getStudent(@RequestParam("ID") int id) {
        return service.findByID(id);
    }


}
