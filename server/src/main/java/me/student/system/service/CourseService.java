package me.student.system.service;

import me.student.system.model.Course;
import me.student.system.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;

    @ResponseStatus(HttpStatus.ACCEPTED)
    public Course saveCourse(Course course) { return repository.save(course); }

    @ResponseStatus(HttpStatus.OK)
    public void removeCourse(int id) { repository.deleteById(id); }

    public List<Course> getCourses() { return repository.findAll(); }

}
