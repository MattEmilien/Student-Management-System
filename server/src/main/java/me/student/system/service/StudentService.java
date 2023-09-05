package me.student.system.service;

import me.student.system.model.Student;
import me.student.system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @ResponseStatus(HttpStatus.ACCEPTED)
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @ResponseStatus(HttpStatus.OK)
    public void removeStudent(Student student) {
        studentRepository.deleteById(student.getId());
    }

    public List<double[]> getStudentGrades(Student student) {
        return studentRepository.findById(student.getId())
                .stream().map(student1 -> student.getGrades()).collect(Collectors.toList());
    }


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentByName(String name) {
        return null;
    }

}
