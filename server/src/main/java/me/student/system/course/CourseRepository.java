package me.student.system.course;

import me.student.system.course.Course;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends PagingAndSortingRepository<Course, Integer> {

   Optional<Course> findByName(String name);
   Optional<Course> findBySubject(String subject);

}
