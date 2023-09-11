package me.student.system.service;

import me.student.system.dto.CourseDTO;
import me.student.system.model.Course;
import me.student.system.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;

    @Transactional
    public Course save(@Valid Course course) {
        return repository.save(course);
    }

    @Transactional
    public void remove(int id) {
        repository.findById(id).ifPresentOrElse(
          course -> repository.deleteById(id),
          () -> { throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found"); }
        );
    }

    public Page<CourseDTO> findAll(Pageable pageable) {
        Page<Course> courses = repository.findAll(pageable);
        return courses.map(CourseDTO::new);
    }
}
