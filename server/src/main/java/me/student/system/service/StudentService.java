package me.student.system.service;

import lombok.RequiredArgsConstructor;
import me.student.system.dto.StudentDTO;
import me.student.system.exception.DuplicateEntryException;
import me.student.system.exception.NoSuchUserException;
import me.student.system.model.Student;
import me.student.system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public void add(@Valid Student student) {
        if (studentRepository.existsByEmail(student.getEmail())) {
            throw new DuplicateEntryException("Email " + student.getEmail() + " is already taken");
        }

        studentRepository.save(student);
    }

    public void remove(@Valid Integer id) {
        if (!studentRepository.existsById(id)) {
            throw new NoSuchUserException("Student with ID " + id + " not found");
        }

        studentRepository.deleteById(id);
    }

    public double[] getGrades(Integer id) {
        var student = studentRepository.findById(id).
          orElseThrow(() -> new NoSuchElementException("Student by the ID of " + id + " was not found!"));
        return student.getGrades();
    }


    public Page<StudentDTO> findAll(Pageable pageable) {
        Page<Student> students = studentRepository.findAll(pageable);

        return students.map(StudentDTO::new);
    }

    public Student findByFirstName(String name) {
        return studentRepository.findByFirstName(name).
          orElseThrow(() -> new NoSuchElementException("Student by the first name of " + name + " was not found!"));
    }

    public Student findByLastName(String name) {
        return studentRepository.findByLastName(name).
          orElseThrow(() -> new NoSuchElementException("Student by the last name of " + name + " was not found!"));
    }

    public Student findByID(Integer id) {
        return studentRepository.findById(id).
          orElseThrow(() -> new NoSuchElementException("Student by the ID of " + id + " was not found!"));
    }

}
