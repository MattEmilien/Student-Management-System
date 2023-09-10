package me.student.system.service;

import lombok.RequiredArgsConstructor;
import me.student.system.model.Student;
import me.student.system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired )
public class StudentService {

    private StudentRepository studentRepository;

    @ResponseStatus(HttpStatus.ACCEPTED)
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @ResponseStatus(HttpStatus.OK)
    public void remove(Student student) {
        studentRepository.deleteById(student.getId());
    }

    public List<double[]> getGrades(Student student) {
        return studentRepository.findById(student.getId())
                .stream().map(student1 -> student.getGrades()).collect(Collectors.toList());
    }


    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findByName(String name) {
        return null;
        // TODO: Add logic
    }

}
