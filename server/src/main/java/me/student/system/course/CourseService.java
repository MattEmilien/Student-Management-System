package me.student.system.course;

import me.student.system.course.CourseDTO;
import me.student.system.exception.NoSuchUserException;
import me.student.system.course.Course;
import me.student.system.course.CourseRepository;
import me.student.system.users.User;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.NoSuchElementException;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;

    @Transactional
    public void add(@Valid Course course) {
         repository.save(course);
    }

    @Transactional
    public void remove(@Valid Integer id) {
        if (!repository.existsById(id))
            throw new NoSuchUserException("Course with ID " + id + " not found");
        repository.deleteById(id);
    }


    public Course findByID(@Valid Integer id) {
        return repository.findById(id)
          .orElseThrow(() -> new NoSuchElementException("Course by the ID of " + id + " was not found!"));
    }


    public Page<CourseDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(CourseDTO::new);
    }

    public void update(Integer id, @Valid Course updatedUser) {
        Course existingCourse = repository.findById(id)
          .orElseThrow(() -> new NoSuchUserException("Course with ID " + id + " not found"));

        // Copy props from updatedUser to existingUser
        BeanUtils.copyProperties(updatedUser, existingCourse, "id");

        repository.save(existingCourse);
    }

}
