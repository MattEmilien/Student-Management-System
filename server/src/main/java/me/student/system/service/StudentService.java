package me.student.system.service;

import lombok.RequiredArgsConstructor;
import me.student.system.model.Student;
import me.student.system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired )
public class StudentService {

    private StudentRepository studentRepository;

    public void save(@Valid Student student) {
         studentRepository.save(student);
    }

    public void remove(@Valid Integer id) {
        studentRepository.deleteById(id);
    }

    public double[] getGrades(Integer id) {
        var student = studentRepository.findById(id).
          orElseThrow(() -> new NoSuchElementException("Student by the ID of " + id + " was not found!"));
        return student.getGrades();
    }


    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findByName(String name) {
        return studentRepository.findByName(name).
          orElseThrow(() -> new NoSuchElementException("Student by the name of " + name + " was not found!"));
    }

    public Student findByID(Integer id) {
        return studentRepository.findById(id).
          orElseThrow(() -> new NoSuchElementException("Student by the ID of " + id + " was not found!"));
    }

}
